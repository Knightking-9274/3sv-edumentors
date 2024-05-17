package com.edumentors.backend.repositories;
import com.edumentors.backend.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {
    // @Query("select u from users u where u.user_name = :emailId")
    // public User getUserByUserName(@Param("emailId") String emailId);

}
