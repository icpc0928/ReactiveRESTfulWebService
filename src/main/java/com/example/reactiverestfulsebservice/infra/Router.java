package com.example.reactiverestfulsebservice.infra;

import com.example.reactiverestfulsebservice.app.router.GreetingHandler;
import com.example.reactiverestfulsebservice.app.router.SummerHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

/**
 * proxyBeanMethods配置类是用来指定@Bean注解标注的方法是否使用代理，默认是true使用代理，直接从IOC容器之中取得对象；
 *      如果设置为false,也就是不使用注解，每次调用@Bean标注的方法获取到的对象和IOC容器中的都不一样，是一个新的对象。
 *
 * Spring 5.2.0+的版本，建议你的配置类均采用Lite模式去做，即显示设置proxyBeanMethods = false。
 * Spring Boot在2.2.0版本（依赖于Spring 5.2.0）起就把它的所有的自动配置类的此属性改为了false，即@Configuration(proxyBeanMethods = false)，提高Spring启动速度
 */
@Configuration(proxyBeanMethods = false)
public class Router {

    //route監聽 /hello 路徑上的流量並返回我們的反應處理程序類提供的值
    //The router listens for traffic on the /hello path and returns the value provided by our reactive handler class.
    @Bean
    public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler){
        return RouterFunctions.route(GET("/hello").and(accept(MediaType.APPLICATION_JSON)), greetingHandler::hello);
    }

    @Bean
    public RouterFunction<ServerResponse> router(SummerHandler summerHandler){
        return RouterFunctions.route(GET("/sum").and(accept(MediaType.APPLICATION_JSON)), summerHandler::sum);
    }
}
