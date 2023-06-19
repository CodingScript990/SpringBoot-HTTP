package com.example.http.dto;

import lombok.Data;

// blog 게시글
// 게시글 - title, content
/*
     [JSON type]
{
  "title" : "제목",
  "content" : "content"
}
*/
@Data
public class ArticleDto {
    // Member Field
    private String title;
    private String content;
}
