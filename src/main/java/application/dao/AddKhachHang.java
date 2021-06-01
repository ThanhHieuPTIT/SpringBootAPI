package application.dao;

import application.entity.KhachHang;

public class AddKhachHang {
	private KhachHang khachhang;
	private String matkhau;
	
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	public void setKhachhang(KhachHang khachhang) {
		this.khachhang = khachhang;
	}

	public KhachHang getKhachhang() {
		return khachhang;
	}

	public String getMatkhau() {
		return matkhau;
	}
}
