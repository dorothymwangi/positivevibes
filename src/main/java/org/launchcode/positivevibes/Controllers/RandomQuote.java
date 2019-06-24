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


        String[] arr={"Everything you’ve ever wanted is on the other side of fear. ",
                "Put your heart, mind, and soul into even your smallest acts. This is the secret of success.",
                "Perfection is not attainable, but if we chase perfection we can catch excellence. ",
                "Dwell on the beauty of life. Watch the stars, and see yourself running with them. ",
                "Begin at the beginning… and go on till you come to the end: then stop."};

        Random r=new Random();
        int randomNumber=r.nextInt(arr.length);

        String quote = arr[randomNumber];

        model.addAttribute("quote", quote);

        return"/quotes";
    }

}
