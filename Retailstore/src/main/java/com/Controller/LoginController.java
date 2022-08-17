package com.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Bean.Customer;
import com.Service.customerService;


@Controller
public class LoginController {
	
	@Autowired
	private customerService customerService;
	

	@RequestMapping("/")
	public ModelAndView loginPageController() {
		return new ModelAndView("Login", "command", new Customer());
	}

//	@RequestMapping("/login")
//	public ModelAndView loginController(@ModelAttribute Customer customer,HttpSession session) {
//		
//		ModelAndView modelAndView=new ModelAndView();
//		if (customerService.searchCustomer(customer)) {
//			modelAndView.addObject("customer", customer);  //user object added at request scope
//			session.setAttribute("customer", customer);
//			modelAndView.setViewName("index");
//		}		
//		else {
//			modelAndView.addObject("message", "Invalid Credentials");
//			modelAndView.addObject("command", new Customer());
//			modelAndView.setViewName("Login");
//		}
//		return modelAndView;
//	}
	

}
