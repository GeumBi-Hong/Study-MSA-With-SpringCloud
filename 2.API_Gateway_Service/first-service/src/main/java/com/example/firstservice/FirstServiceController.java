package com.example.firstservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//http://localhost:8081/welcome  -> 우리가 만들어 놓은것은 이건데
//http://localhost:8081/first-service/welcome -> api gate way server 로 부터 받은 요청은 이렇게 온것이다. (그렇기에 404)에러가 뜬것임
//따라서 @RequestMapping("/")를 @RequestMapping("/first-service/") 로 변경한다. second도 마찬가지 이다.
@RestController
@RequestMapping("/")
public class FirstServiceController {

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome to the First Service";
    }

}
