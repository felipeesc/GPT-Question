package com.spring.gpt.record;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

// Anotação para serializar CamelCase, apesar delas serem SnakeCase na request da open
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record GptRequest(
        String model,
        List<Messages.Message> messages,
        Double temperature,
        Integer maxTokens,
        int topP
) {}
