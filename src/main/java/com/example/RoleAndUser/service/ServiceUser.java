package com.example.RoleAndUser.service;
import com.example.RoleAndUser.dto.request.DtoUserRequest;
import com.example.RoleAndUser.dto.response.DtoUserResponse;
import com.example.RoleAndUser.entity.Role;
import com.example.RoleAndUser.entity.User;
import com.example.RoleAndUser.exception.NoRoleWithThatId;
import com.example.RoleAndUser.repo.RepoRole;
import com.example.RoleAndUser.repo.RepoUser;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceUser {
    private final RepoUser repoUser;
    private final RepoRole repoRole;

    public ServiceUser(RepoUser repoTeacher, RepoRole repoRole) {
        this.repoUser = repoTeacher;
        this.repoRole = repoRole;
    }

    public DtoUserResponse createUser(DtoUserRequest dtoUser){
        User t = new User(dtoUser);
        List<Role> r = repoRole
                .getRoleByName(dtoUser.getRole())
                .orElseThrow(()->new NoRoleWithThatId("no id found"));
        t.setRole(r);
        repoUser.save(t);
        return new DtoUserResponse(t);
    }
    public Optional<List<DtoUserResponse>> getUser(){

        return Optional.of(repoUser
                .findAll()
                .stream()
                .map(DtoUserResponse::new)
                .collect(Collectors.toList()));
    }

    public DtoUserResponse updateRoleOfUser(String name,long id){
        User user =repoUser.findById(id)
                .orElseThrow(()-> new NoRoleWithThatId("no user with that id"));
        List<Role> r = repoRole
                .getRoleByName(name)
                .orElseThrow(()->new NoRoleWithThatId("no id found"));
        user.addRole(r);
        repoUser.save(user);

        return new DtoUserResponse(user);
    }

    public String deleteUser(long idOfUser,long toDelete){
        User user =repoUser
                .findById(idOfUser)
                .orElseThrow(()->new NoRoleWithThatId("no user with that id"));


        if(user.getRole().stream().anyMatch(a->a.getName().equals("admin"))){
            repoUser.deleteById(toDelete);
            return "deleted user with id  " + toDelete;
        }else {
            throw  new NoRoleWithThatId("you cant operate this action");
        }


    }

}
