package com.doan.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
public class MapperKhachHang implements RowMapper<KhachHang> {
	public KhachHang mapRow(ResultSet rs, int rowNum) throws SQLException {
		KhachHang KhachHang = new KhachHang();
		KhachHang.setmaKhachHang(rs.getString("maKhachHang"));
		KhachHang.settenKhachHang(rs.getString("tenKhachHang"));
		KhachHang.setsdt(rs.getString("sdt"));
		return KhachHang;
	}
}
