package org.launchcode.positivevibes.Controllers;


import org.launchcode.positivevibes.models.User;
import org.launchcode.positivevibes.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ProfileController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/profile/{userId}", method = RequestMethod.GET)
    public String displayProfileWithId(Model model, @PathVariable int userId) {

        User user = userDao.findOne(userId);
        model.addAttribute("title", "User Profile");
        model.addAttribute("firstName", user.getfirstName());
        model.addAttribute("user", user);

        return "/profile";
    }


    /*@RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String  processProfileWithId(@ModelAttribute , Errors errors, Model model) {



        return "redirect:/profile" + user.getId();
    }*/





}



