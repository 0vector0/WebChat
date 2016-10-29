package com.github.mikhalechko.webchat.repository;


import com.github.mikhalechko.webchat.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
