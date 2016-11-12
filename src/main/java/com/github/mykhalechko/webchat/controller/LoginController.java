package com.github.mykhalechko.webchat.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.mykhalechko.webchat.dto.ChatUserDto;
import com.github.mykhalechko.webchat.entity.ChatUser;
import com.github.mykhalechko.webchat.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

@RestController
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
    public ChatUserDto getChatUserLinkForSendingCredentials() throws NoSuchMethodException, JsonProcessingException {
        Method verifyLoginMethod = LoginController.class.getMethod("verifyLogin", ChatUserDto.class, HttpSession.class);
        Link verifyLoginLink = ControllerLinkBuilder.linkTo(LoginController.class, verifyLoginMethod).withSelfRel();
        System.out.println(verifyLoginLink.getHref());
        ChatUserDto chatUser = new ChatUserDto();
        chatUser.add(verifyLoginLink);
        return chatUser;
    }

    @RequestMapping(value = "/verifyLogin", method = RequestMethod.POST)
    public ResourceSupport verifyLogin(@RequestBody ChatUserDto chatUserDto, HttpSession session) throws NoSuchMethodException {
        if (service.verifyLogin(chatUserDto)) {
            session.setAttribute("login", chatUserDto.getLogin());
            Method chatMethod = ChatController.class.getMethod("chatAccess", HttpSession.class);
            Link chatLink = ControllerLinkBuilder.linkTo(ChatController.class, chatMethod).withSelfRel();
            ResourceSupport link = new ResourceSupport();
            link.add(chatLink);
            return link;
        } else {
            Method errorMethod = ErrorController.class.getMethod("getError");
            Link errorLink = ControllerLinkBuilder.linkTo(ErrorController.class, errorMethod).withSelfRel();
            ResourceSupport link = new ResourceSupport();
            link.add(errorLink);
            return link;
        }
    }
}
