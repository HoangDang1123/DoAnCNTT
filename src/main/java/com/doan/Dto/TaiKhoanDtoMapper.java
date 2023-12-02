package com.doan.Dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
public class TaiKhoanDtoMapper implements RowMapper<TaiKhoanDto> {
	public TaiKhoanDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		TaiKhoanDto TaiKhoan = new TaiKhoanDto();
		TaiKhoan.setmaNhanVien(rs.getString("maNhanVien"));
		TaiKhoan.settenDangNhap(rs.getString("tenDangNhap"));
		TaiKhoan.setmatKhau(rs.getString("matKhau")); 
		return TaiKhoan;
	}
}