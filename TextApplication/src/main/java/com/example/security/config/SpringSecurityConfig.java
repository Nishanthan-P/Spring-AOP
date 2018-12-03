package com.example.security.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages="com.example.demo.*") 
	public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private AccessDeniedHandler accessDeniedHandler;
	
	private Log log = LogFactory.getLog(this.getClass());
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
		.formLogin()
		.loginPage("/loginPage")
		.failureUrl("").and().logout()
		.logoutSuccessUrl("").permitAll()
		.and()
		.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
		
		 http.csrf().disable();
	}
}
