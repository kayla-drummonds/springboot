package com.teksystems.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.teksystems.springboot.database.dao.CourseDAO;
import com.teksystems.springboot.database.entity.Course;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping
public class IndexController {

    @Autowired
    private CourseDAO courseDAO;

    @GetMapping({ "/", "/index", "/index.html" })
    public ModelAndView slash(@RequestParam(required = false) String courseName,
            @RequestParam(required = false) String instructorName) {

        ModelAndView response = new ModelAndView();
        response.setViewName("index");
        response.addObject("name", "Michaela");
        response.addObject("courseName", courseName);
        response.addObject("instructorName", instructorName);

        // if (courseName != null && !courseName.equals("")) {
        // List<Course> coursesByName = courseDAO.findByNameContaining(courseName);
        List<Course> courses = courseDAO.findByNameOrInstructor(courseName, instructorName);
        // response.addObject("coursesByName", coursesByName);
        response.addObject("courses", courses);
        // }
        return response;
    }

    @GetMapping("/search")
    public ModelAndView search() {
        System.out.println("Index controller search request");
        return null;
    }

    @GetMapping("/course")
    public ModelAndView course() {
        log.info("Index controller course request method");
        ModelAndView response = new ModelAndView();
        response.setViewName("course");

        return response;
    }

    @GetMapping("/courseSubmit")
    public ModelAndView courseSubmit(@RequestParam(required = false) String courseName,
            @RequestParam(required = false) String instructorName) {
        ModelAndView response = new ModelAndView();
        response.setViewName("course");

        log.debug("Index controller course submit method");
        log.info("Course submit: courseName: " + courseName);
        log.info("Course submit: instructorName: " + instructorName);

        List<String> errorMessages = new ArrayList<>();

        if (courseName == null || courseName.equals("")) {
            errorMessages.add("The course name cannot be empty");
        }

        if (instructorName == null || instructorName.equals("")) {
            errorMessages.add("The instructor name cannot be empty");
        }

        if (!errorMessages.isEmpty()) {
            for (String error : errorMessages) {
                log.info(error);
            }
            response.addObject("errors", errorMessages);
            response.addObject("courseName", courseName);
            response.addObject("instructorName", instructorName);
        } else {
            Course course = new Course();
            course.setName(courseName);
            course.setInstructor(instructorName);

            courseDAO.save(course);
        }

        return response;
    }
}
