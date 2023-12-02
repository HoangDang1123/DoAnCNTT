package com.doan.Service.User;

import org.springframework.stereotype.Service;

import com.doan.Dto.KhachHangDto;

@Service
public interface IKhachHangService {
	public KhachHangDto GetCustomerByID(String id);
}
