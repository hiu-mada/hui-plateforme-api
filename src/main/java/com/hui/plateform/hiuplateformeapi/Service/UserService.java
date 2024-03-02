package com.hui.plateform.hiuplateformeapi.Service;

import com.hui.plateform.hiuplateformeapi.entity.User;
import com.hui.plateform.hiuplateformeapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public User getUserById(String id){
        return userRepository.getReferenceById(id);
    }
    public User createUpdateUser(User user){
        return userRepository.save(user);
    }
    public void deleteUser(String id){
        userRepository.deleteById(id);
    }
}
