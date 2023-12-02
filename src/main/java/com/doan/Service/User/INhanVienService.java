package com.doan.Service.User;

import org.springframework.stereotype.Service;

import com.doan.Dto.NhanVienDto;

@Service
public interface INhanVienService {
	public NhanVienDto GetEmployeeByID(String id);
}
