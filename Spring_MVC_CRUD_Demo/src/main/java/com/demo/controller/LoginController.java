package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.MyUser;
import com.demo.service.LoginService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/security")
public class LoginController {
	@Autowired
	LoginService lservice;

	@GetMapping("/login")
	public String showlogin() {
		return "login";
	}

//	@PostMapping("/validate")
//	public ModelAndView authenticateUser(@RequestParam String uname, @RequestParam String passwd) {
//		if (uname.equals("admin") && passwd.equals("admin")) {
//			String msg = "Valid User";
//			return new ModelAndView("showmsg", "msg", msg);
//		} else {
//			String msg = "Failed to login";
//			return new ModelAndView("login", "msg", msg);
//		}
//	}
	@PostMapping("/validate")
	public ModelAndView authenticateUser(@RequestParam String uname, @RequestParam String passwd, HttpSession session) {

		MyUser user = lservice.validateUser(uname, passwd);
		if (user != null && user.getRole() != null && user.getRole().equals("admin")) {
			session.setAttribute("user", user);
			return new ModelAndView("redirect:/product/products");
		} else {
			String msg = "Failed to login";
			return new ModelAndView("loginpage","msg","Wrong credentials pls reenter");
			
		}
	}
}
