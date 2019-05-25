package org.launchcode.positivevibes.Controllers;


import org.launchcode.positivevibes.models.Post;
import org.launchcode.positivevibes.models.User;
import org.launchcode.positivevibes.models.data.PostDao;
import org.launchcode.positivevibes.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "profile")
public class PostController {

    @Autowired
    private UserDao userDao;
    private PostDao postDao;

    @RequestMapping(value = "/newPost", method = RequestMethod.GET)
    public String displayNewPostForm(Model model) {
        model.addAttribute("title", "New Post");
        model.addAttribute(new Post());
        return "profile/newPost";
    }

    @RequestMapping(value = "/newPost", method = RequestMethod.POST)
    public String processNewPostForm(@ModelAttribute @Valid Post newPost, Errors errors, @RequestParam int userId, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "New Post");

            return "profile/NewPost";
        }

        User user = userDao.findOne(userId);
        newPost.setUser(user);
        postDao.save(newPost);
        return "/profile";
    }


}
