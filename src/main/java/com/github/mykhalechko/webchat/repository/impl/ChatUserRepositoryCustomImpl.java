package com.github.mykhalechko.webchat.repository.impl;

import com.github.mykhalechko.webchat.dto.ChatUserDto;
import com.github.mykhalechko.webchat.entity.ChatUser;
import com.github.mykhalechko.webchat.repository.ChatUserRepository;
import com.github.mykhalechko.webchat.repository.ChatUserRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChatUserRepositoryCustomImpl implements ChatUserRepositoryCustom {

    @Autowired
    ChatUserRepository chatUserRepository;

    @Override
    public boolean isUserExist(ChatUserDto chatUserDto) {
        ChatUser chatUser = chatUserRepository.getUserByLogin(chatUserDto.getLogin());
        if (chatUser != null && chatUser.getPassword().equals(chatUserDto.getPassword())) {
            return true;
        }
        return false;
    }
}
