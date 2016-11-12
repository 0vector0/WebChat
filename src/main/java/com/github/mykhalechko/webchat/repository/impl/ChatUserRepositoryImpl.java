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
        System.out.println("ChatUserRepository");
        System.out.println(chatUserDto.getLogin());
        ChatUser u = chatUserRepository.getUserByLogin(chatUserDto.getLogin());
        System.out.println(u.getPassword());
        System.out.println(chatUserDto.getPassword());
        if (u.getPassword().equals(chatUserDto.getPassword())) {
            System.out.println(u + "222");
            return true;
        }
        return false;
    }
}
