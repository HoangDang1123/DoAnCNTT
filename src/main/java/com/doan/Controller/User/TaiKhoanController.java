package com.doan.Controller.User;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.doan.Dao.NhanVienDao;
import com.doan.Dao.TaiKhoanDao;
import com.doan.Dto.NhanVienDto;
import com.doan.Dto.TaiKhoanDto;
import com.doan.Entity.TaiKhoan;
import com.doan.Service.User.TaiKhoanServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class TaiKhoanController extends BaseController {
	private static String manv;
	
	@Autowired
	TaiKhoanServiceImpl accountService = new TaiKhoanServiceImpl();
	
	@Autowired
	private TaiKhoanDao taikhoanDao;

	@Autowired
	private NhanVienDao nhanvienDao;
	
	@RequestMapping(value="/user/dang-nhap",method= RequestMethod.GET)
	public ModelAndView Register() {
		_mvShare.setViewName("user/account/signin");
		_mvShare.addObject("user", new TaiKhoan());
		return _mvShare;
		
	}
	
	@RequestMapping(value = "/user/dang-nhap", method = RequestMethod.POST)
	public String login(@ModelAttribute("user") TaiKhoanDto user, Model model, HttpServletRequest request) {
		String taiKhoan = user.gettenDangNhap();
		String matKhau = user.getmatKhau();

		List<TaiKhoanDto> dsTaiKhoanNhanVien = taikhoanDao.getAllNhanVienTaiKhoan();
		Optional<TaiKhoanDto> matchedUser = dsTaiKhoanNhanVien.stream()
				.filter(taiKhoanDto -> Objects.equals(taiKhoan, taiKhoanDto.gettenDangNhap())
						&& Objects.equals(matKhau, taiKhoanDto.getmatKhau()))
				.findFirst();

		if (matchedUser.isPresent()) {
	        TaiKhoanDto loginInfo = matchedUser.get(); // Sử dụng matchedUser
	        HttpSession session = request.getSession();
	        session.setAttribute("LoginInfo", loginInfo);
	        session.setAttribute("statusLogin", null);
	        Serializable maNhanVien = loginInfo.getmaNhanVien();
	        manv = loginInfo.getmaNhanVien();
	        NhanVienDto nhanVienDangNhap = nhanvienDao.getById(maNhanVien);
	        String chucVu = nhanVienDangNhap.getchucVu();

	        if ("Staff".equals(chucVu)) {
	            return "redirect:/user/";
	        } else {
	            return "redirect:/admin/";
	        }
	    } else {
	    	HttpSession session = request.getSession();
			session.setAttribute("statusLogin", "Tài khoản không tồn tại");
	        return "user/account/signin";
	    }
	}
	
	@RequestMapping(value="/dang-xuat",method= RequestMethod.GET)
	public String Login(HttpSession session, HttpServletRequest request) {
			session.removeAttribute("LoginInfo");
			return "redirect:/user/dang-nhap";
	}
	
	@RequestMapping(value = "/thong-tin")
	public ModelAndView Index() {
	    _mvShare.addObject("taikhoan", _homeService.GetInfoByID(manv));
	    _mvShare.addObject("thongtin", _homeService.GetEmployeeByID(manv));
	    _mvShare.setViewName("user/account/info");
	    return _mvShare;
	}
}
