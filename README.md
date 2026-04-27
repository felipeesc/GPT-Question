# GPT-Question

Spring Boot API that communicates with OpenAI asynchronously using Project Reactor.

## Tech Stack

- Java 17
- Spring Boot 3.3.0
- Project Reactor (WebFlux)
- Maven
- Swagger/OpenAPI

## Prerequisites

- Java 17+
- Maven 3.8+
- OpenAI API Key

## Configuration

Crie um `application.properties` local (não commitar):

```properties
openai.api.key=YOUR_OPENAI_API_KEY
```

## Running

```bash
./mvnw spring-boot:run
```

## Build

```bash
./mvnw clean package
```

## API Docs

Após subir a aplicação:

```
http://localhost:8080/swagger-ui.html
```

## How it works

A requisição é enviada para a OpenAI API e a resposta é retornada de forma assíncrona via `Flux`/`Mono`, sem bloquear threads.

## Reference

- [OpenAI API Docs](https://platform.openai.com/docs/examples/default-interview-questions)
- [Spring Reactive](https://spring.io/reactive)
