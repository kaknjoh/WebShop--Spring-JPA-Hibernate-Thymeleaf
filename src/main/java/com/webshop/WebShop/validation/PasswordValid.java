package com.webshop.WebShop.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = PasswordValidator.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD})
public @interface PasswordValid {

    public String message() default "Incorrect password format! It should contains at least one digit, one upper case letter and one character";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default{};

}
