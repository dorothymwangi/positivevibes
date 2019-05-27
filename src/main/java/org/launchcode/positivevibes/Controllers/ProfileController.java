package org.launchcode.positivevibes.Controllers;


import org.launchcode.positivevibes.models.User;
import org.launchcode.positivevibes.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProfileController {

    @Autowired
    private UserDao userDao;
    @RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
    public String editProfileWithId(Model model, @PathVariable int userId) {

        User user = userDao.findOne(userId);

        return "/profile";
    }

}



