package com.webshop.WebShop.controllers;


import com.webshop.WebShop.domain.User;
import com.webshop.WebShop.dto.SetUserRoleDTO;
import com.webshop.WebShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminContoller {

    @Autowired
    UserService userService;

    @GetMapping("/updaterole")
    public String setRoleView(Model model){
        List<User> users=userService.findAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("setUserRoleDTO", new SetUserRoleDTO());
        return "setrole";
    }



    @PostMapping("/setrole")
    public String setRolePost(@ModelAttribute("setUserRoleDTO") SetUserRoleDTO userRole, BindingResult bindingResult){
        User user=null;
        if(bindingResult.hasErrors()){
            return "setrole";
        }else{
            user=userService.getById(userRole.getUserID());
            userService.updateSetUserRole(user, userRole.getRoleName());
            return "redirect:/";
        }





    }



}
