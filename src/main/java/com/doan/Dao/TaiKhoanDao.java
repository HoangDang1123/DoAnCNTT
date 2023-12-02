package com.doan.Dao;

import java.util.List;

import org.springframework.stereotype. Repository;

import com.doan.Entity.TaiKhoan;
import com.doan.Dto.TaiKhoanDto;
import com.doan.Dto.TaiKhoanDtoMapper;
import com.doan.Entity.MapperTaiKhoan;
@Repository
public class TaiKhoanDao extends BaseDao{
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
		String sql ="SELECT * FROM TaiKhoan WHERE tenDangNhap ='"+taikhoan.gettenDangNhap()+"'";
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
}