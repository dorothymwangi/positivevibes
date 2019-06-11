package org.launchcode.positivevibes.Controllers;


import org.launchcode.positivevibes.models.User;
import org.launchcode.positivevibes.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

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

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String displayLoginForm(Model model, Principal user, String error, String logout) {
        model.addAttribute("title", "Log In");


       if (user != null)
            return "redirect:/";

        if (error != null)
            model.addAttribute("message", "danger|Your username and password are invalid");

        if (logout != null)
            model.addAttribute("message", "info|You have logged out");




        return "login";

    }


    /*@GetMapping("login")
    public String login(Principal principal) {
        if (principal != null) {
            return "redirect:/home";
        }
        return "/login";
    }*/

}
