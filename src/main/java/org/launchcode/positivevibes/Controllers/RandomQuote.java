package org.launchcode.positivevibes.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Random;


@Controller
@RequestMapping(value = "/quotes")
public class RandomQuote {


    @GetMapping
    public String quote (Model model){
        model.addAttribute("title", "+ve Quotes");

    //TODO: Figure out how to connect and retrieve random quotes from an API
        // TODO: Figure out how to return to current user profile page

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

        return"/quotes";
    }

}
