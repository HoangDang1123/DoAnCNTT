package com.doan.Dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SanPhamDtoMapper implements RowMapper<SanPhamDto>{
	public SanPhamDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		SanPhamDto SanPham = new SanPhamDto();
		SanPham.setmaSanPham(rs.getString("maSanPham"));
		SanPham.setmaLoaiSanPham(rs.getString("maLoaiSanPham"));
		SanPham.settenSanPham(rs.getString("tenSanPham"));
		SanPham.setgiaTien(rs.getLong("giaTien"));
		SanPham.setsoLuongHienCo(rs.getInt("soLuongHienCo"));
		return SanPham;
	}
}
