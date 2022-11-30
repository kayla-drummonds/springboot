package com.teksystems.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.teksystems.springboot.database.dao.UserDAO;
import com.teksystems.springboot.database.entity.User;
import com.teksystems.springboot.form.CreateUserForm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping("/user/createuser")
    public ModelAndView createUser(CreateUserForm form) {
        ModelAndView response = new ModelAndView();

        response.setViewName("login_pages/create_user");
        log.debug("This is in the GET method for create user");
        return response;
    }

    @PostMapping("/user/createuser")
    public ModelAndView createUserSubmit(CreateUserForm form) {
        ModelAndView response = new ModelAndView();
        response.setViewName("login_pages/create_user");
        log.debug("This is in the POST method for create user");

        User user = new User();

        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());
        user.setAddress(form.getAddress());
        user.setCity(form.getCity());
        user.setState(form.getState());
        user.setZip(form.getZip());
        user.setPhone(form.getPhone());

        userDAO.save(user);

        log.debug(form.toString());
        return response;
    }
}
