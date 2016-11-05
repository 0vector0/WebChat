package com.github.mykhalechko.webchat.service;

import com.github.mykhalechko.webchat.entity.ChatUser;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class RegistrationServiceImpl implements RegistrationService {


    @Override
    public ModelAndView getRegister() {
        ChatUser user = new ChatUser();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("reg", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

}
