package com.github.mykhalechko.webchat.service;

import com.github.mykhalechko.webchat.entity.ChatUser;
import org.springframework.web.servlet.ModelAndView;

public interface RegistrationService {
    ModelAndView getRegister();

    boolean create(ChatUser user);

}
