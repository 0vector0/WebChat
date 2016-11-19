package com.github.mykhalechko.webchat.controller;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

public class MySocketHandler extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage text) throws IOException {

        String message = text.getPayload();
        message += "fromServer";
        TextMessage newText = new TextMessage(message);
        session.sendMessage(newText);

    }
}