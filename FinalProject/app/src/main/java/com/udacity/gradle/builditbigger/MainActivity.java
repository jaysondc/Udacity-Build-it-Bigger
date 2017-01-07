package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.JokeGenerator;
import com.example.jokedisplay.JokeMain;


public class MainActivity extends AppCompatActivity {

    public final String EXTRA_SETUP = "EXTRA_SETUP";
    public final String EXTRA_PUNCHLINE = "EXTRA_PUNCHLINE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        JokeGenerator jokeGen = new JokeGenerator();
        String[] joke = jokeGen.getJoke();

        // Pass joke as extras and launch display
        Intent intent = new Intent(this, JokeMain.class);
        intent.putExtra(EXTRA_SETUP, joke[0]);
        intent.putExtra(EXTRA_PUNCHLINE, joke[1]);

        startActivity(intent);
    }

}
