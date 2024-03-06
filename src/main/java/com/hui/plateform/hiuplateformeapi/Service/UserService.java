package com.hui.plateform.hiuplateformeapi.Service;

import com.hui.plateform.hiuplateformeapi.controller.AuthenticationRequest;
import com.hui.plateform.hiuplateformeapi.controller.AuthenticationResponse;
import com.hui.plateform.hiuplateformeapi.controller.RegisterRequest;
import com.hui.plateform.hiuplateformeapi.entity.User;
import com.hui.plateform.hiuplateformeapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
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

    public AuthenticationResponse register(RegisterRequest request){
        var user = User.builder()
                .email(request.getEmail())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate (AuthenticationRequest request){
       authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(
                       request.getEmail(),
                       request.getEmail()
               )
       );
               var user = userRepository.findByEmail(request.getEmail())
                       .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
