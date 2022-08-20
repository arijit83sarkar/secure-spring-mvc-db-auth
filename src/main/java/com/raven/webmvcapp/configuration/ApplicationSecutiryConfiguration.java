package com.raven.webmvcapp.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ApplicationSecutiryConfiguration extends WebSecurityConfigurerAdapter {

	@Qualifier("jdbcDataSource")
	@Autowired
	private DataSource jdbcDataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// add jdbc datasource for jdbc authentication
		auth.jdbcAuthentication().dataSource(jdbcDataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/showCustomLoginPage")
				.loginProcessingUrl("/authenticateTheUser").permitAll().and().logout().permitAll();
	}
}
