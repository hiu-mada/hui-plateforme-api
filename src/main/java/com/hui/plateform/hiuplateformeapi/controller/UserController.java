package com.hui.plateform.hiuplateformeapi.controller;

import com.hui.plateform.hiuplateformeapi.Service.UserService;
import com.hui.plateform.hiuplateformeapi.entity.User;
import com.hui.plateform.hiuplateformeapi.entity.dto.UserChallenger;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    private UserService userService;

    @GetMapping("/admin")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
    @GetMapping("/")
    public List<UserChallenger> getAllUserForChallenger(){
        return userService.getAllUserForChallenger();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") String id){
        return userService.getUserById(id);
    }

    @PostMapping("/")
    public User createUser(@RequestBody User user){
        return userService.createUpdateUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") String id, @RequestBody User user, Authentication authentication){
        String currentUserId = getCurrentUserId(authentication);
        if (id.equals(user.getId()) && id.equals(currentUserId)) {
           return userService.createUpdateUser(user);
        }
        else{
            throw new IllegalStateException("Cannot update another user");
        }
    }

    @DeleteMapping("/{id}")
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
