package com.github.mikhalechko.webchat.repository;


import com.github.mikhalechko.webchat.entity.BlackList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlackListRepository extends JpaRepository<BlackList, Long> {
}
