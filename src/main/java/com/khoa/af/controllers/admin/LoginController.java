package com.khoa.af.controllers.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.khoa.af.api.admin.User;
import com.khoa.af.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/signin")
	public String login(@ModelAttribute("user") User user) {
		
		return "admin/signin";
	}
	
	@PostMapping("/signin")
	public String processLogin(@ModelAttribute("user") User user, HttpSession session) {
		
		User login = userService.login(user.getUserName(), user.getPassword());
		if(login == null) {
			session.setAttribute("login-failed", true);
			return "admin/signin";
		} else {
			session.setAttribute("user", login);
			return "redirect:/admin/user";
		}
	}
	
	@GetMapping("/signout")
	public String showLoginPage(HttpSession session) {
		session.removeAttribute("user");
		session.invalidate();
		return "redirect:/admin/signin";
	}
}
