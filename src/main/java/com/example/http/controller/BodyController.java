package com.example.http.controller;

import com.example.http.dto.ArticleDto;
import com.example.http.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class BodyController {
    // body method => Domain '/body' 로 요청이 들어왔을 때, ResponseDto data 를 표현한 JSON 응답을 반환하는 method
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
}
