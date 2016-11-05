package com.github.mykhalechko.webchat.repository;


import com.github.mykhalechko.webchat.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
