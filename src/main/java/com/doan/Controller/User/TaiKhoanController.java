package com.doan.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.doan.Entity.TaiKhoan;
import com.doan.Service.User.TaiKhoanServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class TaiKhoanController extends BaseController {
	private static String manv;
	
	@Autowired
	TaiKhoanServiceImpl accountService = new TaiKhoanServiceImpl();
	
	@RequestMapping(value="/dang-nhap",method= RequestMethod.GET)
	public ModelAndView Register() {
		_mvShare.setViewName("user/account/signin");
		_mvShare.addObject("user", new TaiKhoan());
		return _mvShare;
		
	}
	
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.POST)
	public ModelAndView Login(HttpSession session, @ModelAttribute("user") TaiKhoan taikhoan,
	                          RedirectAttributes redirectAttributes) {
	    taikhoan = accountService.CheckAccount(taikhoan);

	    if (taikhoan != null) {
	        session.setAttribute("LoginInfo", taikhoan);
	        redirectAttributes.addFlashAttribute("taikhoan", taikhoan);
		    manv = taikhoan.getmaNhanVien();
	        return new ModelAndView("redirect:/trang-chu");
	    } else {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.addObject("statusLogin", "Đăng nhập thất bại!");
	        modelAndView.setViewName("your-login-view");
	        return modelAndView;
	    }
	}
	
	@RequestMapping(value="/dang-xuat",method= RequestMethod.GET)
	public String Login(HttpSession session, HttpServletRequest request) {
			session.removeAttribute("LoginInfo");
			return "redirect:" +request.getHeader("Referer");
		}
	
	@RequestMapping(value = "thong-tin")
	public ModelAndView Index() {
	    _mvShare.addObject("taikhoan", _homeService.GetInfoByID(manv));
	    _mvShare.setViewName("user/account/info");
	    return _mvShare;
	}
}
