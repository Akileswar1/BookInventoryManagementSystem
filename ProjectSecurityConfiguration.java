package com.cg.bim.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfiguration {
	

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((requests) -> requests
             
                        .requestMatchers("/api/publisher/{publisherId}",
                     	"/api/publisher/name/{name}","api/publisher/city/{city}","api/permrole/{roleNumber}").hasRole("ADMIN")
                        .requestMatchers("/api/reviewers/{reviewerid}","/api/books").hasRole("USER")
                        .requestMatchers("/api/users").authenticated()
                        .requestMatchers("/api/bookAuthors","/register",
                        	     "/api/publishers","/api/book/category/{category}"
                        		,"/api/book/{isbn}","/api/bookreview/{isbn}","/api/book/title/{title}","/api/author/{authorId}",
                        		"/api/author/lastname/{lastname}",
                        		"/api/author/firstname/{firstname}","/api/author/{authorId}",
                        		"/api/publisher/state/{state}","/api/states/{stateId}","/api/user/{userId}",
                        		"/api/inventory/{inventoryId}","api/inventorys","/api/bookCondition/{ranks}","/api/category/{catId}",
                        		
                        		"/api/purchaselog/{userId}","/api/authors",
                        		"/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**").permitAll())
                 .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());               
//                .oauth2Login(Customizer.withDefaults());
           return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}