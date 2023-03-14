package com.example.firstservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//http://localhost:8081/welcome  -> 우리가 만들어 놓은것은 이건데
//http://localhost:8081/first-service/welcome -> api gate way server 로 부터 받은 요청은 이렇게 온것이다. (그렇기에 404)에러가 뜬것임
//따라서 @RequestMapping("/")를 @RequestMapping("/first-service/") 로 변경한다. second도 마찬가지 이다.
@Slf4j
@RestController
@RequestMapping("/first-service")
public class FirstServiceController {

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome to the First Service";
    }


    //message로 매핑되어 들어오면 message()함수가 실행되면서 first-request의 이름을 가진 헤더값을 가져올 것이다. 이 값은 String header에 저장된다.
    @GetMapping("/message")

    public String message(@RequestHeader("first-request") String header){
        log.info(header);
        return "Hello World in First Service";

    }

    //CustomFilter 확인해보기
    @GetMapping("/check")
    public String check(){
        return " Hi . This is a message from First Service";
    }


}
