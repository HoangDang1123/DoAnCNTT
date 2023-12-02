package com.doan.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.doan.Dto.NhanVienDto;
import com.doan.Dto.NhanVienDtoMapper;

@Repository
public class NhanVienDao extends BaseDao {
	private StringBuffer SqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("maNhanVien");
		sql.append(", tenNhanVien");
		sql.append(", gioiTinh");
		sql.append(", sdt");
		sql.append(", chucVu ");
		sql.append("FROM ");
		sql.append("NhanVien ");
		return sql;
	}

	private StringBuffer SqlEmployeesByID(String id) {
		StringBuffer sql = SqlString();
		sql.append("WHERE maNhanVien = '" + id + "' ");
		return sql;
	}

	public List<NhanVienDto> GetDataEmployees() {
		String sql = SqlString().toString();
		List<NhanVienDto> listEmployees = _jdbcTemplate.query(sql, new NhanVienDtoMapper());
		return listEmployees;
	}
	
	public List<NhanVienDto> GetAllEmployeesByID(String id) {
		String sql = SqlEmployeesByID(id).toString();
		List<NhanVienDto> listEmployees = _jdbcTemplate.query(sql, new NhanVienDtoMapper());
		return listEmployees;
	}

	private String SqlEmployeeByID(String id) {
		StringBuffer sql = SqlString();
		sql.append("WHERE maNhanVien = '" + id + "' ");
		return sql.toString();
	}
	
	public NhanVienDto GetEmployeeByID(String id) {
		String sql = SqlEmployeeByID(id);
		NhanVienDto listEmployee = _jdbcTemplate.queryForObject(sql, new NhanVienDtoMapper());
		return listEmployee;
	}
}