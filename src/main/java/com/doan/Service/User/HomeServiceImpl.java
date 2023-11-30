package com.doan.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doan.Dao.KhachHangDao;
import com.doan.Dao.SanPhamDao;
import com.doan.Dto.KhachHangDto;
import com.doan.Dto.SanPhamDto;

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

}