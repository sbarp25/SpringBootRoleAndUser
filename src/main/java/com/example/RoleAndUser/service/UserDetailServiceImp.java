package com.example.RoleAndUser.service;

import com.example.RoleAndUser.config.SecurityUser;
import com.example.RoleAndUser.entity.User;
import com.example.RoleAndUser.exception.NoRoleWithThatId;
import com.example.RoleAndUser.repo.RepoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImp implements UserDetailsService {
    @Autowired
    public  RepoUser repoUser;


    @Override
    public SecurityUser loadUserByUsername(String username) throws UsernameNotFoundException {
        User foundUser = repoUser.findByName(username)
                .orElseThrow(()->new NoRoleWithThatId("no id with that name"));
        return new SecurityUser(foundUser);
    }
}
