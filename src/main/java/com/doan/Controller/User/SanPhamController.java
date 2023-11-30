package com.doan.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class SanPhamController extends BaseController{
	
	@RequestMapping(value = "san-pham")
	public ModelAndView Index() {
		_mvShare.addObject("sanpham", _homeService.GetDataProducts());
		_mvShare.setViewName("user/products/product");
		return _mvShare;
	}
}