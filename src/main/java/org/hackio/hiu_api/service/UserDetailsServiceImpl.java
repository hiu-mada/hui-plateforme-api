package org.hackio.hiu_api.service;


import lombok.AllArgsConstructor;
import org.hackio.hiu_api.model.User;
import org.hackio.hiu_api.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
  private final UserRepository userRepository;
  @Override
  @Transactional(readOnly = true)
  public UserDetails loadUserByUsername(String username){
    Optional<User> userOptional = userRepository.findByUsername(username);
    User user = userOptional.orElseThrow(
      () -> new UsernameNotFoundException("No user " +
        "Fond with username : " + username));
    return new org.springframework.security
      .core.userdetails.User(
        user.getUsername(),
      user.getPassword(),
      user.getEnabled(),
      true,
      true,
      true,
      getAuthorities(user.getRole()));
  }

  private Collection<? extends GrantedAuthority> getAuthorities(String role){
    return Collections.singletonList(new SimpleGrantedAuthority(role));
  }
}