package com.spring.gpt.record;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

// Annotation to serialize CamelCase, despite them being SnakeCase
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record GptRequest(
        String model,
        List<Messages.Message> messages,
        Double temperature,
        Integer maxTokens,
        int topP
) {}
