package com.study.springstudy2.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "users_tb")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(length = 10, nullable = false, name = "user_name")
    private String userName;

    @Column(length = 30, nullable = false, name = "user_password")
    private String userPassword;
}
