/**
 * 
 */
package com.demo.app.init.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author vinay
 *
 */
@Configuration
@ComponentScan(basePackages = "com.demo.app.*")
@EnableJpaRepositories("com.demo.app.data.repository")
public class AppConfig {
	// configure for dev / test / prod profiles
	

}
