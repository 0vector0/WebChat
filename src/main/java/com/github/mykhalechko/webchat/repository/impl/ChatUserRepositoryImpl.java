package com.github.mykhalechko.webchat.repository.impl;

import com.github.mykhalechko.webchat.dto.ChatUserDto;
import com.github.mykhalechko.webchat.entity.ChatUser;
import com.github.mykhalechko.webchat.repository.ChatUserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public class ChatUserRepositoryImpl implements JpaRepository<ChatUser, Long>, ChatUserRepository {

    @Override
    public boolean isUserExist(ChatUserDto chatUserDto) {
        return false;
    }
}
