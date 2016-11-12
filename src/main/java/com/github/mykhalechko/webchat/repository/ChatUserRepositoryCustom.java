package com.github.mykhalechko.webchat.repository;


import com.github.mykhalechko.webchat.dto.ChatUserDto;

public interface ChatUserRepositoryCustom {
    public boolean isUserExist(ChatUserDto chatUserDto);
}
