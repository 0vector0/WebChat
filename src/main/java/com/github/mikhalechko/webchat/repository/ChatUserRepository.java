package com.github.mikhalechko.webchat.repository;


import com.github.mikhalechko.webchat.entity.ChatUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatUserRepository extends JpaRepository<ChatUser, Long> {
}
