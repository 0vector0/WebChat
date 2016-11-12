package com.github.mykhalechko.webchat.service;

import com.github.mykhalechko.webchat.dto.ChatUserDto;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public boolean verifyLogin(ChatUserDto chatUserDto){

        return false;
    }
}
