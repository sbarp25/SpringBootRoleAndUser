package com.example.RoleAndUser.dto.response;

import com.example.RoleAndUser.entity.Role;
import com.example.RoleAndUser.entity.User;


import java.util.List;

public class DtoUserResponse {
    private String name;
    private String email;
    private String address;
    private List<Role> roles;

    public DtoUserResponse(User t) {
        this.name = t.getName();
        this.email = t.getEmail();
        this.roles = t.getRole();
    }

    public DtoUserResponse() {
    }

    public DtoUserResponse(String name, String email, String address, List<Role> roles) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.roles = roles;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}

