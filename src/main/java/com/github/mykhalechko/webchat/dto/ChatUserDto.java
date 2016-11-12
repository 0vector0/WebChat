package com.github.mykhalechko.webchat.dto;


import org.springframework.hateoas.ResourceSupport;

public class ChatUserDto extends ResourceSupport {

    private String name;

    private String login;

    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
