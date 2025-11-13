package com.example.memoapp_auth_demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.memoapp_auth_demo.models.User;

public interface UserRepository extends JpaRepository<User,String>{}
