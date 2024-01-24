package com.example.RoleAndUser.repo;
import com.example.RoleAndUser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepoUser extends JpaRepository<User,Long> {
    @Query("SELECT r FROM User r WHERE r.name = :nam")
    public Optional<User> findByName(@Param("nam") String name);
}
