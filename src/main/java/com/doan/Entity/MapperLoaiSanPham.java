package com.doan.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
public class MapperLoaiSanPham implements RowMapper<LoaiSanPham> {
	public LoaiSanPham mapRow(ResultSet rs, int rowNum) throws SQLException {
		LoaiSanPham LoaiSanPham = new LoaiSanPham();
		LoaiSanPham.setmaLoaiSanPham(rs.getString("maLoaiSanPham"));
		LoaiSanPham.settenLoaiSanPham(rs.getString("tenLoaiSanPham"));
		return LoaiSanPham;
	}
}
