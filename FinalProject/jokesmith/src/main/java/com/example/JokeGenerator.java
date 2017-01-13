package com.example;

public class JokeGenerator {

    String setups[] = {
            "What did the bra say to the hat?",
            "How do locomotives know where they're going?",
            "Mountains aren't just funny,",
            "How many South Americans does it take to change a light bulb?",
            "How do you find Will Smith in  the snow?",
            "What cheese is always by itself?",
            "Did you hear about the cheese factory in  France that exploded?",
            "In what state do you watch a priest, sneeze, then sit down?",
            "What's the internal temperature of a tauntaun?"
    };

    String punchlines[] = {
            "You go on a head, I'll give these two a lift.",
            "Lots of training.",
            "they're hill areas.",
            "A Brazilian!",
            "Look for the fresh prints.",
            "Provolone.",
            "There was nothing left but de brie.",
            "Massachusetts.",
            "Luke warm."
    };

    public com.example.Joke getJoke(){
        int i = (int) Math.floor(Math.random() * setups.length);

        return new com.example.Joke(setups[i], punchlines[i]);
    }
}
