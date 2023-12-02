package com.doan.Service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doan.Dao.NhanVienDao;
import com.doan.Dto.NhanVienDto;

@Service
public class NhanVienServiceImpl implements INhanVienService {
	
	@Autowired
	NhanVienDao employeeDao = new NhanVienDao();

	public NhanVienDto GetEmployeeByID(String id) {
		NhanVienDto listEmployee = employeeDao.GetEmployeeByID(id);
		return listEmployee;
	}
}
