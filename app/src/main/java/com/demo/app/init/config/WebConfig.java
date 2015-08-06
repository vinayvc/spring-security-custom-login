/**
 * 
 */
package com.demo.app.init.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author vinay
 *
 */

@Controller
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

	@Bean
	public InternalResourceViewResolver getResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/doc_root/jsp/");
		resolver.setSuffix(".jsp");
		System.out.println("returning resolver");
		return resolver;
	}
	
}
