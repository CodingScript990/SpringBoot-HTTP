package com.example.http.controller;

import com.example.http.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class BodyController {
    // body method => Domain '/body' 로 요청이 들어왔을 때, ResponseDto data 를 표현한 JSON 응답을 반환하는 method
    /*
    @PostMapping("/body")
    // @ResponseBody : HTTP 응답의 Body 임을 나타내는 Annotation
    public @ResponseBody ResponseDto body( // type => ResponseDto, method name => body
            @RequestBody ArticleDto requestDto
            ) {
        // requestDto 를 출력
        log.info(requestDto.toString());

        // 인스턴스화
        ResponseDto repDto = new ResponseDto();

        // responseDto 설정 => data 정의를 직접 설정해주는 것
        repDto.setStatus(200); // status
        repDto.setMessage("success"); // message

        return repDto; // responseDto 의 값을 반환
    }
     */

    // body method => Domain '/body' 로 요청이 들어왔을 때, ResponseDto data 를 표현한 JSON  과 함께 응답을 반환하는 method
    @PostMapping("/body")
    @ResponseBody
    public ResponseDto body(@RequestBody ArticleDto dto) { // 매개변수로 정의해줌 => json type data[RequestBody : method 를 읽어들이는 작업]
        log.info("POST /body " + dto.toString());
        ResponseDto response = new ResponseDto();
        response.setMessage("success");
        response.setStatus(200);
        return response;
    }

    // body2 method => Domain '/body-2' 로 요청이 들어왔을 때, ResponseDto data 를 표현한 JSON  과 함께 응답을 반환하는 method
    @PostMapping("/body-2")
    @ResponseBody
    public ResponseDto body2(@RequestBody UserDto dto) { // 매개변수로 정의해줌 => UserDto
        log.info("POST /body-2 " + dto.toString());
        ResponseDto response = new ResponseDto();
        response.setMessage("success");
        response.setStatus(200);
        return response;
    }

    // body3 method => Domain '/body-3' 로 요청이 들어왔을 때, ResponseDto data 를 표현한 JSON  과 함께 응답을 반환하는 method
    @PostMapping("/body-3")
    @ResponseBody
    public ResponseDto body3(@RequestBody ArticleWithCommentsDto dto) { // 매개변수로 정의해줌 => ArticleWithCommentsDto
        log.info("POST /body-3 " + dto.toString());
        return new ResponseDto();
    }

    // body4 method => Domain '/body-4' 로 요청이 들어왔을 때, ResponseDto data 를 표현한 JSON  과 함께 응답을 반환하는 method
    @PostMapping("/body-4")
    @ResponseBody
    public ResponseDto body4(@RequestBody ArticleComplexDto dto) { // 매개변수로 정의해줌 => ArticleComplexDto
        log.info("POST /body-4 " + dto.toString());
        return new ResponseDto();
    }

    // @ResponseBody 는 요청의 HTTP Body 만 설정함
    // Header 를 추가하거나 Status code 를 고르고 싶을 때 ResponseEntity<T>
    @PostMapping("/entity")
    public ResponseEntity<ResponseDto> entity(
            @RequestBody
            ArticleDto dto
    ) {
        log.info("POST /entity " + dto.toString());

        ResponseDto response = new ResponseDto();

        response.setMessage("success");
        response.setStatus(200);

        // ResponseEntity 객체 를 사용
        ResponseEntity<ResponseDto> responseEntity = new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        // OK[200], CREATE[201], ACCEPTED[202], ,INTERNAL_SERVER_ERROR[500],
        // responseEntity value 를 반환함
        //return responseEntity;

        // HttpHeaders 를 이용하여 http 통신을 보다 쉽게 사용하는 작업
        // 커스텀 헤더 만들고 함께 응답하기
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-liklion-custom", "hello world!");
        // ResponseEntity 의 값 response, headers, HttpStatus 의 상태값을 반환 받음
        //return new ResponseEntity<>(response, headers, HttpStatus.ACCEPTED);

        // ResponseEntity 를 사용하여 Builder pattern 형태로 결과값을 표현함
        // Builder 사용함 => ok, badRequest, InternalServerError 를 주로 사용함
        // 주로 이 형태로 많이 사용함[주로 이렇게 서비스를 관리함]
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("x-liklion-one", "1")
                .headers(headers)
                .body(response);
    }
}
