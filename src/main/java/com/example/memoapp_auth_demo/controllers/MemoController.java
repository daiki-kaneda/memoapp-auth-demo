package com.example.memoapp_auth_demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.memoapp_auth_demo.controllers.dtos.MemoGetResponse;
import com.example.memoapp_auth_demo.controllers.dtos.MemoPostReponse;
import com.example.memoapp_auth_demo.controllers.dtos.MemoPostRequest;
import com.example.memoapp_auth_demo.models.Memo;
import com.example.memoapp_auth_demo.models.User;
import com.example.memoapp_auth_demo.services.MemoService;
import com.example.memoapp_auth_demo.services.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/memo")
public class MemoController {
    private final MemoService memoService;
    private final UserService userService;

    public MemoController(MemoService memoService, UserService userService) {
        this.memoService = memoService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<MemoPostReponse> createMemo(Authentication auth, @RequestBody MemoPostRequest request) {
        Memo newMemo = new Memo();
        User user = userService.getCurrentUser(auth);
        newMemo.setId(request.id());
        newMemo.setContent(request.content());
        newMemo.setCreatedAt(request.createdAt() == null ? LocalDateTime.now() : request.createdAt());
        newMemo.setUpdatedAt(request.updatedAt() == null ? LocalDateTime.now() : request.updatedAt());
        newMemo.setUser(user);

        Memo memo = memoService.createMemo(newMemo);
        return ResponseEntity.ok(new MemoPostReponse(memo));
    }

    @GetMapping
    public ResponseEntity<MemoGetResponse> getMemos(Authentication auth) {
        User user = userService.getCurrentUser(auth);
        List<Memo> memos = memoService.getMemos(user);
        return ResponseEntity.ok(new MemoGetResponse(memos));
    }

}
