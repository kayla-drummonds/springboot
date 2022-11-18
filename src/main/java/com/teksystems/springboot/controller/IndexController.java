package com.teksystems.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.teksystems.springboot.database.dao.CourseDAO;
import com.teksystems.springboot.database.entity.Course;

@Controller
@RequestMapping
public class IndexController {

    @Autowired
    private CourseDAO courseDAO;

    @GetMapping({ "/", "/index", "/index.html" })
    public ModelAndView slash(@RequestParam(required = false) String searchName,
            @RequestParam(required = false) String searchInstructor) {

        ModelAndView response = new ModelAndView();
        response.setViewName("index");
        response.addObject("name", "Michaela");
        List<Course> coursesByName = courseDAO.findByNameContaining(searchName);
        List<Course> coursesByInstructor = courseDAO.findByInstructorContaining(searchInstructor);
        response.addObject("coursesByName", coursesByName);
        response.addObject("coursesByInstructor", coursesByInstructor);
        response.addObject("searchName", searchName);
        response.addObject("searchInstructor", searchInstructor);
        return response;
    }

    @GetMapping("/search")
    public ModelAndView search() {
        System.out.println("Index controller search request");
        return null;
    }
}
