package com.example.calculator_7_webProgram.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/result") // 해당 주소로 시작하면 받겠다.
public class StrCalculatorController {

    @GetMapping(path = "/strCalculator") // /result 주소 중에서도 /calcultor 주소를 처리함
    public String hello(){
        return "hello, Spring Boot";
    }
}
