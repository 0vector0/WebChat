package com.github.mykhalechko.webchat.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "blacklist")
public class BlackList {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 6, nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "banned_user_id", nullable = false)
    private ChatUser bannedUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ChatUser getBannedUser() {
        return bannedUser;
    }

    public void setBannedUser(ChatUser bannedUser) {
        this.bannedUser = bannedUser;
    }

}
