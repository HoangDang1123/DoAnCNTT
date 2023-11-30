package com.doan.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.doan.Service.User.BillsServiceImpl;
import com.doan.Service.User.CartServiceImpl;
import com.doan.Service.User.IProductService;
import com.doan.Service.User.ProductServiceImpl;

@Controller
public class ProductController extends BaseController{
	
	@Autowired
	private ProductServiceImpl productService = new ProductServiceImpl();
	
	@RequestMapping(value = "san-pham")
	public ModelAndView Index() {
		_mvShare.addObject("slides", _homeService.GetDataSlide());
		_mvShare.addObject("categorys", _homeService.GetDataCategorys());
		_mvShare.addObject("products", _homeService.GetDataProducts());
		_mvShare.setViewName("user/product/product");
		return _mvShare;
	}
}