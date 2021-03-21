package com.webshop.WebShop.service;

import com.webshop.WebShop.domain.User;
import com.webshop.WebShop.dto.UserDTO;

import java.util.List;

public interface UserService {


    boolean isEmailAlreadyInUse(String email);

    boolean isUsernameAlredyInUse(String username);

    List<User> findAllUsers();
    User saveUser(UserDTO user, String role);

    User getById(int userID);

    User updateSetUserRole(User user, String roleName);




}
