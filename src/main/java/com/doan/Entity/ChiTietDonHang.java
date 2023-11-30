package com.doan.Entity;

public class ChiTietDonHang {
	private String maDonHang;
	private String maSanPham;
	private int soLuong;
	

	public ChiTietDonHang() {
		super();
	}

	public String getmaDonHang() {
		return maDonHang;
	}

	public void setmaDonHang(String maDonHang) {
		this.maDonHang = maDonHang;
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
}
