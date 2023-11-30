package com.doan.Entity;
import java.time.LocalDateTime;
public class DonHang {
	private String maDonHang;
	private String maKhachHang;
	private LocalDateTime  ngayDatHang;
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

    public LocalDateTime getngayDatHang() {
        return ngayDatHang;
    }
    public void setngayDatHang(LocalDateTime ngayDatHang) {
        this.ngayDatHang = ngayDatHang;
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
