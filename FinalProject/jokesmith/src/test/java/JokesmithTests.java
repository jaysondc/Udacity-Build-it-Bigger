import com.example.JokeGenerator;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Created by Jayson Dela Cruz on 1/7/2017.
 */

public class JokesmithTests {

    @Test
    public void jokeValidator(){
        JokeGenerator jokeGen = new JokeGenerator();
        String[] joke = jokeGen.getJoke();
        assertNotNull(joke[0]);
        assertNotNull(joke[1]);
    }
}
