package com.github.mikhalechko.webchat.repository;


import com.github.mikhalechko.webchat.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
