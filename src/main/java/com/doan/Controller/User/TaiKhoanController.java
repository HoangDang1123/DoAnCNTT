package com.doan.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doan.Entity.TaiKhoan;
import com.doan.Service.User.TaiKhoanServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class TaiKhoanController extends BaseController {
	@Autowired
	TaiKhoanServiceImpl accountService = new TaiKhoanServiceImpl();
	
	@RequestMapping(value="/dang-nhap",method= RequestMethod.GET)
	public ModelAndView Register() {
		_mvShare.setViewName("user/account/signin");
		_mvShare.addObject("user", new TaiKhoan());
		return _mvShare;
		
	}
	
	@RequestMapping(value="/dang-nhap",method= RequestMethod.POST)
	public ModelAndView Login(HttpSession session,@ModelAttribute("user") TaiKhoan taikhoan) {
		taikhoan = accountService.CheckAccount(taikhoan);
		
		if(taikhoan != null) {
			_mvShare.setViewName("redirect:trang-chu");
			session.setAttribute("LoginInfo", taikhoan);
		}
		else {
			_mvShare.addObject("statusLogin", "Đăng nhập thất bại!");
		}
		return _mvShare;
	}
	
	@RequestMapping(value="/dang-xuat",method= RequestMethod.GET)
	public String Login(HttpSession session, HttpServletRequest request) {
			session.removeAttribute("LoginInfo");
			return "redirect:" +request.getHeader("Referer");
		}
}
