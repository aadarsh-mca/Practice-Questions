package com.app.security;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import io.swagger.v3.oas.models.PathItem.HttpMethod;
import lombok.AllArgsConstructor;

@Configuration // java config class - equivalent to bean config xml file

@EnableWebSecurity // enables spring security

@EnableMethodSecurity // enables req handling
//method level security

@AllArgsConstructor
public class SecurityConfiguration {
	private final PasswordEncoder passwordEncoder;

	// configure spring bean to add in memory implementation of UserdetailsService
	@Bean
	UserDetailsService userDetailsService() {
		
		// create user details n populate them in user dtls mgr
		UserDetails user1 = new User(
									"Rama Kher", 
									passwordEncoder.encode("12345"),
									List.of(new SimpleGrantedAuthority("ROLE_CUSTOMER"))
								);
		
		UserDetails user2 = new User("Mihir Pant", passwordEncoder.encode("12345"),
				List.of(new SimpleGrantedAuthority("ROLE_ADMIN")));

		return new InMemoryUserDetailsManager(user1, user2);
	}

	// configure bean to customize spring security filter chain
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.csrf(csrf -> csrf.disable()) // disable CSRF token generation
				.authorizeHttpRequests(
					authorizeHttpRequest -> 
							authorizeHttpRequest
							.requestMatchers("/products/view", "/v*/api-docs/**", "/swagger-ui/**")
							.permitAll()
							
							.requestMatchers("/products/add")
							.hasRole("ADMIN")
							
							.requestMatchers("/products/purchase/**")
							.hasRole("CUSTOMER")
						
							.anyRequest().authenticated() )
				.httpBasic(Customizer.withDefaults());

		return http.build();
	}

}
