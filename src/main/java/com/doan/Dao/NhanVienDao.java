package com.doan.Dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.doan.Dto.NhanVienDto;
import com.doan.Dto.NhanVienDtoMapper;
import com.doan.Dto.SanPhamDto;
import com.doan.Entity.NhanVien;

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
	
	public int AddEmployee (NhanVien NhanVien) {
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT ");
			sql.append("INTO NhanVien ");
			sql.append("(");
			sql.append("maNhanVien,");
			sql.append(" tenNhanVien,");
			sql.append(" gioiTinh,");
			sql.append(" sdt,");
			sql.append(" chucVu");
			sql.append(") ");
			sql.append("VALUES ");
			sql.append("(");
			sql.append("'"+NhanVien.getmaNhanVien()+"', ");
			sql.append("'"+NhanVien.gettenNhanVien()+"', ");
			sql.append("'"+NhanVien.getgioiTinh()+"', ");
			sql.append("'"+NhanVien.getsdt()+"', ");
			sql.append("'"+NhanVien.getchucVu()+"'");
			sql.append(")");

			int insert = _jdbcTemplate.update(sql.toString());
			return insert;
		}
		catch (DataAccessException e){
			int insert = 0;
			return insert;
		}
	};
	
	public void updateData(NhanVienDto nhanvien) {
        String sql = "UPDATE NhanVien SET tenNhanVien = ?, gioiTinh = ?, sdt = ?, chucVu = ? WHERE maNhanVien = ?";
        _jdbcTemplate.update(sql, nhanvien.gettenNhanVien(), nhanvien.getgioiTinh(), nhanvien.getsdt(), nhanvien.getchucVu());
	}
	
	public void deleteData(String id) {
        String sql = "DELETE FROM NhanVien WHERE maNhanVien = ?";
        _jdbcTemplate.update(sql, id);
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
	
	@Autowired
	protected JdbcTemplate jdbc;
	
	public NhanVienDto getById(Serializable maNhanVien) {
		String sql = "SELECT * FROM NhanVien WHERE maNhanVien = ?";
		return jdbc.queryForObject(sql, getRowMapper(), maNhanVien);
	}
	
	private RowMapper<NhanVienDto> getRowMapper() {
		return new BeanPropertyRowMapper<NhanVienDto>(NhanVienDto.class);
	}

	protected List<NhanVienDto> getBySql(String sql) {
		return jdbc.query(sql, getRowMapper());
	}
}