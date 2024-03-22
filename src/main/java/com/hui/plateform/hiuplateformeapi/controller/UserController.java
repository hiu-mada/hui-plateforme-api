package com.hui.plateform.hiuplateformeapi.controller;

import com.hui.plateform.hiuplateformeapi.Service.UserService;
import com.hui.plateform.hiuplateformeapi.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping("/user")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") String id){
        return userService.getUserById(id);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        return userService.createUpdateUser(user);
    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable("id") String id, @RequestBody User user, Authentication authentication){
        String currentUserId = getCurrentUserId(authentication);
        if (id.equals(user.getId()) && id.equals(currentUserId)) {
            userService.createUpdateUser(user);
        }
        else{
            throw new IllegalStateException("Cannot update another user");
        }
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable("id") String id, Authentication authentication){
        String currentUserId = getCurrentUserId(authentication);
        if (!id.equals(currentUserId)) {
            userService.deleteUser(id);
        }
        else{
            throw new IllegalStateException("Cannot update another user");
        }
    }
    private String getCurrentUserId(Authentication authentication) throws IllegalStateException {
        if (authentication == null) {
            throw new IllegalStateException("Authentication required.");
        }
        return ((User) authentication.getPrincipal()).getId();
    }
}
