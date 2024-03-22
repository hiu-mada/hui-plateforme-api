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
                        .requestMatchers(HttpMethod.DELETE,"/user/**").denyAll()

                        .requestMatchers(HttpMethod.PUT,"/user/**").hasAnyAuthority("Admin")
                        .requestMatchers(HttpMethod.PUT,"/vote/**").hasAnyAuthority("Admin")
                        .requestMatchers(HttpMethod.DELETE,"/vote/**").hasAnyAuthority("Admin")
                        .requestMatchers(HttpMethod.GET,"/admin_only/**").hasAnyAuthority("ADMIN")
                        .requestMatchers( "/auth/**","/register","/vote/**").permitAll()
            .requestMatchers(HttpMethod.PUT,"/user/**").denyAll()
                        .requestMatchers(HttpMethod.PUT,"/vote/**").denyAll()
                        .requestMatchers(HttpMethod.DELETE,"/vote/**").denyAll()
                        .requestMatchers(HttpMethod.GET, "/user/**" ).permitAll()
                        .requestMatchers( "/auth/**","/vote/**").permitAll()

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
