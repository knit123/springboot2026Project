package com.jobswitch2026.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MySecurityConfig {
	
	@Bean
	public SecurityFilterChain securityfilterchain(HttpSecurity http) {
		
		http.csrf(csrf->csrf.disable())
		.authorizeHttpRequests(auth->auth
				.requestMatchers(HttpMethod.GET, "/employee").hasAnyRole("USER","ADMIN")
				.requestMatchers(HttpMethod.GET, "/employee/all").hasAnyRole("USER","ADMIN")
		        .requestMatchers(HttpMethod.GET,"/employee/get/**").hasAnyRole("USER","ADMIN")
		        .requestMatchers(HttpMethod.DELETE,"/employee/delete/**").hasRole("ADMIN")
		        .requestMatchers(HttpMethod.POST,"/employee/add").hasRole("ADMIN")
		        .anyRequest().authenticated())
		.httpBasic(Customizer.withDefaults());
		return http.build();
		
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userdetailsService() {
		
		UserDetails user=User.builder()
				.username("user")
				.password(passwordEncoder().encode("user@123"))
				.roles("USER").build();
		
		UserDetails user1=User.builder()
				.username("user1")
				.password(passwordEncoder().encode("user1@123"))
				.roles("USER").build();
		
		UserDetails admin=User.builder()
				.username("admin")
				.password(passwordEncoder().encode("admin@123"))
				.roles("ADMIN").build();
		
		return new InMemoryUserDetailsManager(user,user1,admin);
		
	}
}
