package com.tutorial.api.SpringRestApi.controller;
import com.tutorial.api.SpringRestApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tutorial.api.SpringRestApi.model.User;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    UserRepository userRepo;

    @RequestMapping("/getAllUsers")
    @ResponseBody
    public List<User> getAllUsers(){
        return userRepo.getAllUsers();
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(@RequestParam("Id") int userId){
        return userRepo.getUser(userId);
    }




    @RequestMapping("/addUser")
    @ResponseBody
    public String addItem(@RequestParam("id") int id,@RequestParam("age") int age,
                          @RequestParam("name") String name , @RequestParam("salary") double salary ){
        if(userRepo.addUser(id,age,name,salary) >= 1){
            return "User Added Successfully";
        }else{
            return "Something went wrong !";
        }
    }
    @RequestMapping("/deteteUser")
    @ResponseBody
    public String deteteUser(@RequestParam("userId") int userId){
        if(userRepo.deleteUser(userId) >= 1){
            return "User Deleted Successfully";
        }else{
            return "Something went wrong !";
        }
    }
}