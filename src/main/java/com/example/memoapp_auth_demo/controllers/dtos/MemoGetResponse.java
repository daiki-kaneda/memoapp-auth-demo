package com.example.memoapp_auth_demo.controllers.dtos;

import java.util.List;

import com.example.memoapp_auth_demo.models.Memo;

public record MemoGetResponse(List<Memo> memos) {}
