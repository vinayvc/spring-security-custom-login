/**
 * 
 */
package com.demo.app.init.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;

/**
 * @author vinay
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public void setGlobalAuthentication(AuthenticationManagerBuilder auth, UserDetailsService userDetailsService) throws Exception{
	
		//Custom
		auth
			.userDetailsService(userDetailsService);
		
		// testing
		/*auth
			.inMemoryAuthentication()
				.withUser("user1").password("user").roles("USER")
				.and()
				.withUser("admin").password("admin").roles("USER","ADMIN");*/
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
 
		http
		.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/home").access("hasRole('ROLE_USER')")
			.antMatchers("/admin").hasRole("ADMIN")
			.and()
		.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/home")
			.and()
		.logout()
			.deleteCookies("JSESSIONID")
			.invalidateHttpSession(true)
			.permitAll();
	}
	
	@Bean
    public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
        return new SecurityEvaluationContextExtension();
    }

}
