package com.car.rental.userApp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.car.rental.userApp.service.MyUserDetailsService;

@EnableWebSecurity
public class securityConfigurer extends WebSecurityConfigurerAdapter
{

	@Autowired
	private MyUserDetailsService myUserDetailsService;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(myUserDetailsService);
	}
	
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		
		http
    .authorizeRequests()
	        .anyRequest().permitAll();
		
		
//		 http
//         .authorizeRequests().antMatchers("CarRental/**/**").authenticated()
//             .anyRequest().permitAll();
//		 
		 
		 
//		 http.authorizeRequests()
//         .antMatchers("/users").authenticated()
//         .anyRequest().permitAll()
//         .and()
//         .formLogin()
//             .usernameParameter("email")
//             .defaultSuccessUrl("/users")
//             .permitAll()
//         .and()
//         .logout().logoutSuccessUrl("/").permitAll();
		
	}



	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
		
	}
}
