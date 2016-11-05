package com.github.mykhalechko.webchat.repository;


import com.github.mykhalechko.webchat.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
