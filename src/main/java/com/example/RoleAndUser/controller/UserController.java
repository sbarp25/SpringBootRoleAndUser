package com.example.RoleAndUser.controller;
import com.example.RoleAndUser.dto.request.DtoUserRequest;
import com.example.RoleAndUser.dto.response.DtoUserResponse;
import com.example.RoleAndUser.exception.NoRoleWithThatId;
import com.example.RoleAndUser.service.ServiceUser;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/admin")
public class UserController {

    private final ServiceUser serviceUser;

    public UserController(ServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }


    @PostMapping(path = "/create")
    public DtoUserResponse createTeacher(
            @RequestBody DtoUserRequest dto){
        return serviceUser.createUser(dto);
    }
    @GetMapping(path = "/get")
    public List<DtoUserResponse> getUser(){

        return serviceUser.getUser().orElseThrow(()-> new NoRoleWithThatId("no user found"));
    }
    @PutMapping(path = "/update")
    public DtoUserResponse updatRoleOfUser(@RequestParam String name,@RequestParam long id){
        return serviceUser.updateRoleOfUser(name,id);
    }
    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam long idOfUser,@RequestParam long toDelete){
        return serviceUser.deleteUser(idOfUser,toDelete);
    }
}
