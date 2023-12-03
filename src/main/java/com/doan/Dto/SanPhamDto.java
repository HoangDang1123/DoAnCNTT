package com.doan.Dto;


public class SanPhamDto {
	private String maSanPham;
	private String tenSanPham;
	private long giaTien;
	private String maLoaiSanPham;
	private int soLuongHienCo;
	
	public SanPhamDto() {
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

	public long getgiaTien() {
		return giaTien;
	}

	public void setgiaTien(long giaTien) {
		this.giaTien = giaTien;
	}

	public String getmaLoaiSanPham() {
		return maLoaiSanPham;
	}

	public void setmaLoaiSanPham(String maLoaiSanPham) {
		this.maLoaiSanPham = maLoaiSanPham;
	}
	
	public int getsoLuongHienCo() {
		return soLuongHienCo;
	}

	public void setsoLuongHienCo(int soLuongHienCo) {
		this.soLuongHienCo = soLuongHienCo;
	}
}
