package com.example.demojpa.dao;

import com.example.demojpa.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    @Query("SELECT c FROM Users c WHERE c.name like:name")
    List<Users> findUserByName(String name);
}
