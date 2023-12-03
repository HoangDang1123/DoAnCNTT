package com.doan.Service.User;

import org.springframework.stereotype.Service;

import com.doan.Dto.KhachHangDto;
import com.doan.Entity.KhachHang;

@Service
public interface IKhachHangService {
	public KhachHangDto GetCustomerByID(String id);
	
	public int AddCustomer(KhachHang khachhang);
}
