package com.doan.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import com.doan.Dto.SanPhamDto;

@Service
public interface ISanPhamService {
	public SanPhamDto GetProductByID(String id);
	
	public List<SanPhamDto> GetProductByIDCategory(String id);
}
