package com.study.springstudy2.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class UserFindAllResponseDto {
    Long id;

    String userName;

    String userPassword;

    @Builder
    public UserFindAllResponseDto(Long id, String userName, String userPassword){
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
    }
}
