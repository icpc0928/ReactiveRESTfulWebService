package com.example.reactiverestfulsebservice.app.controller;

import com.example.reactiverestfulsebservice.app.router.SummerHandler;
import com.example.reactiverestfulsebservice.domain.entity.TwoNumbers;
import com.example.reactiverestfulsebservice.domain.model.Summer;
import org.springframework.web.bind.annotation.*;

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
        int result = twoNumbers.getA() + twoNumbers.getB();
        Summer summer = new Summer(String.valueOf(result));
        return summer;
    }

}
