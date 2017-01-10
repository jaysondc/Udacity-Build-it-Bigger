import android.test.AndroidTestCase;
import android.test.mock.MockContext;
import android.test.suitebuilder.annotation.SmallTest;

import com.example.jaysondelacruz.myapplication.jokesbackend.myApi.model.Joke;
import com.udacity.gradle.builditbigger.JokeAsyncTask;
import com.udacity.gradle.builditbigger.MainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static android.support.v7.widget.AppCompatDrawableManager.get;
import static junit.framework.Assert.fail;
import static junit.framework.TestCase.assertNotNull;

/**
 * Created by Jayson Dela Cruz on 1/9/2017.
 */

public class AppTests{

    @Test
    public void testAsyncJokeTask() throws Throwable{
        try {
            JokeAsyncTask jokeTask = new JokeAsyncTask();
            Joke joke = jokeTask.execute().get(30, TimeUnit.SECONDS);

            assertNotNull(joke);
            assertNotNull(joke.getSetup());
            assertNotNull(joke.getPunchline());
        } catch (Exception e){
            fail("Timeout");
        }
    }
}
