package com.sprhib.controller;

/**
 * Created by tanvigupta on 23/06/17.
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.model.User;
import com.sprhib.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", method=RequestMethod.GET)
    public ModelAndView addUserPage() {
        ModelAndView modelAndView = new ModelAndView("adduser");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }

    @RequestMapping(value = "/add", method=RequestMethod.POST)
    public ModelAndView addingUser(@ModelAttribute User user){

        ModelAndView modelAndView=new ModelAndView("home");
        userService.addUser(user);

        String message="You have successfully signed up.";
        modelAndView.addObject("message",message);

        return modelAndView;
    }
    @RequestMapping(value = "/list")
    public ModelAndView listOfUsers(){
        ModelAndView modelAndView=new ModelAndView("listuser");

        List<User> users=userService.getUsers();
        modelAndView.addObject("users",users);

        return modelAndView;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editUserPage(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("edituser");
        User user = userService.getUser(Integer.parseInt(id));
        modelAndView.addObject("user",user);
        return modelAndView;
    }
    @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
    public ModelAndView editingUser(@ModelAttribute User user) {

        ModelAndView modelAndView = new ModelAndView("home");

        userService.updateUser(user);

        String message = "User details were successfully edited.";
        modelAndView.addObject("message", message);

        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable String id){
        ModelAndView modelAndView=new ModelAndView("home");
        userService.deleteUser(Integer.parseInt(id));
        String message="Successfully deleted.";
        modelAndView.addObject("message",message);
        return modelAndView;
    }
}
