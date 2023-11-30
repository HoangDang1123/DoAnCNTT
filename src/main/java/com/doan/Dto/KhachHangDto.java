package com.doan.Dto;


public class KhachHangDto {
	private String maKhachHang;
	private String tenKhachHang;
	private String sdt;
	
	public KhachHangDto() {
		super();
	}

	public String getmaKhachHang() {
		return maKhachHang;
	}

	public void setmaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String gettenKhachHang() {
		return tenKhachHang;
	}

	public void settenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getsdt() {
		return sdt;
	}

	public void setsdt(String sdt) {
		this.sdt = sdt;
	}
}
