package com.doan.Service.User;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doan.Dao.TaiKhoanDao;
import com.doan.Dto.TaiKhoanDto;
import com.doan.Entity.TaiKhoan;

@Service
public class TaiKhoanServiceImpl implements ITaiKhoanService {
	@Autowired
	TaiKhoanDao taiKhoanDao = new TaiKhoanDao();

	public TaiKhoan CheckAccount(TaiKhoan taikhoan) {
		taikhoan = taiKhoanDao.GetUserByAcc(taikhoan);
		if(taikhoan != null  ) {
			return taikhoan;
		}	
		return null;
	}

	public TaiKhoanDto GetInfoByID(String id) {
		TaiKhoanDto listInfos = taiKhoanDao.GetInfoByID(id);
		return listInfos;
	}
}
