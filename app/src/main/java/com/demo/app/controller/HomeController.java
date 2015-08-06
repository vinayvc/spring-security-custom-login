/**
 * 
 */
package com.demo.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author vinay
 *
 */

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model){
		System.out.println("inside controller");
		return "index";
	}
	
	@RequestMapping(value = "/admin")
	public String admin(Model model){
		System.out.println("inside controller");
		return "admin";
	}
	
	@RequestMapping(value = "/home")
	public String home(Model model){
		System.out.println("inside controller");
		return "home";
	}
	
	@RequestMapping(value="/logout")
    public String logout(){
        return "logout";
    }
	
	@RequestMapping(value="/login")
    public String login(){
		System.out.println("inside login controller");
        return "login";
    }
	
	
}
