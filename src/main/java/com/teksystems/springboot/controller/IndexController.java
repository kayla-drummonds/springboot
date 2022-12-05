package com.teksystems.springboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.teksystems.springboot.config.AuthenticatedUserService;
import com.teksystems.springboot.database.dao.CourseDAO;
import com.teksystems.springboot.database.dao.StudentDAO;
import com.teksystems.springboot.database.entity.Course;
import com.teksystems.springboot.database.entity.Student;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping
public class IndexController {

    @Autowired
    private CourseDAO courseDAO;

    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private AuthenticatedUserService authService;

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

    @ResponseBody
    @GetMapping("/course/path/{id}")
    public Course pathVar(@PathVariable Integer id, HttpSession session) {
        log.info("Incoming path variable = " + id);
        Course c = courseDAO.findCourseById(id);
        log.info("This is my course name: " + c.getName());

        if (session.getAttribute("key") == null) {
            log.info("Key not found in session");
            session.setAttribute("key", "value");
        } else {
            log.info("Key is in the session");
        }
        return c;
    }

    @ResponseBody
    @GetMapping("/courses/all")
    public List<Course> allCourses() {
        log.error("This is an error");
        log.warn("This is a warning");
        log.info("This is info");
        log.debug("This is debug");

        List<Course> courses = courseDAO.findAll();
        return courses;
    }

    @PostMapping("/courseSubmit")
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

    @GetMapping("/student")
    public ModelAndView student() {
        log.info("Index controller student request method");
        ModelAndView response = new ModelAndView();
        response.setViewName("student");

        return response;
    }

    @GetMapping("/studentSubmit")
    public ModelAndView studentSubmit(@RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName, @RequestParam(required = false) String city,
            @RequestParam(required = false) String state, @RequestParam(required = false) Integer zip) {
        ModelAndView response = new ModelAndView();
        response.setViewName("student");

        log.debug("Index controller student submit method");

        List<String> errorMessages = new ArrayList<>();
        List<String> successMessages = new ArrayList<>();
        Pattern zipPattern = Pattern.compile(zip.toString());
        Matcher m = zipPattern.matcher("[0-9]{5}");
        boolean zipMatch = m.matches();

        if (firstName.isEmpty()) {
            errorMessages.add("The first name field cannot be empty");
        }

        if (lastName.isEmpty()) {
            errorMessages.add("The last name field cannot be empty");
        }

        if (city.isEmpty()) {
            errorMessages.add("The city field cannot be empty");
        }

        if (state.isEmpty()) {
            errorMessages.add("The state field cannot be empty");
        }

        if (!zipMatch) {
            errorMessages.add("The zip code input is not valid");
        }

        if (!errorMessages.isEmpty()) {
            for (String error : errorMessages) {
                log.info(error);
            }
            response.addObject("errors", errorMessages);
            response.addObject("firstName", firstName);
            response.addObject("lastName", lastName);
            response.addObject("city", city);
            response.addObject("state", state);
            response.addObject("zip", zip);
        } else {
            Student student = new Student();
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setCity(city);
            student.setState(state);
            student.setZip(zip);

            studentDAO.save(student);

            successMessages.add("Student successfully saved.");
            response.addObject("successMessages", successMessages);
        }

        return response;
    }

    @GetMapping("/course/instructor")
    public ModelAndView instCount() {
        ModelAndView response = new ModelAndView();
        response.setViewName("instructor_count");

        List<Map<String, Object>> instructorCounts = courseDAO.instructorCourseCount();
        for (Map<String, Object> count : instructorCounts) {
            log.debug(count.get("instructor") + " is teaching " + count.get("cnt") + "course(s)");
        }
        response.addObject("instructorCounts", instructorCounts);
        return response;
    }

    @GetMapping("/fileupload")
    public ModelAndView fileUpload() {
        ModelAndView response = new ModelAndView();
        response.setViewName("fileupload");

        return response;
    }

    @PostMapping("/fileuploadsubmit")
    public ModelAndView fileUploadSubmit(@RequestParam MultipartFile file) {
        ModelAndView response = new ModelAndView();
        response.setViewName("fileupload");

        log.debug("File name = " + file.getOriginalFilename());
        log.debug("File size = " + file.getSize() + " bytes");

        return response;
    }
}
