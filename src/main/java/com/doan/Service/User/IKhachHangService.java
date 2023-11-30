package com.doan.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import com.doan.Dto.KhachHangDto;

@Service
public interface IKhachHangService {
	public KhachHangDto GetCustomerByID(String id);
	
	public List<KhachHangDto> GetCustomerByIDCategory(String id);
}
