package com.study.springstudy2.service;

import com.study.springstudy2.dto.request.UserCreateRequestDto;
import com.study.springstudy2.entity.Users;
import com.study.springstudy2.entity.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;

    @Transactional
    public Long createUser(UserCreateRequestDto dto){
        Users users = Users.builder()
                .userName(dto.getUserName())
                .userPassword(dto.getUserPassword()).
                build();
        return usersRepository.save(users).getUserId();
    }
}
