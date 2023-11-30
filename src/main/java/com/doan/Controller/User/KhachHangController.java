package com.doan.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class KhachHangController extends BaseController{
	
	@RequestMapping(value = "khach-hang")
	public ModelAndView Index() {
		_mvShare.addObject("khachhang", _homeService.GetDataCustomers());
		_mvShare.setViewName("user/customers/customer");
		return _mvShare;
	}
}