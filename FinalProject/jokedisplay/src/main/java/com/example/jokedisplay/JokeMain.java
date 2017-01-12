package com.example.jokedisplay;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeMain extends AppCompatActivity {
    public final String EXTRA_SETUP = "EXTRA_SETUP";
    public final String EXTRA_PUNCHLINE = "EXTRA_PUNCHLINE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_main);

        // Send broadcast to notify calling activity that we've loaded the joke
        Intent broadcastIntent = new Intent("joke_loaded");
        LocalBroadcastManager.getInstance(this).sendBroadcast(broadcastIntent);

        // Retrieve extras
        Intent intent = getIntent();
        String setup = intent.getStringExtra(EXTRA_SETUP);
        String punchline = intent.getStringExtra(EXTRA_PUNCHLINE);

        // Display joke
        TextView setupView = (TextView) findViewById(R.id.setupText);
        TextView punchlineView = (TextView) findViewById(R.id.punchlineText);
        setupView.setText(setup);
        punchlineView.setText(punchline);
    }
}
