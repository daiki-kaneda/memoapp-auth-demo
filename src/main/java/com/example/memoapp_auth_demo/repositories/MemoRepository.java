package com.example.memoapp_auth_demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.memoapp_auth_demo.models.Memo;
import com.example.memoapp_auth_demo.models.User;

public interface MemoRepository extends JpaRepository<Memo, String> {
    List<Memo> findByUser(User user);
}
