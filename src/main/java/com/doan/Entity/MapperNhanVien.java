package com.doan.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
public class MapperNhanVien implements RowMapper<NhanVien> {
	public NhanVien mapRow(ResultSet rs, int rowNum) throws SQLException {
		NhanVien NhanVien = new NhanVien();
		NhanVien.setmaNhanVien(rs.getString("maNhanVien"));
		NhanVien.settenNhanVien(rs.getString("tenNhanVien"));
		NhanVien.setgioiTinh(rs.getInt("gioiTinh"));
		NhanVien.setchucVu(rs.getString("chucVu"));
		return NhanVien;
	}
}