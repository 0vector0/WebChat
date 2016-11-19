package com.github.mykhalechko.webchat.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySocketHandler extends TextWebSocketHandler {

    static Map<String, WebSocketSession> clients = new HashMap<>();

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage text) throws IOException {


        String message = text.getPayload();
        String[] messageArray = message.split(":");

        if (messageArray[0].equals("name")) {
            clients.put(messageArray[1], session);
            return;
        }
        if (messageArray[0].equals("broadcast")) {
            String name = null;
            for (Map.Entry<String, WebSocketSession> e : clients.entrySet()) {
                if (e.getValue().equals(session)) {
                    name = e.getKey();
                    break;
                }
            }
            for (WebSocketSession s : clients.values()) {
                s.sendMessage(new TextMessage(name + " : " + messageArray[1]));
            }
            return;
        }
        if (messageArray[0].equals("list")) {

            List<String> clientsList = new ArrayList<>(clients.keySet());
            ObjectMapper objectMapper = new ObjectMapper();
            String output = objectMapper.writeValueAsString(clientsList);
            System.out.println(output);
            session.sendMessage(new TextMessage("list:" + output));
            return;
        }

        String name = null;
        for (Map.Entry<String, WebSocketSession> e : clients.entrySet()) {
            if (e.getValue().equals(session)) {
                name = e.getKey();
                break;
            }
        }
        WebSocketSession receiverSession = clients.get(messageArray[0]);
        receiverSession.sendMessage(new TextMessage(name + " : " + messageArray[1]));
    }
}