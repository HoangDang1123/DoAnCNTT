package com.doan.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doan.Dao.SanPhamDao;
import com.doan.Dto.SanPhamDto;

@Service
public class SanPhamServiceImpl implements ISanPhamService {
	
	@Autowired
	SanPhamDao productDao = new SanPhamDao();

	public SanPhamDto GetProductByID(String id) {
		List<SanPhamDto> listProducts = productDao.GetProductByID(id);
		return listProducts.get(0);
	}

	public List<SanPhamDto> GetProductByIDCategory(String id) {
		return productDao.GetAllProductsByID(id);
	}
}
