package com.example.memoapp_auth_demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.memoapp_auth_demo.models.Memo;
import com.example.memoapp_auth_demo.models.User;
import com.example.memoapp_auth_demo.repositories.MemoRepository;

@Service
public class MemoService {
    private final MemoRepository memoRepository;

    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    public Memo createMemo(Memo memo) {
        return memoRepository.save(memo);
    }

    public List<Memo> getMemos(User user) {
        return memoRepository.findByUser(user);
    }
}
