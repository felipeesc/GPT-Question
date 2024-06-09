package com.spring.gpt.record;

import java.util.List;

public record GptResponse(List<Choice> choices) {
    public static record Choice(String text) {}
}
