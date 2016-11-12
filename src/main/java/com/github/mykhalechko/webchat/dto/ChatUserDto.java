package com.github.mykhalechko.webchat.dto;


import org.springframework.hateoas.ResourceSupport;

public class ChatUserDto extends ResourceSupport {

    private String name;

    private String login;

    private String password;

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }


    public String getPassword() {
        return password;
    }

}
