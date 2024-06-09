package com.spring.gpt.record;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GptRequestTest {

    @Test
    public void testGptRequestSerialization() throws Exception {
        GptRequest gptRequest = new GptRequest("model", Collections.emptyList(), 1.0, 10, 5);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(gptRequest);

        GptRequest deserialized = mapper.readValue(json, GptRequest.class);

        assertEquals(gptRequest.model(), deserialized.model());
        assertEquals(gptRequest.messages(), deserialized.messages());
        assertEquals(gptRequest.temperature(), deserialized.temperature());
        assertEquals(gptRequest.maxTokens(), deserialized.maxTokens());
        assertEquals(gptRequest.topP(), deserialized.topP());
    }
}
