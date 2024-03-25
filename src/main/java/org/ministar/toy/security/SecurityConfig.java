package org.ministar.toy.security;

import org.ministar.toy.domain.Interests;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //패스워드 암호화
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.headers((headerConfig) ->
                        headerConfig.frameOptions(frameOptionsConfig ->
                                frameOptionsConfig.disable()
                        )
                )
                .authorizeHttpRequests((authorizeHttpRequests) ->
                        authorizeHttpRequests
                                .requestMatchers("/css/**","/js/**","/exam_css/**").permitAll()
                                .requestMatchers(PathRequest.toH2Console()).permitAll()
                                .requestMatchers("/", "/login","/join").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/sign/login")
                        .defaultSuccessUrl("/", true)
                        .permitAll()
                );


        return http.build();
    }

}
