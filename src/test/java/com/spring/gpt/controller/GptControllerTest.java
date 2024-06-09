package com.spring.gpt.controller;

import com.spring.gpt.record.GptResponse;
import com.spring.gpt.service.GPTClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GptControllerTest {

    @Mock
    private GPTClient gptClientMock;

    @InjectMocks
    private GptController gptController;

    @Test
    public void testGetAnswer() {
        String response = "Mocked answer";
        GptResponse mockedResponse = new GptResponse(List.of(new GptResponse.Choice(response)));
        when(gptClientMock.communicatesGpt(anyString())).thenReturn(Mono.just(mockedResponse));

        Mono<String> resultMono = gptController.getAnswer("Mocked message");

        StepVerifier.create(resultMono)
                .expectNext(response)
                .verifyComplete();
    }

}
