package com.doan.Dao;

import org.springframework.stereotype. Repository;

import com.doan.Entity.TaiKhoan;
import com.doan.Entity.MapperTaiKhoan;
@Repository
public class TaiKhoanDao extends BaseDao{
	public int AddAccount (TaiKhoan taikhoan) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT ");
		sql.append("INTO TaiKhoan ");
		sql.append("(");
		sql.append("tenDangNhap,");
		sql.append(" matKhau,");
		sql.append(" maNhanVien,");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("(");
		sql.append("'"+taikhoan.gettenDangNhap()+"', ");
		sql.append("'"+taikhoan.getmatKhau()+"', ");
		sql.append("'"+taikhoan.getmaNhanVien()+"', ");
		sql.append(")");

		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	};
	
	public TaiKhoan GetUserByAcc(TaiKhoan taikhoan) {
		String sql ="SELECT * FROM TaiKhoan WHERE tenDangNhap ='"+taikhoan.gettenDangNhap()+"'";
		TaiKhoan result = _jdbcTemplate.queryForObject(sql,new MapperTaiKhoan());
		return result;
	};
}