package com.teksystems.springboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.teksystems.springboot.database.dao.CourseDAO;
import com.teksystems.springboot.database.entity.Course;
import com.teksystems.springboot.form.CourseFormBean;

@Controller
public class CourseController {

    @Autowired
    private CourseDAO courseDAO;

    @GetMapping("/course/create")
    public ModelAndView createCourse(CourseFormBean form) {
        ModelAndView response = new ModelAndView();
        response.setViewName("course/coursecreate");

        return response;
    }

    @PostMapping("/course/save")
    public ModelAndView createCourseSubmit(@Valid CourseFormBean form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView();
        response.setViewName("redirect:/index?name=" + form.getName());

        if (!bindingResult.hasErrors()) {

            Course course = courseDAO.findCourseById(form.getId());
            if (course == null) {
                course = new Course();
            }

            course.setName(form.getName());
            course.setInstructor(form.getInstructor());

            courseDAO.save(course);
        } else {
            response.addObject("bindingResult", bindingResult);
            response.addObject("form", form);
        }

        return response;
    }

    @GetMapping("/course/edit")
    public ModelAndView courseEdit(@RequestParam(required = true) Integer id) {
        ModelAndView response = new ModelAndView();
        response.setViewName("course/coursecreate");

        Course course = courseDAO.findCourseById(id);

        CourseFormBean form = new CourseFormBean();

        form.setId(course.getId());
        form.setName(course.getName());
        form.setInstructor(course.getInstructor());

        response.addObject("form", form);

        return response;
    }
}
