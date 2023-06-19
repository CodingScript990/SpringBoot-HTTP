package com.example.http.dto;

import lombok.Data;

// 일반적인 응답
// Status, Message
/*
    [JSON type]
{
    "status" : 200,
    "message" : "success"
}
*/
@Data
public class ResponseDto {
    // Member Field
    private Integer status;
    private String  message;
}
