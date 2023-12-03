package com.doan.Controller.User;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doan.Dto.NhanVienDto;
import com.doan.Dto.SanPhamDto;
import com.doan.Entity.NhanVien;
import com.doan.Service.User.NhanVienServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class NhanVienController extends BaseController{
	@Autowired
	NhanVienServiceImpl nhanvienService = new NhanVienServiceImpl();
	
	@RequestMapping(value = "/admin/nhan-vien")
	public ModelAndView Index() {
		_mvShare.addObject("nhanvien", _homeService.GetDataEmployees());
		_mvShare.setViewName("admin/employees/employee");
		return _mvShare;
	}
	
	@RequestMapping(value="them-nhan-vien",method= RequestMethod.GET)
	public ModelAndView AddCreateEmployee() {
		_mvShare.setViewName("admin/employees/addemployee");
		_mvShare.addObject("nhanvien", new NhanVien());
		_mvShare.addObject("getnhanvien", _homeService.GetDataEmployees());
		return _mvShare;
		
	}
	
	@RequestMapping(value="them-nhan-vien",method= RequestMethod.POST)
	public String CreateEmployee(HttpServletRequest request, @ModelAttribute("nhanvien") NhanVien nhanvien) {
		HttpSession session = request.getSession();
		int count = nhanvienService.AddEmployee(nhanvien);
		if(count > 0) {
			session.setAttribute("status", "Thêm thành công!");
		}
		else {
			session.setAttribute("status", "Thêm thất bại!");
		}
		return "redirect:" +request.getHeader("Referer");
	}

	@RequestMapping(value = "/editEmployee/{maNhanVien}", method = RequestMethod.GET)
	public String editEmployee(@PathVariable("maNhanVien") String maNhanVien, Model model) {
		NhanVienDto employee = nhanvienService.GetEmployeeByID(maNhanVien);
		model.addAttribute("nhanvien", employee);
		return "admin/employees/editEmployee";
	}

	@RequestMapping(value = "/deleteEmployee/{maNhanVien}", method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable("maNhanVien") String maNhanVien, Model model) {
		nhanvienService.deleteEmployee(maNhanVien);
		model.addAttribute("nhanvien", _homeService.GetDataEmployees());
		return "admin/employees/employee";

	}

	/*
	 * @PostMapping("/update") public ModelAndView
	 * updateEmployee(@PathVariable("nhanvien") NhanVienDto nhanvien) {
	 * nhanvienService.updateEmployee(nhanvien); _mvShare.addObject("nhanvien",
	 * _homeService.GetDataEmployees());
	 * _mvShare.setViewName("admin/employees/employee"); return _mvShare; }
	 */
}