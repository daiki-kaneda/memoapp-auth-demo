package com.example.memoapp_auth_demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.memoapp_auth_demo.services.MemoService;

@RestController
@RequestMapping("/memo")
public class MemoController {
    private final MemoService memoService;

    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    
}
