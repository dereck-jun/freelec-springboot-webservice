package com.jojoldu.book.freelecspringbootwebservice.config.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;
import org.springframework.security.web.SecurityFilterChain;

import static com.jojoldu.book.freelecspringbootwebservice.domain.user.Role.USER;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    protected SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(
                        AbstractHttpConfigurer::disable
                )
                .headers(headersConfigurer ->
                        headersConfigurer.frameOptions(
                                FrameOptionsConfig::disable
                        )
                )
                .authorizeHttpRequests(authorizeRequest ->
                        authorizeRequest
                                .requestMatchers("/", "/css/**", "/js/**", "/images/**", "/h2-console/**").permitAll()
                                .requestMatchers("/api/v1/**").hasRole(USER.name())
                                .anyRequest().authenticated()
                )
                .logout(logout ->
                        logout.logoutSuccessUrl("/")
                )
                .oauth2Login(oauth ->
                        oauth.userInfoEndpoint(
                                oauthService ->
                                        oauthService.userService(customOAuth2UserService)
                        )
                );
        return http.build();
    }
}
