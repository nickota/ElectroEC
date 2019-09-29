package com.example.electroec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.electroec.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
