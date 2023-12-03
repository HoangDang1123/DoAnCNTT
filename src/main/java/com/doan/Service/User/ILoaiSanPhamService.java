package com.doan.Service.User;

import org.springframework.stereotype.Service;

import com.doan.Entity.LoaiSanPham;

@Service
public interface ILoaiSanPhamService {
	public int AddProductType(LoaiSanPham loaisanpham);
}
