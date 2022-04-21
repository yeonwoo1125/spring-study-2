package com.study.springstudy2;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import java.sql.Connection;

@WebAppConfiguration
@SpringBootTest
public class MyBatisConnectionTest {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void connection_test(){
        try(Connection con = sqlSessionFactory.openSession().getConnection()){
            System.out.println("커넥션 성공");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
