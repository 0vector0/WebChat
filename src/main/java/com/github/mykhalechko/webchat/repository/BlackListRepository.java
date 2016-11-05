package com.github.mykhalechko.webchat.repository;


import com.github.mykhalechko.webchat.entity.BlackList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlackListRepository extends JpaRepository<BlackList, Long> {
}
