package com.github.mykhalechko.webchat.service;

import com.github.mykhalechko.webchat.entity.ChatUser;
import com.github.mykhalechko.webchat.repository.ChatUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private ChatUserRepository chatUserRepository;

    @Override
    public ModelAndView getRegister() {
        ChatUser user = new ChatUser();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @Override
    public boolean create(ChatUser user) {
        if (chatUserRepository.saveAndFlush(user) == null) {
            return false;
        } else {
            return true;
        }
    }
}
