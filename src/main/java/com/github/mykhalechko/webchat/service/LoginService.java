package com.github.mykhalechko.webchat.service;


import com.github.mykhalechko.webchat.dto.ChatUserDto;

public interface LoginService {

    public boolean verifyLogin(ChatUserDto chatUserDto);

}
