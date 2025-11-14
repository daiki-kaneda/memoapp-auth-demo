package com.example.memoapp_auth_demo.controllers.dtos;

import java.time.LocalDateTime;

public record MemoPostRequest(
        String id,
        String content,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {

}
