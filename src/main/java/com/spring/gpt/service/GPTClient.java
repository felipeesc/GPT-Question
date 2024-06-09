package com.spring.gpt.service;

import com.spring.gpt.config.GptProperties;
import com.spring.gpt.record.GptRequest;
import com.spring.gpt.record.GptResponse;
import com.spring.gpt.record.Messages;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;


@Service
public class GPTClient {

    private WebClient webclient;
    private final GptProperties gptProperties;


    public GPTClient(WebClient.Builder webclientBuilder, @Value("${gpt.key}") String key, GptProperties gptProperties) {
        this.gptProperties = gptProperties;
        this.webclient = webclientBuilder.baseUrl(gptProperties.getUrl())
                .defaultHeader("Content-Type", "application/json")
                .defaultHeader("Authorization", "Bearer " + key)
                .build();
    }

    public Mono<GptResponse> communicatesGpt(String mensagem) {
        GptRequest requisicao = createRequisition(mensagem);
        return Mono.delay(Duration.ofSeconds(1)).then(webclient.post().bodyValue(requisicao)
                .retrieve().bodyToMono(GptResponse.class));
    }

    private GptRequest createRequisition(String mensagem) {

        Messages.Message msg = new Messages.Message("user", mensagem);

        return new GptRequest(
                gptProperties.getModel(),
                List.of(msg),
                gptProperties.getTemperature(),
                gptProperties.getMaxTokens(),
                gptProperties.getTopP()
        );
    }
}


