package com.webshop.WebShop.validation;

import org.hibernate.validator.internal.engine.validationcontext.ValidationContext;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class PasswordValidator implements ConstraintValidator<PasswordValid, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        return value != null && value.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}");

    }




}
