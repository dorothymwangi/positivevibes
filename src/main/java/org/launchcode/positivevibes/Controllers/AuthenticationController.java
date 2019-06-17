package org.launchcode.positivevibes.Controllers;


import org.launchcode.positivevibes.models.User;
import org.launchcode.positivevibes.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

import javax.validation.Valid;
import java.security.Principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "")
public class AuthenticationController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String displayRegisterForm(Model model) {
        model.addAttribute("title", "Register");
        model.addAttribute(new User());
        return "/register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String processRegisterForm(@ModelAttribute @Valid User newUser, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Register");

            return "/register";
        }

        userDao.save(newUser);
        return "redirect:profile/" + newUser.getId();
    }


    /*@RequestMapping(value="/login", method =RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("loguser", new User());

        return"/login";

    }

    @RequestMapping(value="/login", method =RequestMethod.POST)
    public String login(Model model,@ModelAttribute("loguser") User loguser, HttpSession session){

        System.out.println("Info received: "+loguser);
        session.setAttribute("user", loguser);



        if (loguser.getEmail().equals("")

        return"/login";

    }*/


}
