package com.example.http.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class HeaderController {

    // getHeader method => Domain '/header-one'
    // 헤더 중 'x-likelion' 이라는 header 의 값을 인자로 전달받고 싶을 때
    @PostMapping("/header-one")
    public String getHeader(@RequestHeader("x-likelion") String header) { // header 매개변수
        log.info("POST /header-one header: " + header); // header 값을 출력
        return "index"; // html file 반환
    }

    // getHeaderOptional method => Domain 'header-optional'
    // 헤더 중 'x-likelion' 이 있으면 할당, 없으면 null 로 받고 싶을 때
    @PostMapping("/header-optional")
    public String getHeaderOptional(@RequestHeader(value = "x-likelion", required = false) String header) {
        log.info("POST /header-optional header: " + header); // header 값을 출력
        return "index"; // html file 반환
    }

    // getHeaderInteger method => Domain 'header-type' 으로 들어온 HTTP 요청에 대하여
    // 헤더 중 'x-lieklion-int' 가 있으면 Integer 에 할당
    @PostMapping("/header-type")
    public String getHeaderInteger(@RequestHeader(value = "x-likelion-int") Integer header) { // 정수형 int value 만 가능
        log.info("POST /header-type header: " + header); // header 값을 출력
        return "index"; // html file 반환
    }

    // getHeaderAll method => Domain 'header-all' 로 들어온 HTTP 요청의 모든 header 를 확인하고 싶을 때
    @PostMapping("/header-all")
    public String getHeaderAll(@RequestHeader  // @RequestHeader : 모든 헤더를 다 가져올 때
                                   //Map<String, String> headerMap
                              // MultiValueMap<String, String> headerMap
                                   HttpHeaders headerMap
    ) {
        log.info("POST /header-all"); // header-all 출력

        // headerMap 값을 출력 => Map<String, String>
        /*
        for (Map.Entry<String, String> entry : headerMap.entrySet()) {
            log.info(String.format("%s: %s", entry.getKey(), entry.getValue()));
        }
         */
        // headerMap 값을 출력 => MultiValueMap<String, String>
        for (Map.Entry<String, List<String>> entry : headerMap.entrySet()) {
            log.info(String.format("%s: %s", entry.getKey(), entry.getValue()));
        }
        return "index"; // html file 반환
    }
}
