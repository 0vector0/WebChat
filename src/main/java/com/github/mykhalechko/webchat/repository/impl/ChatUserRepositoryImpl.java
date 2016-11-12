package com.github.mykhalechko.webchat.repository.impl;


import com.github.mykhalechko.webchat.dto.ChatUserDto;
import com.github.mykhalechko.webchat.repository.ChatUserRepositoryCustom;

public class ChatUserRepositoryImpl implements ChatUserRepositoryCustom {
    @Override
    public boolean isUserExist(ChatUserDto chatUserDto) {
        return false;
    }
}
