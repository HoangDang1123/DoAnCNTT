package com.doan.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
public class MapperSanPham implements RowMapper<SanPham> {
	public SanPham mapRow(ResultSet rs, int rowNum) throws SQLException {
		SanPham SanPham = new SanPham();
		SanPham.setmaSanPham(rs.getString("maSanPham"));
		SanPham.setmaLoaiSanPham(rs.getString("maLoaiSanPham"));
		SanPham.settenSanPham(rs.getString("tenSanPham")); 
		SanPham.setgiaTien(rs.getLong("giaTien"));
		SanPham.setsoLuongHienCo(rs.getInt("soLuongHienCo"));
		return SanPham;
	}
}
