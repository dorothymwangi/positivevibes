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
public class PostController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PostDao postDao;

    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public String displayNewPostForm(Model model) {
        model.addAttribute("title", "New Post");
        model.addAttribute("user", userDao.findAll());
        model.addAttribute(new Post());
        return "/post";
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String processNewPostForm(@ModelAttribute @Valid Post newPost,
                                       Errors errors, @RequestParam int id, @RequestParam int userId, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "New Post");

            return "/post";
        }

        User u = userDao.findOne(userId);
        newPost.setUser(u);
        postDao.save(newPost);
        return "redirect:";
    }






   /* @RequestMapping(value = "/profile/{userId}", method = RequestMethod.GET)
    public String addNewPost(Model model, @PathVariable int userId) {

        User user = userDao.findOne(userId);
        model.addAttribute("post", new Post());
        return "/profile/{userId}";
    }

    @RequestMapping(value = "/profile/{userId}", method = RequestMethod.POST)
    public String processNewPost(@ModelAttribute @Valid Post newPost, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("post", new Post());

            return "/profile/{userId}";
        }

        postDao.save(newPost);
        //return "redirect:/profile/{userId}/" + newPost.getId();
        return "redirect:/profile/{userId}/";
    }




  /* @RequestMapping(value = "/profile/{userId}", method = RequestMethod.GET)
    public String displayNewPost(Model model, @PathVariable int userId) {

        model.addAttribute(new Post());
        return "/profile/{userId}";
    }

    @RequestMapping(value = "/profile/{userId}", method = RequestMethod.POST)
    public String processNewPost(@ModelAttribute @Valid Post newPost, Errors errors, @RequestParam int userId, @RequestParam int postId, Model model) {
        if (errors.hasErrors()) {


            return "/profile";
        }

        Post post = postDao.findOne(postId);
        User theUser = userDao.findOne(userId);

        postDao.save(newPost);


        return "redirect:profile/{userId}/" + newPost.getId();
    }*/


}
