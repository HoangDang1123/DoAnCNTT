package com.doan.Dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype. Repository;

import com.doan.Entity.TaiKhoan;
import com.doan.Dto.TaiKhoanDto;
import com.doan.Dto.TaiKhoanDtoMapper;
import com.doan.Entity.MapperTaiKhoan;
@Repository
public class TaiKhoanDao extends BaseDao{
	@Autowired
	protected JdbcTemplate jdbc;
	
	private StringBuffer SqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("maNhanVien");
		sql.append(", tenDangNhap");
		sql.append(", matKhau ");
		sql.append("FROM ");
		sql.append("TaiKhoan ");
		return sql;
	}
	
	public TaiKhoan GetUserByAcc(TaiKhoan taikhoan) {
		String sql = "SELECT * FROM TaiKhoan WHERE tenDangNhap = '" + taikhoan.gettenDangNhap() + "' AND matKhau = '" + taikhoan.getmatKhau() + "'";
		TaiKhoan result = _jdbcTemplate.queryForObject(sql,new MapperTaiKhoan());
		return result;
	};

	public String SqlInfoByID(String id) {
		StringBuffer sql = SqlString();
		sql.append("WHERE maNhanVien = '" + id + "' ");
		return sql.toString();
	}
	
	public TaiKhoanDto GetInfoByID(String id) {
		String sql = SqlInfoByID(id);
		TaiKhoanDto listAccount = _jdbcTemplate.queryForObject(sql, new TaiKhoanDtoMapper());
		return listAccount;
	}
	
	public TaiKhoanDto getById(Serializable taiKhoan) {
		String sql = "SELECT * FROM TaiKhoan WHERE taiKhoan = ?";
		return jdbc.queryForObject(sql, getRowMapper(), taiKhoan);
	}
	
	private RowMapper<TaiKhoanDto> getRowMapper() {
		return new BeanPropertyRowMapper<TaiKhoanDto>(TaiKhoanDto.class);
	}
	
	public List<TaiKhoanDto> getAll() {
		String sql = "SELECT * FROM TaiKhoan";
		return getBySql(sql);
	}
	
	public List<TaiKhoanDto> getAllNhanVienTaiKhoan() {
		String sql = "SELECT * FROM TaiKhoan inner join NhanVien ON TaiKhoan.maNhanVien = NhanVien.maNhanVien";
		return getBySql(sql);
	}
	
	protected List<TaiKhoanDto> getBySql (String sql) {
		return jdbc.query(sql, getRowMapper());
	}
}