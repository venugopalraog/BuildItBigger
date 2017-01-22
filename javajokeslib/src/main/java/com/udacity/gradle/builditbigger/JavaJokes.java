package com.udacity.gradle.builditbigger;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class JavaJokes {

    public static final int JOKES_LIST_SIZE = 12;
    private List<String> jokeList = Arrays.asList("When your only tool is a hammer, all problems start looking like nails.",
                                        "99 percent of lawyers give the rest a bad name.",
                                        "Artificial intelligence is no match for natural stupidity.",
                                        "I don't have a solution, but I do admire the problem.",
                                        "The only substitute for good manners is fast reflexes.",
                                        "Support bacteria - they're the only culture some people have.",
                                        "Letting the cat out of the bag is a whole lot easier than putting it back in.",
                                        "Well, here I am! What are your other two wishes?",
                                        "My conscience is clean — I have never used it.",
                                        "Sugar - Honey - Iced - Tea ... Guess what it means.",
                                        "I want to go to IKEA, hide in a wardrobe, wait for someone to open it and yell \"WELCOME TO NARNIA\".",
                                        "Life isn't about waiting for the storm to pass ... it's about learning to dance in the rain!");

    public String getJokes() {
        Random rand = new Random();
        return jokeList.get(rand.nextInt(JOKES_LIST_SIZE));
    }
}
