package com.doan.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.doan.Dto.SanPhamDto;
import com.doan.Dto.SanPhamDtoMapper;

@Repository
public class SanPhamDao extends BaseDao {

	private StringBuffer SqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("s.maSanPham");
		sql.append(", s.maLoaiSanPham");
		sql.append(", s.tenSanPham");
		sql.append(", s.giaTien ");
		sql.append("FROM ");
		sql.append("SanPham AS s ");
		return sql;
	}

	private StringBuffer SqlProductsByID(String id) {
		StringBuffer sql = SqlString();
		sql.append("WHERE maSanPham = " + id + " ");
		return sql;
	}
	
	private String SqlProductsPaginate(String id, int start, int totalPage) {
		StringBuffer sql = SqlProductsByID(id);
		sql.append("ORDER BY NEWID() ");
		sql.append("OFFSET " + start + " ROWS FETCH NEXT " + totalPage + " ROWS ONLY");
		return sql.toString();
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
	
	public List<SanPhamDto> GetDataProductsPaginate(String id, int start, int totalPage) {
		StringBuffer sqlGetDataByID = SqlProductsByID(id);
		List<SanPhamDto> listProductsByID = _jdbcTemplate.query(sqlGetDataByID.toString(), new SanPhamDtoMapper());
		List<SanPhamDto> listProducts = new ArrayList<SanPhamDto>();
		if(listProductsByID.size() > 0) {
			String sql = SqlProductsPaginate(id, start, totalPage);
			listProducts = _jdbcTemplate.query(sql, new SanPhamDtoMapper());
		}
		return listProducts;
	}

	private String SqlProductByID(String id) {
		StringBuffer sql = SqlString();
		sql.append("WHERE s.maSanPham = " + id + " ");
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
}