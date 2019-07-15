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
import java.util.Random;


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


        //List of user posts by user Id
        //TODO: Figure out how to get from database by user_id instead of grabbing all users
        List<Post> allPosts = (List<Post>) postDao.findAll();

        List<Post> userPosts = new ArrayList<Post>();
        for(Post post : allPosts){
            if(post.getUser().getId() == user.getId()){
                userPosts.add(post);
            }

        }

        // Generate random quotes
        //TODO: Figure out how to connect and retrieve random quotes from an API

        String[] arr={"Everything you’ve ever wanted is on the other side of fear. ",
                "Put your heart, mind, and soul into even your smallest acts. This is the secret of success.",
                "Perfection is not attainable, but if we chase perfection we can catch excellence. ",
                "Dwell on the beauty of life. Watch the stars, and see yourself running with them. ",
                "You are allowed to have fun along the way! ",
                "Success is something you attract by the person you become - Jim Rohn. ",
                "Tread softly; breathe peacefully; laugh hysterically – Nelson Mandela. ",
                "Why fit in when you were born to stand out? – Dr. Seuss ",
                "One important key to success is self-confidence. An important key to self-confidence is preparation - Arthur Ashe. ",
                "To know how to wait is the great secret of success – De Maistre. ",
                "It is our attitude toward life that determines life’s attitude toward us. We get back what we put out – Earl Nightingale. ",
                "If you run around with 9 losers pretty soon you’ll be the 10th loser - Les Brown. ",
                "The more you talk about negative things in your life, the more you call them in. Speak victory not defeat – Joel Osteen",
                "Begin at the beginning… and go on till you come to the end: then stop."};

        Random r=new Random();
        int randomNumber=r.nextInt(arr.length);

        String quote = arr[randomNumber];

        model.addAttribute("quote", quote);

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



