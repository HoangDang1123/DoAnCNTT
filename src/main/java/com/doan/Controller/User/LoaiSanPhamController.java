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

import com.doan.Dto.LoaiSanPhamDto;
import com.doan.Dto.SanPhamDto;
import com.doan.Entity.LoaiSanPham;
import com.doan.Service.User.LoaiSanPhamServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class LoaiSanPhamController extends BaseController{
	@Autowired
	LoaiSanPhamServiceImpl loaisanphamService = new LoaiSanPhamServiceImpl();
	
	@RequestMapping(value = "/admin/loai-san-pham")
	public ModelAndView Index() {
		_mvShare.addObject("loaisanpham", _homeService.GetDataLoaiSanPham());
		_mvShare.setViewName("admin/products/loaiSanPham");
		return _mvShare;
	}
	
	@RequestMapping(value="them-loai-san-pham",method= RequestMethod.GET)
	public ModelAndView AddProductType() {
		_mvShare.setViewName("admin/products/addproducttype");
		_mvShare.addObject("loaisanpham", new LoaiSanPham());
		return _mvShare;
		
	}
	
	@RequestMapping(value="them-loai-san-pham",method= RequestMethod.POST)
	public String CreateProductType(HttpServletRequest request, @ModelAttribute("loaisanpham") LoaiSanPham loaisanpham) {
		HttpSession session = request.getSession();
		int count = loaisanphamService.AddProductType(loaisanpham);
		if(count > 0) {
			session.setAttribute("status", "Thêm thành công!");
		}
		else {
			session.setAttribute("status", "Thêm thất bại!");
		}
		return "redirect:" +request.getHeader("Referer");
		
	}

	@RequestMapping(value = "/editProductType/{maLoaiSanPham}", method = RequestMethod.GET)
	public String editProductType(@PathVariable("maLoaiSanPham") String maLoaiSanPham, Model model) {
		LoaiSanPhamDto producttype = loaisanphamService.GetProductTypeByID(maLoaiSanPham);
		model.addAttribute("loaisanpham", producttype);
		return "admin/products/editProductType";
	}

	@RequestMapping(value = "/deleteProductType/{maLoaiSanPham}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable("maLoaiSanPham") String maLoaiSanPham, Model model) {
		loaisanphamService.deleteProductType(maLoaiSanPham);
		model.addAttribute("loaisanpham", _homeService.GetDataLoaiSanPham());
		return "admin/products/loaiSanPham";

	}

	/*
	 * @PostMapping("/update") public ModelAndView
	 * update(@PathVariable("maLoaiSanPham") LoaiSanPhamDto loaisanpham) {
	 * loaisanphamService.updateProductType(loaisanpham);
	 * _mvShare.addObject("loaisanpham", _homeService.GetDataLoaiSanPham());
	 * _mvShare.setViewName("admin/products/loaiSanPham"); return _mvShare; }
	 */
}