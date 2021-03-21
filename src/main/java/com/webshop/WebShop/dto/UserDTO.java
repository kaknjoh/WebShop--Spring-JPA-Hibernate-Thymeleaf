package com.webshop.WebShop.dto;

import com.webshop.WebShop.validation.EmailValid;
import com.webshop.WebShop.validation.PasswordValid;
import com.webshop.WebShop.validation.UniqueEmail;
import com.webshop.WebShop.validation.UniqueUsername;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@EqualsAndHashCode
@ToString()
@NoArgsConstructor

public class UserDTO {
    @UniqueUsername
    @NotEmpty
    @Size(min=5, max=45)
    private String username;


    @UniqueEmail
    @NotEmpty
    @EmailValid
    private String email;


    @PasswordValid
    @NotEmpty
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
