package com.example.memoapp_auth_demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.memoapp_auth_demo.models.Memo;

public interface MemoRepository extends JpaRepository<Memo,String>{}
