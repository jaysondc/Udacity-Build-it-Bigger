package shakeup.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.JokeSmith;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView jokeText = (TextView) findViewById(R.id.joke);
        JokeSmith jokeSmith = new JokeSmith();
        jokeText.setText(jokeSmith.getJoke());
    }
}
