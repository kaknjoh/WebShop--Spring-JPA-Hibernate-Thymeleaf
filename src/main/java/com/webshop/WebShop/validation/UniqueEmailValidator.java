package com.webshop.WebShop.validation;

import com.webshop.WebShop.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
    @Autowired
    private UserServiceImpl userService;



    @Override
    public boolean isValid(String value, ConstraintValidatorContext context){
        return value!= null && !userService.isEmailAlreadyInUse(value);
    }

}
