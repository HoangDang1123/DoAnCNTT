package com.doan.Dto;

import java.sql.Date;

public class ChiTietDonHangDto {
	
	private String maSanPham;
	private int soLuong;
	private int giaTien;
	private Date thoiGian;
	private String tenSanPham;
	private int thanhTien;

	public int getThanhTien() {
		return soLuong * giaTien;
	}
	
	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	
	public String getmaSanPham() {
		return maSanPham;
	}

	public void setmaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	public int getsoLuong() {
		return soLuong;
	}
	public void setsoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
	public int getGiaTien() {
		return giaTien;
	}
	public void setGiaTien(int giaTien) {
		this.giaTien = giaTien;
	}
	
	public Date getThoiGian() {
		return thoiGian;
	}
	
	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
	}
}
