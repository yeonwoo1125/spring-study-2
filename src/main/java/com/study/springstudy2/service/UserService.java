package com.study.springstudy2.service;

import com.study.springstudy2.dto.request.UserCreateRequestDto;
import com.study.springstudy2.entity.User;
import com.study.springstudy2.entity.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository usersRepository;

    @Transactional
    public Long createUser(UserCreateRequestDto dto){
        User users = User.builder()
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
    public List<User> findAllUsers(){
        List<User> userList = usersRepository.findAll();
        return userList;
    }
}
