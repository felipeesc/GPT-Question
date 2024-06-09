package com.spring.gpt.controller;

import com.spring.gpt.mapper.GptResponseMapper;
import com.spring.gpt.service.GPTClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class GptController {

    private final GPTClient gptClient;

    public GptController(GPTClient gptClient) {
        this.gptClient = gptClient;
    }

    @PostMapping("question")
    public Mono<String> getAnswer(@RequestBody String mensagem) {
        return gptClient.communicatesGpt(mensagem)
                .flatMap(GptResponseMapper::extractAnswer)
                .onErrorResume(e -> Mono.just("An error occurred while getting the response: " + e.getMessage()));
    }

}
