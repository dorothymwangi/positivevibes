package org.launchcode.positivevibes.Controllers;


import org.launchcode.positivevibes.models.Post;
import org.launchcode.positivevibes.models.User;
import org.launchcode.positivevibes.models.data.PostDao;
import org.launchcode.positivevibes.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@Controller
public class ProfileController {

    @Autowired
    private UserDao userDao;
    private PostDao postDao;

    @RequestMapping(value = "/profile/{userId}", method = RequestMethod.GET)
    public String displayProfileWithId(Model model, @PathVariable int userId) {

        User user = userDao.findOne(userId);


        //model.addAttribute("title", "User Profile");
        model.addAttribute("firstName", user.getfirstName());
        model.addAttribute("user", user);
        model.addAttribute(new Post());

        return "/profile";
    }

    @RequestMapping(value = "/profile/{userId}", method = RequestMethod.POST)
    public String processNewPost(@ModelAttribute @Valid Post newPost,@PathVariable int userId, Errors errors, Model model) {
        if (errors.hasErrors()) {
           model.addAttribute("post", new Post());

            return "/profile";
        }


        User u = userDao.findOne(userId);
        newPost.setUser(u);
        postDao.save(newPost);
        //return "redirect:/profile/" + newPost.getId();
        return "redirect:/profile/";
    }

}



