package com.doan.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
public class MapperDonHang implements RowMapper<DonHang> {
	public DonHang mapRow(ResultSet rs, int rowNum) throws SQLException {
		DonHang DonHang = new DonHang();
		DonHang.setmaDonHang(rs.getString("maDonHang"));
		DonHang.setmaKhachHang(rs.getString("maKhachHang"));
		DonHang.settongCong(rs.getInt("tongCong"));
		DonHang.setngayDatHang(rs.getDate("ngayDatHang")); //day ne
		DonHang.setmaNhanVien(rs.getString("maNhanVien"));
		return DonHang;
	}
}