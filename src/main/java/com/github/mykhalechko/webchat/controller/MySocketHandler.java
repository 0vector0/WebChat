package com.github.mykhalechko.webchat.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mykhalechko.webchat.service.RedisConnect;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private RedisConnect redisConnect;

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage text) throws IOException {

        String message = text.getPayload();
        String[] messageArray = message.split(":");

        if (messageArray[0].equals("name")) {

            // TODO session.isOpen();
            clients.put(messageArray[1], session);
            List<String> messages = redisConnect.getJedis().lrange("broadcast", 0, -1);
            for (String s : messages) {
                session.sendMessage(new TextMessage("broadcast:" + s));
            }
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

//            Jedis jedis = redisConnect.getJedis();
            redisConnect.getJedis().lpush("broadcast", messageArray[1]);

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