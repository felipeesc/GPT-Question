package com.spring.gpt.mapper;

import com.spring.gpt.record.GptResponse;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

public class GptResponseMapperTest {

    @Test
    public void testExtractAnswerWithResponse() {
        GptResponse gptResponse = new GptResponse(List.of(new GptResponse.Choice("Mocked answer")));

        Mono<String> resultMono = GptResponseMapper.extractAnswer(gptResponse);

        StepVerifier.create(resultMono)
                .expectNext("Mocked answer")
                .verifyComplete();
    }

}