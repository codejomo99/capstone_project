package com.capstone.jongmin.config;



import com.capstone.jongmin.service.UserDetailService;
import org.springframework.security.core.userdetails.UserDetailsService;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@RequiredArgsConstructor
@Configuration
public class WebSecurityConfig {
  private final UserDetailsService userService;

  // 1. 스프링 시큐리티 기능 비활성화
  @Bean
  public WebSecurityCustomizer configure() {
    return (web) -> web.ignoring()
        .requestMatchers(toH2Console())
        .requestMatchers("/static/**");
  }

  // 2. 특정 HTTP 요청에 대한 웹 기반 보안 구성
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    return http
        .authorizeRequests()
        .requestMatchers("/admin/**").authenticated() // "/admin" 시작하는 URL은 인증 요구
        .anyRequest().permitAll() // 나머지 요청은 모두 허용
        .and()
        .formLogin()
        .loginPage("/login")
        .defaultSuccessUrl("/articles")
        .permitAll()
        .and()
        .logout()
        .logoutSuccessUrl("/login")
        .invalidateHttpSession(true)
        .permitAll()
        .and()
        .csrf().disable()
        .build();
  }


  // 7. 인증 관리자 관련 설정
  @Bean
  public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailService userDetailService) throws Exception {
    return http.getSharedObject(AuthenticationManagerBuilder.class)
        .userDetailsService(userService) // 8. 사용자 정보 서비스 설정
        .passwordEncoder(bCryptPasswordEncoder)
        .and()
        .build();
  }

  @Bean // 9. 패스워드 인코더로 사용할 빈 등록
  public BCryptPasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }


}
