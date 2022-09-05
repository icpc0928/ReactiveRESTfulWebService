package com.example.reactiverestfulsebservice.app.router;

import com.example.reactiverestfulsebservice.domain.model.Summer;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class SummerClient {

    private final WebClient client;


    public SummerClient(WebClient.Builder builder) {
        this.client = builder.baseUrl("http://localhost:8080").build();
    }

    //已經把GreetingClient放在Application了~這裡可以不用做這些事情
    //http://127.0.0.1:8080/sum?a=10&b=3
//    public Mono<String> getSumResult(){
//        System.out.println("Hello");
//        return this.client.get().uri("/sum").accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .bodyToMono(Summer.class)
//                .map(Summer::getResult);
//    }
}
