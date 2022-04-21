package com.study.springstudy2.dto.request;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateRequestDto {

    @NotNull
    String userName;

    @NotNull
    String userPassword;

    @NotNull
    String userId;

    @Builder
    public UserCreateRequestDto(String userId, String userName, String userPassword){
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
    }

}
