package com.doan.Dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.doan.Dto.DonHangDto;

@Repository
public class DonHangDao {
	
	@Autowired
	protected JdbcTemplate jdbc;
	
	protected List<DonHangDto> getBySql (String sql) {
		return jdbc.query(sql, getRowMapper());
	}
	
	private RowMapper<DonHangDto> getRowMapper() {
		return new BeanPropertyRowMapper<DonHangDto>(DonHangDto.class);
	}
	
	public void insert(DonHangDto entity) {
		String sql = "INSERT INTO DonHang(tongCong, maNhanVien) "
				+ "VALUES (?,?)";
		jdbc.update(sql, entity.gettongCong(), entity.getmaNhanVien());
	}
	
	public void updateGia(Serializable maDonHang, int gia) {
		String sql = "UPDATE DonHang SET tongCong = ? WHERE maDonHang = ?";
		jdbc.update(sql, maDonHang, gia);
	}
}
