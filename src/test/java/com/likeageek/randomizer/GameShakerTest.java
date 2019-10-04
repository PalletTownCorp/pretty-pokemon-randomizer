package com.likeageek.randomizer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

import static com.likeageek.randomizer.ConfigurationBuilder.configuration;
import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;
import static org.assertj.core.api.Assertions.assertThat;

public class GameShakerTest {

    private GameShaker gameShaker;

    @BeforeEach
    public void setUp() throws FileNotFoundException {
        PrintStream printStream = new PrintStream("out.log");
        System.setOut(printStream);

        Configuration configuration = configuration()
                .seed(424242)
                .pokemonDirectory("/home/likeageek/Projects/randomizer-output/")
                .outputDirectory("/home/likeageek/Projects/randomizer-output/")
                .build();
        gameShaker = new GameShaker(configuration);
        gameShaker.load();
    }

    @Test
    public void shouldShakeAndDisplayShuffler() throws IOException {
        gameShaker.shake();

        String consoleOutput = new String(readAllBytes(get("out.log")));
        assertThat(consoleOutput).contains("arena shuffler");
        assertThat(consoleOutput).contains("empty shuffler");
    }

}