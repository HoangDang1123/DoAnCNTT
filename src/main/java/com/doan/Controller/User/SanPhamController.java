package com.doan.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doan.Dto.SanPhamDto;
import com.doan.Entity.LoaiSanPham;
import com.doan.Entity.SanPham;
import com.doan.Service.User.LoaiSanPhamServiceImpl;
import com.doan.Service.User.SanPhamServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class SanPhamController extends BaseController {

	@Autowired
	SanPhamServiceImpl sanphamService = new SanPhamServiceImpl();

	@RequestMapping(value = "/admin/san-pham")
	public ModelAndView AdminIndex() {
		_mvShare.addObject("sanpham", _homeService.GetDataProducts());
		_mvShare.setViewName("admin/products/product");
		return _mvShare;
	}

	@RequestMapping(value = "/user/xem-san-pham")
	public ModelAndView UserIndex() {
		_mvShare.addObject("sanpham", _homeService.GetDataProducts());
		_mvShare.setViewName("user/products/product");
		return _mvShare;
	}

	@RequestMapping(value = "them-san-pham", method = RequestMethod.GET)
	public ModelAndView AddProduct() {
		_mvShare.setViewName("admin/products/addproduct");
		_mvShare.addObject("sanpham", new SanPham());
		_mvShare.addObject("loaisanpham", _homeService.GetDataLoaiSanPham());
		return _mvShare;

	}

	@RequestMapping(value="them-san-pham",method= RequestMethod.POST)
	public String CreateProduct(HttpServletRequest request, @ModelAttribute("loaisanpham") SanPham sanpham) {
		HttpSession session = request.getSession();
		int count = sanphamService.AddProduct(sanpham);
		if(count > 0) {
			session.setAttribute("status", "Thêm thành công!");
		}
		else {
			session.setAttribute("status", "Thêm thất bại!");
		}
		return "redirect:" +request.getHeader("Referer");
	}

	@RequestMapping(value = "/editProduct/{maSanPham}", method = RequestMethod.GET)
	public String editProduct(@PathVariable("maSanPham") String maSanPham, Model model) {
		SanPhamDto product = sanphamService.GetProductByID(maSanPham);
		model.addAttribute("sanPham", product);
		return "admin/products/editProduct";
	}

	@RequestMapping(value = "/deleteProduct/{maSanPham}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable("maSanPham") String maSanPham, Model model) {
		sanphamService.deleteProduct(maSanPham);
		model.addAttribute("sanpham", _homeService.GetDataProducts());
		return "admin/products/product";

	}

	@PostMapping("/update")
	public ModelAndView update(@PathVariable("sanPham") SanPhamDto sanPham) {
		sanphamService.updateProduct(sanPham);
		_mvShare.addObject("sanpham", _homeService.GetDataProducts());
		_mvShare.setViewName("admin/products/product");
		return _mvShare;
	}
}