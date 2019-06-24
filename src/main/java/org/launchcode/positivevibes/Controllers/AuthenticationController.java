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


  /*  @RequestMapping(value = "login", method = RequestMethod.GET,  params = {"email", "password"})
    //@ResponseBody
    public String getLogin(@RequestParam (name = "email"), @RequestParam (name = "password"), Model model) {

        List<User> allUsers = (List<User>) userDao.findAll();

        for (User user : allUsers) {
            if (user.getEmail() != email || user.getPassword() != password) {

                model.addAttribute("Incorrect username or password");

                return "login'";

            }
            return "/profile" + user.getId();

            }
        return "profile";*/

    }

