package com.doan.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doan.Dao.KhachHangDao;
import com.doan.Dto.KhachHangDto;
import com.doan.Dto.SanPhamDto;
import com.doan.Entity.KhachHang;

@Service
public class KhachHangServiceImpl implements IKhachHangService {
	
	@Autowired
	KhachHangDao customerDao = new KhachHangDao();

	public KhachHangDto GetCustomerByID(String id) {
		List<KhachHangDto> listProducts = customerDao.GetCustomerByID(id);
		return listProducts.get(0);
	}

	/*
	 * public List<KhachHangDto> GetCustomerByIDCategory(String id) { return
	 * customerDao.GetAllCustomersByID(id); }
	 */
	
	public int AddCustomer(KhachHang khachhang) {
		return customerDao.AddCustomer(khachhang);
	}
	
	public void deleteCustomer (String id) {
		customerDao.deleteData(id);
	}
	
	public void updateCustomer(KhachHangDto kh) {
		customerDao.updateData(kh);
	}
}
