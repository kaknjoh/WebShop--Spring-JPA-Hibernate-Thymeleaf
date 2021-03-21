package com.webshop.WebShop.dto;

import com.webshop.WebShop.domain.User;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
public class SetUserRoleDTO {

    @NotEmpty
    private int userID;

    @NotEmpty
    private String roleName;


    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
