package com.doan.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doan.Dao.KhachHangDao;
import com.doan.Dao.LoaiSanPhamDao;
import com.doan.Dao.NhanVienDao;
import com.doan.Dao.SanPhamDao;
import com.doan.Dao.TaiKhoanDao;
import com.doan.Dto.KhachHangDto;
import com.doan.Dto.LoaiSanPhamDto;
import com.doan.Dto.NhanVienDto;
import com.doan.Dto.SanPhamDto;
import com.doan.Dto.TaiKhoanDto;

@Service
public class HomeServiceImpl implements IHomeService{
	@Autowired
	private SanPhamDao productsDao;
	public List<SanPhamDto> GetDataProducts() {
		List<SanPhamDto> listProducts = productsDao.GetDataProducts();
		return listProducts;
	}
	
	@Autowired
	private KhachHangDao customersDao;
	public List<KhachHangDto> GetDataCustomers() {
		List<KhachHangDto> listCustomers = customersDao.GetDataCustomers();
		return listCustomers;
	}
	
	@Autowired
	private TaiKhoanDao infosDao;
	public TaiKhoanDto GetInfoByID(String id) {
		TaiKhoanDto listInfos = infosDao.GetInfoByID(id);
		return listInfos;
	}
	
	@Autowired
	private NhanVienDao employeesDao;
	public NhanVienDto GetEmployeeByID(String id) {
		NhanVienDto listEmployees = employeesDao.GetEmployeeByID(id);
		return listEmployees;
	}
	
	@Autowired
	private LoaiSanPhamDao loaiSanPhamDao;
	public List<LoaiSanPhamDto> GetDataLoaiSanPham() {
		List<LoaiSanPhamDto> listLoaiSanPham = loaiSanPhamDao.GetDataLoaiSanPham();
		return listLoaiSanPham;
	}
}