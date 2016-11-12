package com.github.mykhalechko.webchat.service;

import com.github.mykhalechko.webchat.entity.ChatUser;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public boolean verifyLogin(ChatUser chatUser){

        return false;
    }
}
