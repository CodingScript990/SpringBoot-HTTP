package com.example.http.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j // log variable 만들어줌
@Controller
public class MappingController {

    // Member Field
//    private static final Logger logger = LoggerFactory.getLogger(MappingController.class);

    // getPath method => Domain '/path' 로 오는 요청에 대해서 method 를 실행하고 싶을때
    @RequestMapping(value = "/path", method = RequestMethod.GET)
    public String getPath() {
        log.info("GET /path"); // get 요청이 이루어지면 get /path 가 output 으로 보여짐
        return "index"; // html file 을 반환함
    }

    // postPath method => Domain '/path' 로 오는 POST 요청에 대해서 method 를 실행하고 싶을때
    @RequestMapping(value = "/path", method = RequestMethod.POST)
    public String postPath() {
        log.info("POST /path"); // post 요청이 이루어지면 post /path 가 output 으로 보여짐
        return "index"; // index 로 반환함
    }

    // putOrDeletePath method => Domain '/path' 로 오는 put or delete 요청에 대해서 메서드를 실행하고 싶을 때
    @RequestMapping(value = "/path", method = { RequestMethod.PUT, RequestMethod.DELETE })
    public String putOrDeletePath() {
        log.info("PUT or Delete /path"); // put, delete 요청이 이루어지면 put,delete /path 가 output 으로 보여짐
        return "index"; // index 로 반환함
    }

    // consumes method => Domain '/path' 로 오는 POST 요청이면서 JSON 데이터를 포함하는 요청에 대해서 method 를 실행하고 싶을때
    @RequestMapping(value = "/path", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String consumes() {
        // POST 요청이 이루어지면 POST /path Content-Type: application/json message 가 output 으로 보여짐
        log.info("POST /path Content-Type: application/json");
        return "index"; // index 로 반환함
    }

    // headerWith method => Domain '/path'  로 오는 POST 요청이면서 헤더에 x-likelion 이라는 헤더가 값이 hello 로 지정되어 있을 때
    // method 를 실행하고 싶을 때
    @RequestMapping(value = "/path", method = RequestMethod.POST, headers = "x-likelion=hello")
    public String headerWith() {
        log.info("POST /path with x-likelion=hello");
        return "index";
    }

    // params method => Domain '/path' 로 오는 POST 요청이면서 Query Parameter 로 likelion 이 hello 로 할당되어 있을 때 method 실행하고 싶을 때
    @RequestMapping(value = "/path", method = RequestMethod.POST, params = "likelion=hello")
    public String params() {
        log.info("POST /path parameter likelion=hello");
        return "index";
    }
}
