package com.example.electroec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.electroec.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {

}
