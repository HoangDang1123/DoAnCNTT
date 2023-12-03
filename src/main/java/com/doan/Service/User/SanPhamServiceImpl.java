package com.doan.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doan.Dao.SanPhamDao;
import com.doan.Dto.SanPhamDto;
import com.doan.Entity.LoaiSanPham;
import com.doan.Entity.SanPham;

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
	
	public int AddProduct(SanPham sanpham) {
		return productDao.AddProduct(sanpham);
	}
	
	public void deleteProduct (String id) {
		productDao.deleteData(id);
	}
	
	public void updateProduct(SanPhamDto sp) {
		productDao.updateData(sp);
	}
}
