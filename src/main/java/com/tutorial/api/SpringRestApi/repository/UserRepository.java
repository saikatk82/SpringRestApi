package com.tutorial.api.SpringRestApi.repository;
import com.tutorial.api.SpringRestApi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate template;

    /*Getting all User from table*/
    public List<User> getAllUsers(){
        List<User> users = template.query("select id,age, name,salary from user",(result,rowNum)->new User(result.getInt("id"),
                result.getString("name"),result.getInt("age"),result.getDouble("salary")));
        return users;
    }
    /*Getting a specific User by user id from table*/
    public User getUser(int userId){
        String query = "SELECT * FROM USER WHERE ID=?";
        User user = template.queryForObject(query,new Object[]{userId},new BeanPropertyRowMapper<>(User.class));

        return user;
    }
    /*Adding an User into database table*/
    public int addUser(int id,int age ,String name,double salary){
        String query = "INSERT INTO ITEM VALUES(?,?,?)";
        return template.update(query,id,age,name,salary);
    }
    /*delete an User from database*/
    public int deleteUser(int id){
        String query = "DELETE FROM ITEM WHERE ID =?";
        return template.update(query,id);
    }
}
