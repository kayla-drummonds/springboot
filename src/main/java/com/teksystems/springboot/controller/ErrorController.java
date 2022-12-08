package com.teksystems.springboot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@ControllerAdvice
public class ErrorController {

    @GetMapping("/error/404")
    public String error404(HttpServletRequest request) {
        String originalUri = (String) request.getAttribute("javax.servlet.forward.request_uri");
        log.error("Requested URL not found : " + request.getMethod() + " " + originalUri);
        return "error/404";
    }

}
