package com.doan.Dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.doan.Dto.SanPhamDto;
import com.doan.Dto.SanPhamDtoMapper;
import com.doan.Entity.LoaiSanPham;
import com.doan.Entity.SanPham;

@Repository
public class SanPhamDao extends BaseDao {

	private StringBuffer SqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("s.maSanPham");
		sql.append(", s.maLoaiSanPham");
		sql.append(", s.tenSanPham");
		sql.append(", s.giaTien");
		sql.append(", s.soLuongHienCo ");
		sql.append("FROM ");
		sql.append("SanPham AS s ");
		return sql;
	}
	
	public int AddProduct (SanPham sanpham) {
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT ");
			sql.append("INTO SanPham ");
			sql.append("(");
			sql.append("maSanPham,");
			sql.append(" maLoaiSanPham,");
			sql.append(" tenSanPham,");
			sql.append(" giaTien,");
			sql.append(" soLuongHienCo");
			sql.append(") ");
			sql.append("VALUES ");
			sql.append("(");
			sql.append("'"+sanpham.getmaSanPham()+"', ");
			sql.append("'"+sanpham.getmaLoaiSanPham()+"', ");
			sql.append("'"+sanpham.gettenSanPham()+"', ");
			sql.append(+sanpham.getgiaTien()+", ");
			sql.append(sanpham.getsoLuongHienCo());
			sql.append(")");

			int insert = _jdbcTemplate.update(sql.toString());
			return insert;
		}
		catch (DataAccessException e){
			int insert = 0;
			return insert;
		}
	};
	
	public void updateData(SanPhamDto sanpham) {
        String sql = "UPDATE SanPham SET maLoaiSanPham = ?, tenSanPham = ?, giaTien = ?, soLuongHienCo = ? WHERE maSanPham = ?";
        _jdbcTemplate.update(sql, sanpham.getmaLoaiSanPham(), sanpham.gettenSanPham(), sanpham.getgiaTien(), sanpham.getsoLuongHienCo());
	}
	
	public void deleteData(String id) {
        String sql = "DELETE FROM SanPham WHERE maSanPham = ?";
        _jdbcTemplate.update(sql, id);
    }

	private StringBuffer SqlProductsByID(String id) {
		StringBuffer sql = SqlString();
		sql.append("WHERE maSanPham = " + id + " ");
		return sql;
	}

	public List<SanPhamDto> GetDataProducts() {
		String sql = SqlString().toString();
		List<SanPhamDto> listProducts = _jdbcTemplate.query(sql, new SanPhamDtoMapper());
		return listProducts;
	}
	
	public List<SanPhamDto> GetAllProductsByID(String id) {
		String sql = SqlProductsByID(id).toString();
		List<SanPhamDto> listProducts = _jdbcTemplate.query(sql, new SanPhamDtoMapper());
		return listProducts;
	}

	private String SqlProductByID(String id) {
		StringBuffer sql = SqlString();
		sql.append("WHERE s.maSanPham = '" + id + "' ");
		return sql.toString();
	}
	
	public List<SanPhamDto> GetProductByID(String id) {
		String sql = SqlProductByID(id);
		List<SanPhamDto> listProduct = _jdbcTemplate.query(sql, new SanPhamDtoMapper());
		return listProduct;
	}
	
	public SanPhamDto FindProductByID(String id) {
		String sql = SqlProductByID(id);
		SanPhamDto listProduct = _jdbcTemplate.queryForObject(sql, new SanPhamDtoMapper());
		return listProduct;
	}
	
	public void update(SanPhamDto sanPham) {
        String sql = "UPDATE SanPham SET tenSanPham = ?, giaTien = ? WHERE maSanPham = ?";
        _jdbcTemplate.update(sql, sanPham.gettenSanPham(), sanPham.getgiaTien(), sanPham.getmaSanPham());
         
	}
	
	@Autowired
	protected JdbcTemplate jdbc;
	
	protected List<SanPhamDto> getBySql (String sql) {
		return jdbc.query(sql, getRowMapper());
	}
	
	private RowMapper<SanPhamDto> getRowMapper() {
		return new BeanPropertyRowMapper<SanPhamDto>(SanPhamDto.class);
	}
	
	public List<SanPhamDto> getAll() {
		String sql = "SELECT * FROM SanPham";
		return getBySql(sql);
	}
	
	public void updateSoLuong(SanPhamDto entity) {
		String sql = "UPDATE SanPham SET soLuongHienCo = ? WHERE maSanPham = ?";
		jdbc.update(sql, entity.getsoLuongHienCo(), entity.getmaSanPham());
	}
	
	public SanPhamDto getById(Serializable maSanPham) {
		String sql = "SELECT * FROM SanPham WHERE maSanPham = ?";
		return jdbc.queryForObject(sql, getRowMapper(), maSanPham);
	}
}