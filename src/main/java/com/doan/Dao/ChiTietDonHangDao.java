package com.doan.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.doan.Dto.ChiTietDonHangDto;

@Repository
public class ChiTietDonHangDao {
	
	@Autowired
	protected JdbcTemplate jdbc;
	
	private RowMapper<ChiTietDonHangDto> getRowMapper() {
		return new BeanPropertyRowMapper<ChiTietDonHangDto>(ChiTietDonHangDto.class);
	}

	protected List<ChiTietDonHangDto> getBySql(String sql) {
		return jdbc.query(sql, getRowMapper());
	}
	
	public void insert(ChiTietDonHangDto entity) {
		String sql = "INSERT INTO ChiTietDonHang(maSanPham, giaTien, soLuong) "
				+ "VALUES (?,?,?)";
		jdbc.update(sql, entity.getmaSanPham(),entity.getGiaTien(), entity.getsoLuong());
	}
	
	public int tongTien() {
		String sql = "SELECT SUM(soLuong * giaTien) AS TongTien FROM ChiTietDonHang";

		// Sử dụng queryForObject để trả về một giá trị duy nhất (int)
		Integer tongTien = jdbc.queryForObject(sql, Integer.class);

		// Nếu tổng tiền là null, trả về 0
		return tongTien != null ? tongTien : 0;
	}
	
	public List<ChiTietDonHangDto> getAll() {
		String sql = "SELECT * FROM ChiTietDonHang LEFT JOIN SanPham ON ChiTietDonHang.maSanPham = SanPham.maSanPham";
		return getBySql(sql);
	}
	
	public void deleteAll() {
		String sql = "DELETE FROM ChiTietDonHang";
		jdbc.update(sql);
	}
}