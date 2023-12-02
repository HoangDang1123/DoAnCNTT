package com.doan.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoaiSanPhamController extends BaseController{
	
	@RequestMapping(value = "loai-san-pham")
	public ModelAndView Index() {
		_mvShare.addObject("loaisanpham", _homeService.GetDataLoaiSanPham());
		_mvShare.setViewName("user/products/loaiSanPham");
		return _mvShare;
	}
}