package com.doan.Dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class KhachHangDtoMapper implements RowMapper<KhachHangDto>{
	public KhachHangDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		KhachHangDto KhachHang = new KhachHangDto();
		KhachHang.setmaKhachHang(rs.getString("maKhachHang"));
		KhachHang.settenKhachHang(rs.getString("tenKhachHang"));
		KhachHang.setsdt(rs.getString("sdt"));
		return KhachHang;
	}
}
