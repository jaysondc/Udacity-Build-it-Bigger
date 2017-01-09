package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.example.jaysondelacruz.myapplication.jokesbackend.myApi.MyApi;
import com.example.jaysondelacruz.myapplication.jokesbackend.myApi.model.Joke;
import com.example.jokedisplay.JokeMain;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by Jayson Dela Cruz on 1/9/2017.
 */

public class JokeAsyncTask extends AsyncTask<Context, Void, Joke> {
    private MyApi myApiService = null;
    private Context context;

    public final String EXTRA_SETUP = "EXTRA_SETUP";
    public final String EXTRA_PUNCHLINE = "EXTRA_PUNCHLINE";

    @Override
    protected com.example.jaysondelacruz.myapplication.jokesbackend.myApi.model.Joke doInBackground(Context... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        // Keep context if it's provided
        context = (params.length != 0) ? params[0] : null;

        try {
            return myApiService.getJoke().execute();
        } catch (IOException e) {
            Log.d(getClass().getSimpleName(), e.getMessage());
            return null;
        }
    }

    @Override
    protected void onPostExecute(com.example.jaysondelacruz.myapplication.jokesbackend.myApi.model.Joke result) {

        // Pass joke as extras and launch display only if context is provided
        if(context != null){
            Intent intent = new Intent(context, JokeMain.class);
            intent.putExtra(EXTRA_SETUP, result.getSetup());
            intent.putExtra(EXTRA_PUNCHLINE, result.getPunchline());

            context.startActivity(intent);
        }
    }
}
