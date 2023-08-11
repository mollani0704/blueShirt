package com.project.blueshirt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.project.blueshirt.config.auth.PrincipalDetailService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig {
	
	private final PrincipalDetailService principalDetailService;
	
	@Bean
	public BCryptPasswordEncoder Encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public WebSecurityCustomizer configure() {
		return (web) -> web.ignoring().mvcMatchers("/static/**");
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http
			.csrf().disable()
			.authorizeRequests()
				.antMatchers("/", "/signin", "/signup", 
							"/auth/**", "/chungCompany", "/estimates/**",
							"/items/**" ,"/review/**" ,"/admin/**", "/api/**", "/image/**", "/order/**" )
				.permitAll()
				.anyRequest()
				.authenticated()
			.and()
				.formLogin()
//				.usernameParameter("userId")
				.loginPage("/signin")
				.loginProcessingUrl("/auth/loginProc")
				.defaultSuccessUrl("/");
		
		return http.build();
	}
	
}
