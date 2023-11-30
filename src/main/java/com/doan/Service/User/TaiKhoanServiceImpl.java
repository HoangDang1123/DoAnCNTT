package com.doan.Service.User;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doan.Dao.TaiKhoanDao;
import com.doan.Entity.TaiKhoan;

@Service
public class TaiKhoanServiceImpl implements ITaiKhoanService {
	@Autowired
	TaiKhoanDao taiKhoanDao = new TaiKhoanDao();
	
	public int AddAccount(TaiKhoan taikhoan) {
		taikhoan.setmatKhau(BCrypt.hashpw(taikhoan.getmatKhau(), BCrypt.gensalt(12)));
		return taiKhoanDao.AddAccount(taikhoan);
	}

	public TaiKhoan CheckAccount(TaiKhoan taikhoan) {
		String matkhau = taikhoan.getmatKhau();
		taikhoan = taiKhoanDao.GetUserByAcc(taikhoan);
		if(taikhoan != null) {
			return taikhoan;
		}	
		return null;
	}
}
