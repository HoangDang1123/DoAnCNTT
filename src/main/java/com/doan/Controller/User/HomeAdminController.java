package com.doan.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class HomeAdminController {
	
	@RequestMapping(value = "/")
	public String homeAdmin() {
		return "admin/index";
	}
}
