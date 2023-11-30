package com.doan.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.doan.Dto.SanPhamDto;

public interface IHomeService {
	@Autowired
	public List<SanPhamDto> GetDataProducts();
}
