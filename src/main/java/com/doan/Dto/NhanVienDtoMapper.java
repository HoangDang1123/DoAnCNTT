package com.doan.Dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
public class NhanVienDtoMapper implements RowMapper<NhanVienDto> {
	public NhanVienDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		NhanVienDto NhanVien = new NhanVienDto();
		NhanVien.settenNhanVien(rs.getString("tenNhanVien"));
		NhanVien.setmaNhanVien(rs.getString("maNhanVien"));
		NhanVien.setgioiTinh(rs.getInt("gioiTinh"));
		NhanVien.setsdt(rs.getString("sdt"));
		NhanVien.setchucVu(rs.getString("chucVu"));
		return NhanVien;
	}
}