package com.microservices.user.user_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	//For AUTHORIZATION
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			//-	Actual/real Way to do it without disabling the csrf tokens
		   .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		   .and()
		   .authorizeRequests()
		   .antMatchers("/public/**").hasRole("NORMAL")
		   .antMatchers("/users/**").hasRole("ADMIN")
		   .anyRequest()
		   .authenticated()
		   .and()
		   //NOTE - In most of cases, Form-based Authentication is used to authenticate a web browser based client and an API,
		   //and Basic Auth is used for authentication between API’s.
		 
		   //.formLogin(); //Form based authentication - Didnt work from POSTMAN, only worked from Swagger/browser
		 .httpBasic(); //This is Http basic authentication ,and it gives login pop-up on browser 
	}

	//For AUTHENTICATION
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("john")
		                             .password(this.passwordEncoder().encode("durgesh")).roles("NORMAL");
		auth.inMemoryAuthentication().withUser("roshni")
									 .password(this.passwordEncoder().encode("durgesh")).roles("ADMIN");
	}
	
	//we give this password encoder as when we want to store the password we cant save it an plain text
	@Bean
	public PasswordEncoder passwordEncoder() {
		//return NoOpPasswordEncoder.getInstance();
		return new BCryptPasswordEncoder(10);
	}
	
}
