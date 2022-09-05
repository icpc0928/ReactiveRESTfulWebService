package com.example.reactiverestfulsebservice.app.controller;

import com.example.reactiverestfulsebservice.app.router.SummerHandler;
import com.example.reactiverestfulsebservice.domain.entity.TwoNumbers;
import com.example.reactiverestfulsebservice.domain.model.Summer;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.WebHandler;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/controller")
public class ModelController {


    //http://127.0.0.1:8080/controller/10/3
    @GetMapping("/{a}/{b}")
    public Object getSum(@PathVariable("a") int a, @PathVariable("b") int b){
        int result = a + b;
        Summer summer = new Summer(String.valueOf(result));

        return summer;
    }


    //127.0.0.1:8080/controller/summer    body: {"a":10,"b":4}
    @PostMapping("/summer")
    public Object getSumByPosting(@RequestBody TwoNumbers twoNumbers){
        Summer summer = new Summer(twoNumbers.getA(), twoNumbers.getB());
        return summer;
    }

    //127.0.0.1:8080/controller/monoSummer body: {"a":10,"b":4}
    @PostMapping("/monoSummer")
    public Mono<Summer> getMonoSum(@RequestBody TwoNumbers twoNumbers){
        return Mono.just(new Summer(twoNumbers.getA(), twoNumbers.getB()));
    }

    //127.0.0.1:8080/controller/monoSummer/10/3  body: {"a":10,"b":3}
    @GetMapping("/monoSummer/{a}/{b}")
    public Mono<Summer> getMonoSumByGetting(@PathVariable("a") int a, @PathVariable("b") int b){
        //Spring MVC 的前端控制器是 DispatcherServlet，而 WebFlux 是 DispatcherHandler，實作了 WebHandler 介面：
        //public class DispatcherHandler implements "WebHandler"
        WebHandler webHandler;
        //handle => ServerWebExchange 代表著一次 HTTP 請求回應，可以透過它來取得、設定相關請求回應訊息，DispatcherHandler 實作上，就只是取得 mapping、交鉿處理器處理結果：
        //public Mono<Void> handle(ServerWebExchange exchange) {
        //        if (this.handlerMappings == null) {
        //            return this.createNotFoundError();
        //        } else {
        //            return CorsUtils.isPreFlightRequest(exchange.getRequest()) ? this.handlePreFlight(exchange) : Flux.fromIterable(this.handlerMappings).concatMap((mapping) -> {
        //                return mapping.getHandler(exchange);
        //            }).next().switchIfEmpty(this.createNotFoundError()).flatMap((handler) -> {
        //                return this.invokeHandler(exchange, handler);
        //            }).flatMap((result) -> {
        //                return this.handleResult(exchange, result);
        //            });
        //        }
        //    }


        return Mono.just(new Summer(a, b));
    }

}
