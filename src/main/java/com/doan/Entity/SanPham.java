package com.doan.Entity;

public class SanPham {
	private String maSanPham;
	private String maLoaiSanPham;
	private String tenSanPham;
	private int giaTien;
	
	public SanPham() {
		super();
	}

	public String getmaSanPham() {
		return maSanPham;
	}

	public void setmaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	public String gettenSanPham() {
		return tenSanPham;
	}

	public void settenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public String getmaLoaiSanPham() {
		return maLoaiSanPham;
	}

	public void setmaLoaiSanPham(String maLoaiSanPham) {
		this.maLoaiSanPham = maLoaiSanPham;
	}
	public int getgiaTien() {
		return giaTien;
	}

	public void setgiaTien(int giaTien) {
		this.giaTien = giaTien;
	}


}
