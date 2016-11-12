package com.github.mykhalechko.webchat.service;

import com.github.mykhalechko.webchat.dto.ChatUserDto;
import com.github.mykhalechko.webchat.repository.ChatUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private ChatUserRepository chatUserRepository;

    @Override
    public boolean verifyLogin(ChatUserDto chatUserDto) {
        if (chatUserRepository.isUserExist(chatUserDto)) {
            return true;
        }
        return false;
    }
}
