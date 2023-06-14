package com.alpha.orderingservice.controller;

import com.alpha.orderingservice.payload.UserPayload;
import com.alpha.orderingservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {
    @Autowired
    private UserService userService;

    @PostMapping("/users/register")
    public String createUser(@ModelAttribute("userPayload") UserPayload userPayload) {
        userService.createUser(userPayload);
        return "redirect:/login";
    }

    @GetMapping("/users/new")
    public String createUserForm(Model model){
        UserPayload userPayload = new UserPayload();
        model.addAttribute("userPayload", userPayload);
        return "register_user";
    }
}
