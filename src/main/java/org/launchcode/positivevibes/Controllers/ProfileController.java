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
import java.util.Collection;
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

        model.addAttribute("firstName", user.getfirstName());
        model.addAttribute("user", user);
        model.addAttribute(new Post());

        //TODO: Figure out how to get from database by user_id instead of grabbing all users
        List<Post> allPosts = (List<Post>) postDao.findAll();

        List<Post> userPosts = new ArrayList<Post>();
        for(Post post : allPosts){
            if(post.getUser().getId() == user.getId()){
                userPosts.add(post);
            }
        }

        model.addAttribute("userPosts", userPosts);

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

}



