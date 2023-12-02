package com.doan.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.doan.Dto.KhachHangDto;
import com.doan.Dto.LoaiSanPhamDto;
import com.doan.Dto.NhanVienDto;
import com.doan.Dto.SanPhamDto;
import com.doan.Dto.TaiKhoanDto;

public interface IHomeService {
	@Autowired
	public List<SanPhamDto> GetDataProducts();
	
	@Autowired
	public List<KhachHangDto> GetDataCustomers();
	
	@Autowired
	public TaiKhoanDto GetInfoByID(String id);
	
	@Autowired
	public NhanVienDto GetEmployeeByID(String id);
	
	@Autowired
	public List<LoaiSanPhamDto> GetDataLoaiSanPham();
}
