package com.github.mykhalechko.webchat.repository;


import com.github.mykhalechko.webchat.dto.ChatUserDto;
import com.github.mykhalechko.webchat.entity.ChatUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ChatUserRepository extends JpaRepository<ChatUser, Long>, ChatUserRepositoryCustom {

    public boolean isUserExist(ChatUserDto chatUserDto);

    @Query("select u from com.github.mykhalechko.webchat.entity.ChatUser u where u.login=:login")
    public ChatUser getUserByLogin(String login);

}
