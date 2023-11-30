package com.doan.Entity;
import java.sql.Date;
import java.time.LocalDateTime;
public class DonHang {
	private String maDonHang;
	private String maKhachHang;
	private Date  ngayDatHang;
	private int tongCong;
	private String maNhanVien;
	

	public DonHang() {
		super();
	}

	public String getmaDonHang() {
		return maDonHang;
	}

	public void setmaDonHang(String maDonHang) {
		this.maDonHang = maDonHang;
	}

	public String getmaKhachHang() {
		return maKhachHang;
	}

	public void setmaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
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
