package com.example.RoleAndUser.controller;

import com.example.RoleAndUser.entity.Role;
import com.example.RoleAndUser.repo.RepoRole;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/role")
public class RoleController {
    private final RepoRole repoRole;

    public RoleController(RepoRole repoRole) {
        this.repoRole = repoRole;
    }

    @PostMapping("/create-role")
    public Role createRole(@RequestBody Role role){
        return repoRole.save(role);

    }
}
