package com.doan.Controller.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.doan.Dao.ChiTietDonHangDao;
import com.doan.Dao.DonHangDao;
import com.doan.Dao.KhachHangDao;
import com.doan.Dao.SanPhamDao;
import com.doan.Dto.ChiTietDonHangDto;
import com.doan.Dto.DonHangDto;
import com.doan.Dto.KhachHangDto;
import com.doan.Dto.SanPhamDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/user")
public class HomeUserController {

	@Autowired
	SanPhamDao sanphamDao;

	@Autowired
	DonHangDao donhangDao;

	@Autowired
	ChiTietDonHangDao chitietdonhangDao;

	@Autowired
	KhachHangDao khachhangDao;

	@RequestMapping(value = "/")
	public String homeUser() {
		return "user/index";
	}

	@RequestMapping(value = "/thanh-toan", method = RequestMethod.GET)
	public String thanhToan() {
		return "user/thanhtoan";
	}

	@ModelAttribute("sanpham")
	public List<SanPhamDto> getAllSanPham() {
		return sanphamDao.getAll();
	}

	@ModelAttribute("customerList")
	public List<KhachHangDto> getAllKhachHang() {
		return khachhangDao.getAll();
	}

	@RequestMapping(value = "/thanh-toan", method = RequestMethod.POST)
	public String muaHang(HttpServletRequest request, @RequestParam("maSanPhamInput") String maSanPham,
			@RequestParam("soLuongInput") int soLuong, @RequestParam("giaTienInput") int giaTien) {

		/*
		 * String maSanPham = request.getParameter("maSanPham"); int soLuong =
		 * Integer.parseInt(request.getParameter("soLuong")); int giaTien =
		 * Integer.parseInt(request.getParameter("giaTien"));
		 */
		ChiTietDonHangDto chitietdonhang = new ChiTietDonHangDto();
		chitietdonhang.setmaSanPham(maSanPham);
		chitietdonhang.setGiaTien(giaTien);
		chitietdonhang.setsoLuong(soLuong);

		chitietdonhangDao.insert(chitietdonhang);

		return "user/thanhtoan";
	}

	@RequestMapping(value = "/xuat-hoa-don", method = RequestMethod.POST)
	public String hoaDon(Model model) {

		List<ChiTietDonHangDto> donHang = chitietdonhangDao.getAll();

		int soLuong = chitietdonhangDao.tongTien();

		model.addAttribute("chiTietDonHangList", donHang);
		model.addAttribute("tongTien", soLuong);

		return "user/hoadon";
	}

	@RequestMapping(value = "/xuat-hoa-don", method = RequestMethod.GET)
	public String xuatHoaDon (Model model, HttpSession session, 
			@RequestParam("tongTien") int tongTien,
			@RequestParam("tenNhanVien") String tenNhanVien) {
        
        DonHangDto donHang = new DonHangDto();
        donHang.settongCong(tongTien);
        donHang.setmaNhanVien(tenNhanVien);
        
        donhangDao.insert(donHang);
        
        List<ChiTietDonHangDto> donHang1 = chitietdonhangDao.getAll();
        List<SanPhamDto> dsSanPham = sanphamDao.getAll();
        
        for (ChiTietDonHangDto chiTietDonHang : donHang1) {
            // Lấy thông tin từ ChiTietDonHangDto
            int soLuongHienCo = chiTietDonHang.getsoLuong();
            String maSanPham = chiTietDonHang.getmaSanPham();

            // Tạo một đối tượng SanPhamDto để thực hiện cập nhật
            
            SanPhamDto sanPhamDto = new SanPhamDto();
            sanPhamDto.setmaSanPham(maSanPham);
            sanPhamDto = sanphamDao.getById(sanPhamDto.getmaSanPham());
            sanPhamDto.setsoLuongHienCo(sanPhamDto.getsoLuongHienCo()-soLuongHienCo);

            // Gọi phương thức updateSoLuong
            sanphamDao.updateSoLuong(sanPhamDto);
        }
        
        chitietdonhangDao.deleteAll();
        
        return "redirect:thanh-toan";
	}
}
