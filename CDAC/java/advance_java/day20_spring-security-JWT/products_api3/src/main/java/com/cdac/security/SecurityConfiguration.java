package com.cdac.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.AllArgsConstructor;

@Configuration // java config class - equivalent to bean config xml file
@EnableWebSecurity // enables spring security
@EnableMethodSecurity // enables req handling
//method level security
@AllArgsConstructor
public class SecurityConfiguration {
	private final PasswordEncoder passwordEncoder;


	
	// configure bean to customize spring security filter chain
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable()) // disable CSRF token generation
				.authorizeHttpRequests(request -> request
						.requestMatchers("/products/view", "/v*/api-docs/**", "/swagger-ui/**", "/users/signup",
								"/users/signin")
						.permitAll()

						.requestMatchers("/products/add").hasRole("ADMIN")

						.requestMatchers("/products/purchase/**").hasRole("CUSTOMER")

						.anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		return http.build();
	}

	// configure Auth Mgr bean using a depcy 
	// -AuthenticationConfiguration
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

}
