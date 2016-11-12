package com.github.mykhalechko.webchat.service;


import com.github.mykhalechko.webchat.entity.ChatUser;

public interface LoginService {

    public boolean verifyLogin(ChatUser chatUser);

}
