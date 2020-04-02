package com.mycompany.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetingTest {

    @Test
    public void shouldReturnHelloChip_whenInputIsChip(){
        Greeting greeting = new Greeting();

        String result = greeting.greet("Chip");

        assertEquals("Hello Chip", result);
}
    }
