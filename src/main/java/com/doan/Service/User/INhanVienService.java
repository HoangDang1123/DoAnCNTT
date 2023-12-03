package com.doan.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.doan.Dto.NhanVienDto;
import com.doan.Entity.NhanVien;

@Service
public interface INhanVienService {
	public NhanVienDto GetEmployeeByID(String id);
	
	public int AddEmployee(NhanVien nhanvien);
}
