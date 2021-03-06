package com.kps.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private AuthenticationSuccessHandler successHandler;
	
	@Autowired
	private AuthenticationEntryPoint authenticationEntryPoint;

	@Autowired
	private UserDetailsService userDetailsService;
	
	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("admin").password("admin").roles("ADMIN").and()
			.withUser("dba").password("dba").roles("DBA").and()
			.withUser("user").password("user").roles("USER");
	}*/
	
	//TODO: Retrieve user's information with UserDetailService 
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//TODO: Enable by default. 
		//http.csrf().disable();
		
		//TODO: Redirect user to login page if they're trying to access protected resources.
		http.formLogin()
			.loginPage("/login")
			.usernameParameter("username")
			.passwordParameter("password")
			.successHandler(successHandler);
		
		//TODO: Let the user logout by '/logout'.
		http.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		
		//TODO: Triggered if the user try to access protecting resources while they're not logged in.  
		http.exceptionHandling()
			.authenticationEntryPoint(authenticationEntryPoint);
		
		//TODO: Allow specific user with specific role to access the protected resources.
		http.authorizeRequests()
			.antMatchers("/admin/**").hasAnyRole("ADMIN")
			.antMatchers("/dba/**").hasAnyRole("DBA", "ADMIN")
			.antMatchers("/user/**").hasAnyRole("USER", "DBA", "ADMIN");
		
	}
	
}
