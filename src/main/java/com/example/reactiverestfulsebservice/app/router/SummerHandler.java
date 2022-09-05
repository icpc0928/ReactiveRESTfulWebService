package com.example.reactiverestfulsebservice.app.router;

import com.example.reactiverestfulsebservice.domain.entity.TwoNumbers;
import com.example.reactiverestfulsebservice.domain.model.Summer;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class SummerHandler {

    public Mono<ServerResponse> sum(ServerRequest request){
        Summer summer = new Summer();
        System.out.println("Hello~~twoNum~" + request.toString());
        System.out.println(request.queryParam("a"));
        int a = Integer.parseInt(request.queryParam("a").get());
        int b = Integer.parseInt(request.queryParam("b").get());

        TwoNumbers twoNumbers = new TwoNumbers(a, b);

        System.out.println(twoNumbers.toString());
        int result = twoNumbers.getA() + twoNumbers.getB();
        summer.setResult(String.valueOf(result));

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(summer));

    }
}
