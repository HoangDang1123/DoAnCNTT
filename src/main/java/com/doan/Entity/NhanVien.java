package com.doan.Entity;

public class NhanVien {
	private String maNhanVien;
	private String tenNhanVien;
	private int gioiTinh;
	private String sdt;
	private String chucVu;
	
	public NhanVien() {
		super();
	}

	public String getmaNhanVien() {
		return maNhanVien;
	}

	public void setmaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String gettenNhanVien() {
		return tenNhanVien;
	}

	public void settenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public int getgioiTinh() {
		return gioiTinh;
	}

	public void setgioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getsdt() {
		return sdt;
	}

	public void setsdt(String sdt) {
		this.sdt = sdt;
	}
	public String getchucVu() {
		return chucVu;
	}

	public void setchucVu(String chucVu) {
		this.chucVu = chucVu ;
	}	
}
