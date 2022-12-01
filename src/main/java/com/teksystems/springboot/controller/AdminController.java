package com.teksystems.springboot.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @GetMapping("/admin/admintest")
    public ModelAndView adminTest() {
        ModelAndView response = new ModelAndView();

        response.setViewName("admin/admin");
        return response;
    }
}
