package com.hui.plateform.hiuplateformeapi.controller;

import com.hui.plateform.hiuplateformeapi.Service.UserService;
import com.hui.plateform.hiuplateformeapi.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping("/")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id){
        return userService.getUserById(id);
    }

    @PostMapping("/")
    public User createUser(@RequestBody User user){
        return userService.createUpdateUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user){
        user.setId(id);
        return userService.createUpdateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable String id){
        userService.deleteUser(id);
    }
}
