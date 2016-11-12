package com.github.mykhalechko.webchat.repository.impl;


import com.github.mykhalechko.webchat.dto.ChatUserDto;
import com.github.mykhalechko.webchat.entity.ChatUser;
import com.github.mykhalechko.webchat.repository.ChatUserRepository;
import com.github.mykhalechko.webchat.repository.ChatUserRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;

public class ChatUserRepositoryImpl implements ChatUserRepositoryCustom {

    @Autowired
    private ChatUserRepository chatUserRepository;

    @Override
    public boolean isUserExist(ChatUserDto chatUserDto) {
        ChatUser u = chatUserRepository.getUserByLogin(chatUserDto.getLogin());
        if (u.getPassword().equals(chatUserDto.getPassword())) {
            return true;
        }
        return false;
    }
}
