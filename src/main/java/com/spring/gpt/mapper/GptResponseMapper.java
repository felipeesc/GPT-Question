package com.spring.gpt.mapper;

import com.spring.gpt.record.GptResponse;
import reactor.core.publisher.Mono;

public class GptResponseMapper {

    public static Mono<String> extractAnswer(GptResponse resposta) {
        return Mono.justOrEmpty(resposta.choices().stream()
                .findFirst()
                .map(GptResponse.Choice::text)
                .map(String::trim)
                .orElse("No response was received from GPT."));
    }
}

