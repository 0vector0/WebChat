package com.github.mykhalechko.webchat.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mykhalechko.webchat.dto.ChatUserDto;
import com.github.mykhalechko.webchat.entity.ChatUser;
import com.github.mykhalechko.webchat.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

@Controller
public class LoginController {

    @Autowired
    LoginService service;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLogin() {
        ChatUser user = new ChatUser();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("urlpath", "/getLoginLink");
        modelAndView.setViewName("login");
        return modelAndView;
    }

    //use spring-hateoas
    @RequestMapping(value = "/getLoginLink", method = RequestMethod.GET)
//    @Consumes(MediaType.APPLICATION_JSON)
//    @ResponseBody
    public String getChatUserLinkForSendingCredentials() throws NoSuchMethodException, JsonProcessingException {
        Method verifyLoginMethod = LoginController.class.getMethod("verifyLogin", ChatUserDto.class, HttpSession.class);
        Link verifyLoginLink = ControllerLinkBuilder.linkTo(LoginController.class, verifyLoginMethod).withSelfRel();
        System.out.println(verifyLoginLink.getHref());
        ChatUserDto chatUser = new ChatUserDto();
        chatUser.add(verifyLoginLink);
        chatUser.setLogin("test");
        System.out.println(chatUser);
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(chatUser);
        System.out.println(s);
        return s;
    }

    @RequestMapping(value = "/verifyLogin", method = RequestMethod.POST)
    public ModelAndView verifyLogin(@RequestBody ChatUserDto chatUserDto, HttpSession session) {
        if (service.verifyLogin(chatUserDto)) {
            session.setAttribute("login", chatUserDto.getLogin());
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("user");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("index");
            return modelAndView;
        }
    }
}
