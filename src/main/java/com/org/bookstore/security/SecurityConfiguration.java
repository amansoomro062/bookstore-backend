package com.org.bookstore.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.org.bookstore.dao.UserRepository;

@EnableWebSecurity
@Configuration
@CrossOrigin("http://localhost:4200/")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private UserPrinicipalDetailsService userPrinicipalDetailsService;

	private UserRepository userRepository;

	public SecurityConfiguration(UserRepository userRepository,
			UserPrinicipalDetailsService userPrinicipalDetailsService) {
		this.userRepository = userRepository;
		this.userPrinicipalDetailsService = userPrinicipalDetailsService;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) {

		auth.authenticationProvider(this.authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll()

				
				//general
		
				.antMatchers("/CreateUser").permitAll().antMatchers("/basicauth").authenticated()
				.antMatchers("/profile").authenticated()
				.antMatchers("/userprofile/**").authenticated()
				

				//for testing purpose 
				.antMatchers("/applicationusers").permitAll()
				
				// book
				.antMatchers("/getbooks").permitAll()
				.antMatchers("/getbooks/categories").permitAll()
				
				.antMatchers("/addbook").hasRole("Admin").antMatchers("/updatebook").hasRole("Admin")
				.antMatchers("/deletebook/{id}").hasRole("Admin").antMatchers("/getbooks/maxid").hasRole("Admin")
				.antMatchers("/getusers").hasRole("Admin").antMatchers("/updateusers").hasRole("Admin")

				// cart
				.antMatchers("/addcart").authenticated().antMatchers("/clearcart").authenticated()
				.antMatchers("/deletecart/{id}").authenticated().antMatchers("/getcart").authenticated()
				.antMatchers("/usercarttotleprice").authenticated().antMatchers("/updatecart").authenticated()
				
				
				//order
				
				//update order
				.antMatchers("/order").authenticated()
				.antMatchers("/cancelorder").authenticated()
				
				.antMatchers("/confirmorder").authenticated()
				.antMatchers("/getorders").authenticated()
				.antMatchers("/getallorders").authenticated()

				.and().httpBasic();

	}

	@Bean
	DaoAuthenticationProvider authenticationProvider() {

		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(this.PasswordEncoder());
		daoAuthenticationProvider.setUserDetailsService(this.userPrinicipalDetailsService);

		return daoAuthenticationProvider;
	}

	@Bean
	PasswordEncoder PasswordEncoder() {
		return new BCryptPasswordEncoder();
		// return NoOpPasswordEncoder.getInstance();
	}

}
