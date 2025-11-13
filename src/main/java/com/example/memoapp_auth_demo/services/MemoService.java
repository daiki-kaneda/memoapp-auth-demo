package com.example.memoapp_auth_demo.services;

import org.springframework.stereotype.Service;

import com.example.memoapp_auth_demo.repositories.MemoRepository;

@Service
public class MemoService {
    private final MemoRepository memoRepository;

    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }
}
