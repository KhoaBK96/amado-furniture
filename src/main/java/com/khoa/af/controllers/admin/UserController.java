package com.khoa.af.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khoa.af.api.admin.User;
import com.khoa.af.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/admin/user")
	public String showUser(Model model) {
		
		List<User> userList = userService.loadUser();
				
		model.addAttribute("users", userList);
		
		return "admin/user-list";
	}
	
	@GetMapping("/admin/addUser")
	public String addUser(Model model) {
		
		User user = new User();
		
		model.addAttribute("user", user);
		System.out.println(user.getUserId());
		return "admin/add-user";
	}
	
	@PostMapping("/admin/save-user")
	public String saveUser(User user) {
		
		if(user.getUserId() == 0) {
			
			userService.saveUser(user);

		}else {
			
			userService.update(user);
		}
				
		return "redirect:/admin/user";
	}
	
	@GetMapping("/admin/updateUser")
	public String updateUser(@RequestParam("userId") int id, Model model) {
		
		User user = userService.getUser(id);
		
		model.addAttribute("user", user);
		
		return "admin/add-user";				
	}
	
	@ResponseBody
	@PostMapping("/admin/deleteUser")
	public String deleteUser(@RequestParam("userId") int id) {
		
		boolean result = userService.deleteUser(id);
		
		return String.valueOf(result);
		
	}
}
