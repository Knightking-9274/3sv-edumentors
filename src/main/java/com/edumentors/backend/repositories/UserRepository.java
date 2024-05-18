package com.edumentors.backend.repositories;
import com.edumentors.backend.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    public boolean existsByEmailId(String emailId);

    @Query("select u from User u where u.emailId =:emailId")
    public User getUserByUserName(@Param("emailId") String emailId);

}
