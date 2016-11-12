package com.github.mykhalechko.webchat.repository;


import com.github.mykhalechko.webchat.entity.ChatUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatUserRepository extends JpaRepository<ChatUser, Long> {

}
