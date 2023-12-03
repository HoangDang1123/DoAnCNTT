package com.doan.Dto;

import java.sql.Date;

public class DonHangDto {
	private int maDonHang;
	private Date ngayDatHang;
	private int tongCong;
	private String maNhanVien;

	public int getmaDonHang() {
		return maDonHang;
	}

	public void setmaDonHang(int maDonHang) {
		this.maDonHang = maDonHang;
	}

	public Date getngayDatHang() {
		return ngayDatHang;
	}

	public void setngayDatHang(Date date) {
		this.ngayDatHang = date;
	}

	public int gettongCong() {
		return tongCong;
	}

	public void settongCong(int tongCong) {
		this.tongCong = tongCong;
	}

	public String getmaNhanVien() {
		return maNhanVien;
	}

	public void setmaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
}