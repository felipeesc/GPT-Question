package com.spring.gpt.record;

import java.util.List;

public record Messages(List<Message> messages) {
    public record Message(String role, String content) {
    }
}
