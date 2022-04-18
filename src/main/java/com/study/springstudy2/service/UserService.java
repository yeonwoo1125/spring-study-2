package com.study.springstudy2.service;

import com.study.springstudy2.dto.request.UserCreateRequestDto;
import com.study.springstudy2.entity.Users;
import com.study.springstudy2.entity.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UsersRepository usersRepository;

    @Transactional
    public Long createUser(UserCreateRequestDto dto){
        Users users = Users.builder()
                .userName(dto.getUserName())
                .userPassword(dto.getUserPassword()).
                build();
        return usersRepository.save(users).getUserId();
    }

    @Transactional
    public void deleteUser(Long id){
        usersRepository.deleteById(id);
    }

    @Transactional
    public List<Users> findAllUsers(){
        List<Users> userList = usersRepository.findAll();
        return userList;
    }
}
