package com.doan.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.doan.Dto.KhachHangDto;
import com.doan.Dto.KhachHangDtoMapper;
import com.doan.Dto.SanPhamDto;
import com.doan.Entity.KhachHang;
import com.doan.Entity.LoaiSanPham;

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
	
	public int AddCustomer (KhachHang khachhang) {
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT ");
			sql.append("INTO KhachHang ");
			sql.append("(");
			sql.append("maKhachHang,");
			sql.append(" tenKhachHang,");
			sql.append(" sdt");
			sql.append(") ");
			sql.append("VALUES ");
			sql.append("(");
			sql.append("'"+khachhang.getmaKhachHang()+"', ");
			sql.append("'"+khachhang.gettenKhachHang()+"', ");
			sql.append("'"+khachhang.getsdt()+"'");
			sql.append(")");

			int insert = _jdbcTemplate.update(sql.toString());
			return insert;
		}
		catch (DataAccessException e){
			int insert = 0;
			return insert;
		}
	};
	
	public void updateData(KhachHangDto khachhang) {
        String sql = "UPDATE KhachHang SET tenKhachHang = ?, sdt = ? WHERE maKhachHang = ?";
        _jdbcTemplate.update(sql, khachhang.gettenKhachHang(), khachhang.getsdt());
	}
	
	public void deleteData(String id) {
        String sql = "DELETE FROM KhachHang WHERE maKhachHang = ?";
        _jdbcTemplate.update(sql, id);
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
	
	@Autowired
	protected JdbcTemplate jdbc;
	
	protected List<KhachHangDto> getBySql (String sql) {
		return jdbc.query(sql, getRowMapper());
	}
	
	private RowMapper<KhachHangDto> getRowMapper() {
		return new BeanPropertyRowMapper<KhachHangDto>(KhachHangDto.class);
	}
	
	public List<KhachHangDto> getAll() {
		String sql = "SELECT * FROM KhachHang";
		return getBySql(sql);
	}
}
