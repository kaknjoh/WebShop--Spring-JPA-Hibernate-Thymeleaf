package com.webshop.WebShop.controllers;


import com.webshop.WebShop.domain.User;
import com.webshop.WebShop.dto.UserDTO;
import com.webshop.WebShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoginContoller {

    @Autowired
    UserService userService;
    @GetMapping("/register-user")
    public String registerUser(Model model){
        UserDTO user=new UserDTO();
        model.addAttribute("user", user);
        return "registration";
    }


    @PostMapping("/register-user")
    public String saveUser(@Valid @ModelAttribute("user")UserDTO userDTO , BindingResult bindingResult, Model model){

        User user=null;
        if(bindingResult.hasErrors()){
            return "registration";
        }else {
            user=userService.saveUser(userDTO, "USER");
            model.addAttribute("Success", "You have been successfully registered as a new user");
            return "redirect:/success";
        }


    }
}
