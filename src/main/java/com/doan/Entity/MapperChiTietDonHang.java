package com.doan.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
public class MapperChiTietDonHang implements RowMapper<ChiTietDonHang> {
	public ChiTietDonHang mapRow(ResultSet rs, int rowNum) throws SQLException {
		ChiTietDonHang ChiTietDonHang = new ChiTietDonHang();
		ChiTietDonHang.setmaDonHang(rs.getString("maDonHang"));
		ChiTietDonHang.setmaSanPham(rs.getString("maSanPham"));
		ChiTietDonHang.setsoLuong(rs.getInt("soLuong"));
		return ChiTietDonHang;
	}
}
