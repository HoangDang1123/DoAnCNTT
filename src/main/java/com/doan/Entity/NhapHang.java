package com.doan.Entity;

import java.time.LocalDateTime;
public class NhapHang {
	private String maNhanVien;
	private String maSanPham;
	private LocalDateTime ngayNhapHang;
	private int soLuong; 
	public NhapHang() {
		super();
	}

	public String getmaNhanVien() {
		return maNhanVien;
	}

	public void setmaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getmaSanPham() {
		return maSanPham;
	}

	public void setmaSanPham (String maSanPham) {
		this.maSanPham = maSanPham;
	}
	
    public LocalDateTime getngayNhapHang() {
        return ngayNhapHang;
    }
    public void setngayNhapHang(LocalDateTime ngayNhapHang) {
        this.ngayNhapHang = ngayNhapHang;
    }

	public int getsoLuong() {
		return soLuong;
	}
	
	public void setsoLuong(int soLuong) {
		this.soLuong = soLuong ;
	}	

}
