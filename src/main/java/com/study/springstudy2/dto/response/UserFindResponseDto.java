package com.study.springstudy2.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class UserFindResponseDto {
    Long id;

    Long userId;

    String userName;

    String userPassword;

    @Builder
    public UserFindResponseDto(Long id, Long userId, String userName, String userPassword){
        this.id = id;
        this.userId  = userId;
        this.userName = userName;
        this.userPassword = userPassword;
    }
}
