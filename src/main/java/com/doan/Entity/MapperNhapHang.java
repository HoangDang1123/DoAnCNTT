package com.doan.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;
public class MapperNhapHang implements RowMapper<NhapHang> {
	public NhapHang mapRow(ResultSet rs, int rowNum) throws SQLException {
		NhapHang NhapHang = new NhapHang();
		NhapHang.setmaNhanVien(rs.getString("maNhanVien"));
		NhapHang.setmaSanPham(rs.getString("maSanPham"));
		NhapHang.setngayNhapHang(rs.getDate("ngayNhapHang")); //day ne
		NhapHang.setsoLuong(rs.getInt("soLuong"));
		return NhapHang;
	}
}
