package com.spring.gpt.record;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GptResponseTest {

    @Test
    public void testGptResponse() {
        List<GptResponse.Choice> choices = List.of(new GptResponse.Choice("Choice 1"), new GptResponse.Choice("Choice 2"));
        GptResponse gptResponse = new GptResponse(choices);
        assertEquals(choices, gptResponse.choices());
    }
}
