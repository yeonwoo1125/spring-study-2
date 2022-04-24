package com.study.springstudy2.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "users_tb")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String userId;

    @Column(length = 10, nullable = false)
    private String userName;

    @Column(length = 30, nullable = false)
    private String userPassword;

    @Builder
    public User(String userName, String userPassword, String userId){
        this.userId=userId;
        this.userName=userName;
        this.userPassword=userPassword;
    }
}
