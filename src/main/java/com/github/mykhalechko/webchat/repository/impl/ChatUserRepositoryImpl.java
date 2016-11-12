package com.github.mykhalechko.webchat.repository.impl;


import com.github.mykhalechko.webchat.dto.ChatUserDto;
import com.github.mykhalechko.webchat.repository.ChatUserRepository;

public class ChatUserRepositoryImpl implements ChatUserRepository {
    @Override
    public boolean isUserExist(ChatUserDto chatUserDto) {
        return false;
    }
}
