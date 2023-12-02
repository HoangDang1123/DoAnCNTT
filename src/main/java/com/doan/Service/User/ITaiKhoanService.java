package com.doan.Service.User;

import org.springframework.stereotype.Service;

import com.doan.Dto.TaiKhoanDto;
import com.doan.Entity.TaiKhoan;
@Service
public interface ITaiKhoanService {
	
	public TaiKhoan CheckAccount(TaiKhoan taikhoan);
	
	public TaiKhoanDto GetInfoByID(String id);
}
