package com.doan.Service.User;

import org.springframework.stereotype.Service;

import com.doan.Entity.TaiKhoan;
@Service
public interface ITaiKhoanService {
	public int AddAccount(TaiKhoan taikhoan);
	
	public TaiKhoan CheckAccount(TaiKhoan taikhoan);
}
