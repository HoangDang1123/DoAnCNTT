package com.doan.Dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
public class LoaiSanPhamDtoMapper implements RowMapper<LoaiSanPhamDto> {
	public LoaiSanPhamDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		LoaiSanPhamDto LoaiSanPham = new LoaiSanPhamDto();
		LoaiSanPham.setmaLoaiSanPham(rs.getString("maLoaiSanPham"));
		LoaiSanPham.settenLoaiSanPham(rs.getString("tenLoaiSanPham"));
		return LoaiSanPham;
	}
}
