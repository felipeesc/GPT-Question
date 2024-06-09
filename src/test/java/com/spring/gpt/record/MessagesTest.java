package com.spring.gpt.record;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessagesTest {

    @Test
    public void testMessages() {
        List<Messages.Message> messagesList = List.of(
                new Messages.Message("role1", "content1"),
                new Messages.Message("role2", "content2")
        );

        Messages messages = new Messages(messagesList);
        assertEquals(messagesList, messages.messages());
    }
}
