package com.teksystems.springboot.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// import com.teksystems.springboot.database.dao.CourseDAO;
// import com.teksystems.springboot.database.entity.Course;

@Controller
@RequestMapping
public class IndexController {

    /*
     * @Autowired
     * private CourseDAO courseDAO;
     */

    @GetMapping({ "/", "/index", "/index.html" })
    public ModelAndView slash() {

        ModelAndView response = new ModelAndView();
        response.setViewName("index");
        // System.out.println("Index controller request");
        // List<Course> courses = courseDAO.findByCourseName("Art & Design");

        // for(Course c : courses) {
        // System.out.println(c.getName());
        return response;

    }

    @GetMapping({ "/search", "/search.html" })
    public ModelAndView search() {
        System.out.println("Index controller search request");
        return null;
    }
}
