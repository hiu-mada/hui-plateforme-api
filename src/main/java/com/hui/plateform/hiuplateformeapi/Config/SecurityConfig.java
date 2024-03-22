package com.hui.plateform.hiuplateformeapi.Config;


import com.hui.plateform.hiuplateformeapi.Service.UserDetailsImp;
import com.hui.plateform.hiuplateformeapi.entity.User;
import com.hui.plateform.hiuplateformeapi.filter.JwtAuth;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
    private final JwtAuth jwtAuth;
    private final CustomAccessDeniedHandler accessDeniedHandler;
    private final UserDetailsImp userDetailsImp;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{


        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET,"/user/admin").hasAnyAuthority("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/user" ).permitAll()
                        .requestMatchers(HttpMethod.POST, "/team").permitAll()
                        .requestMatchers(HttpMethod.GET, "/team").permitAll()
                        .requestMatchers(HttpMethod.GET, "/disciplines/**").permitAll()
                        .requestMatchers(HttpMethod.POST,"/disciplines/**").hasAnyAuthority("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/disciplines/**").hasAnyAuthority("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/disciplines/**").hasAnyAuthority("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/response").permitAll()
                        .requestMatchers(HttpMethod.GET, "/response/**").hasAnyAuthority("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/response/team-by-subject").permitAll()
                        .requestMatchers(HttpMethod.GET,"/**/admin/**").hasAnyAuthority("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/university").permitAll()
                        .requestMatchers(HttpMethod.POST, "/university").hasAnyAuthority("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/university/**").hasAnyAuthority("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/university/**").hasAnyAuthority("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/subject/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/subject").hasAnyAuthority("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/subject/**").hasAnyAuthority("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/subject/**").hasAnyAuthority("ADMIN")
                        .requestMatchers( "/auth/**","/register","/vote/**").permitAll()
                        .anyRequest().authenticated()

                )
                .userDetailsService(userDetailsImp.userDetailsService())
                .exceptionHandling(e -> e.accessDeniedHandler(accessDeniedHandler).authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
                .sessionManagement((session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)))
                .addFilterBefore(jwtAuth, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
