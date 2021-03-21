package com.webshop.WebShop.validation;

import com.webshop.WebShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@Component
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
    @Autowired
    private UserService userService;


    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return value !=null && !userService.isUsernameAlredyInUse(value);
    }
}
