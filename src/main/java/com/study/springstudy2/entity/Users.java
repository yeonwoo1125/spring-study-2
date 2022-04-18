package com.study.springstudy2.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "users_tb")
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(length = 10, nullable = false, name = "user_name")
    private String userName;

    @Column(length = 30, nullable = false, name = "user_password")
    private String userPassword;

    @Builder
    public Users(String userName, String userPassword){
        this.userName=userName;
        this.userPassword=userPassword;
    }
}
