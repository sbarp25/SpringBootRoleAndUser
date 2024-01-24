package com.example.RoleAndUser.repo;

import com.example.RoleAndUser.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RepoRole extends JpaRepository<Role,Long> {
    @Query("SELECT r FROM Role r WHERE r.name = :nam")
    Optional<List<Role>> getRoleByName(@Param("nam") String name);
}
