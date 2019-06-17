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
import java.util.ArrayList;
import java.util.List;


@Controller
public class ProfileController {

    @Autowired
    private UserDao userDao;

    @Autowired
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
    public String processNewPost(Model model, @ModelAttribute @Valid Post post, @PathVariable int userId, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute(userDao.findOne(userId));
            model.addAttribute("post", new Post());

            return "/profile";
        }


        User u = userDao.findOne(userId);
        post.setUser(u);
        postDao.save(post);
        //return "redirect:/profile/" + newPost.getId();
        return "redirect:" + u.getId();
    }

    @RequestMapping(value = "/profile/{userId}")
    public String user (Model model, @PathVariable int userId) {

        User u = userDao.findOne(userId);
        List<Post> userPosts = u.getUserPosts();

        model.addAttribute(userPosts);

        return "redirect:" + userId;

    }

}



