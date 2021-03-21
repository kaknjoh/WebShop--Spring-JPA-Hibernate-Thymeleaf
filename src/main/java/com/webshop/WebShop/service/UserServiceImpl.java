package com.webshop.WebShop.service;


import com.webshop.WebShop.domain.Role;
import com.webshop.WebShop.domain.User;
import com.webshop.WebShop.dto.UserDTO;
import com.webshop.WebShop.repository.RoleRepository;
import com.webshop.WebShop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements  UserService{
    @Autowired
    private UserRepository userRepository;


    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public boolean isEmailAlreadyInUse(String email) {
        boolean userInDb=true;
        if(userRepository.getUserByEmail(email) ==null){
            userInDb=false;
        }
        return userInDb;
    }

    @Override
    public boolean isUsernameAlredyInUse(String username) {
        boolean userInDb=true;

        if(userRepository.findByUsername(username)==null){
            userInDb=false;

        }
        return userInDb;
    }

    @Override
    public User saveUser(UserDTO user, String role) {
        User userEntity=convertUserDTOtoUserEntity(user, role);
        userEntity=userRepository.save(userEntity);
        return userEntity;
    }


    @Override
    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }


    @Override
    public User getById(int userID) {
        return userRepository.findById(userID).orElse(null);
    }

    @Override
    public User updateSetUserRole(User user, String roleName) {
        Role role=roleRepository.findByName(roleName);
        user.addRole(role);
        userRepository.save(user);
        return user;
    }

    private User convertUserDTOtoUserEntity(UserDTO user, String roleName ){
        User userEntity=new User();
        Role role=roleRepository.findByName(roleName);
        Set<Role> roles=new HashSet<>();
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
        userEntity.setEnable(true);
        userEntity.setEmail(user.getEmail());
        userEntity.setRoles(roles);
        role.setName(roleName);
        roles.add(role);
        return userEntity;

    }
}
