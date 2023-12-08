package com.doan.Dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.doan.Dto.LoaiSanPhamDto;
import com.doan.Dto.LoaiSanPhamDtoMapper;
import com.doan.Dto.SanPhamDto;
import com.doan.Dto.SanPhamDtoMapper;
import com.doan.Entity.LoaiSanPham;

@Repository
public class LoaiSanPhamDao extends BaseDao {

	private StringBuffer SqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("lsp.maLoaiSanPham");
		sql.append(", lsp.tenLoaiSanPham ");
		sql.append("FROM ");
		sql.append("LoaiSanPham AS lsp ");
		return sql;
	}

	public int AddProductType (LoaiSanPham loaisanpham) {
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT ");
			sql.append("INTO LoaiSanPham ");
			sql.append("(");
			sql.append("maLoaiSanPham,");
			sql.append(" tenLoaiSanPham");
			sql.append(") ");
			sql.append("VALUES ");
			sql.append("(");
			sql.append("'"+loaisanpham.getmaLoaiSanPham()+"', ");
			sql.append("'"+loaisanpham.gettenLoaiSanPham()+"'");
			sql.append(")");

			int insert = _jdbcTemplate.update(sql.toString());
			return insert;
		}
		catch (DataAccessException e){
			int insert = 0;
			return insert;
		}
	};
	
	public void updateData(LoaiSanPhamDto loaisanpham) {
        String sql = "UPDATE SanPham SET tenLoaiSanPham = ? WHERE maLoaiSanPham = ?";
        _jdbcTemplate.update(sql, loaisanpham.gettenLoaiSanPham());
	}
	
	public void deleteData(String id) {
        String sql = "DELETE FROM LoaiSanPham WHERE maLoaiSanPham = ?";
        _jdbcTemplate.update(sql, id);
    }

	public List<LoaiSanPhamDto> GetDataLoaiSanPham() {
		String sql = SqlString().toString();
		List<LoaiSanPhamDto> listLoaiSanPham = _jdbcTemplate.query(sql, new LoaiSanPhamDtoMapper());
		return listLoaiSanPham;
	}
	
	private String SqlProductTypeByID(String id) {
		StringBuffer sql = SqlString();
		sql.append("WHERE lsp.maloaiSanPham = '" + id + " '");
		return sql.toString();
	}
	
	public List<LoaiSanPhamDto> GetProductTypeByID(String id) {
		String sql = SqlProductTypeByID(id);
		List<LoaiSanPhamDto> listProductType = _jdbcTemplate.query(sql, new LoaiSanPhamDtoMapper());
		return listProductType;
	}
	
	/*
	 * public List<SanPhamDto> GetAllProductsByID(String id) { String sql =
	 * SqlProductsByID(id).toString(); List<SanPhamDto> listProducts =
	 * _jdbcTemplate.query(sql, new SanPhamDtoMapper()); return listProducts; }
	 */
	
	/*
	 * public List<SanPhamDto> GetDataProductsPaginate(String id, int start, int
	 * totalPage) { StringBuffer sqlGetDataByID = SqlProductsByID(id);
	 * List<SanPhamDto> listProductsByID =
	 * _jdbcTemplate.query(sqlGetDataByID.toString(), new SanPhamDtoMapper());
	 * List<SanPhamDto> listProducts = new ArrayList<SanPhamDto>();
	 * if(listProductsByID.size() > 0) { String sql = SqlProductsPaginate(id, start,
	 * totalPage); listProducts = _jdbcTemplate.query(sql, new SanPhamDtoMapper());
	 * } return listProducts; }
	 */

	/*
	 * private String SqlProductByID(String id) { StringBuffer sql = SqlString();
	 * sql.append("WHERE s.maSanPham = " + id + " "); return sql.toString(); }
	 */
	
	/*
	 * public List<SanPhamDto> GetProductByID(String id) { String sql =
	 * SqlProductByID(id); List<SanPhamDto> listProduct = _jdbcTemplate.query(sql,
	 * new SanPhamDtoMapper()); return listProduct; }
	 * 
	 * public SanPhamDto FindProductByID(String id) { String sql =
	 * SqlProductByID(id); SanPhamDto listProduct =
	 * _jdbcTemplate.queryForObject(sql, new SanPhamDtoMapper()); return
	 * listProduct; }
	 */
}
