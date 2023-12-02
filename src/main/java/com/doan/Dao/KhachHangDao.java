package com.doan.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.doan.Dto.KhachHangDto;
import com.doan.Dto.KhachHangDtoMapper;

@Repository
public class KhachHangDao extends BaseDao {
	private StringBuffer SqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("maKhachHang");
		sql.append(", tenKhachHang");
		sql.append(", sdt ");
		sql.append("FROM ");
		sql.append("KhachHang");
		return sql;
	}

	private StringBuffer SqlCustomersByID(String id) {
		StringBuffer sql = SqlString();
		sql.append("WHERE maKhachHang = " + id + " ");
		return sql;
	}

	public List<KhachHangDto> GetDataCustomers() {
		String sql = SqlString().toString();
		List<KhachHangDto> listCustomers = _jdbcTemplate.query(sql, new KhachHangDtoMapper());
		return listCustomers;
	}
	
	public List<KhachHangDto> GetAllCustomersByID(String id) {
		String sql = SqlCustomersByID(id).toString();
		List<KhachHangDto> listCustomers = _jdbcTemplate.query(sql, new KhachHangDtoMapper());
		return listCustomers;
	}

	private String SqlCustomerByID(String id) {
		StringBuffer sql = SqlString();
		sql.append("WHERE maKhachHang = " + id + " ");
		return sql.toString();
	}
	
	public List<KhachHangDto> GetCustomerByID(String id) {
		String sql = SqlCustomerByID(id);
		List<KhachHangDto> listCustomer = _jdbcTemplate.query(sql, new KhachHangDtoMapper());
		return listCustomer;
	}
	
	public KhachHangDto FindCustomerByID(String id) {
		String sql = SqlCustomerByID(id);
		KhachHangDto listCustomer = _jdbcTemplate.queryForObject(sql, new KhachHangDtoMapper());
		return listCustomer;
	}
}
