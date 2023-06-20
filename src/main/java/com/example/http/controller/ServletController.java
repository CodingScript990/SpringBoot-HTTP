package com.example.http.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.BufferedReader;
import java.io.IOException;

@Slf4j
@Controller
public class ServletController {

    // Servlet method
    @PostMapping("/servlet")
    public void servletHandling(HttpServletRequest req, HttpServletResponse res) throws IOException {
        BufferedReader reader = req.getReader();
        reader.lines().forEach(line -> log.info(line));
        res.setStatus(200);
    }
}
