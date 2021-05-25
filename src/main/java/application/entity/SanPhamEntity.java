package application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="sanpham")
public class SanPhamEntity {
	@Id
	@Column(name = "id_sp")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSP;
	
	@Column(name = "tensp")
	private String tenSP;
	
	@Column(name = "gia")
	private int gia;
	
	@Column(name = "anhsp")
	private byte[] anhSP;
	
	@Column(name = "mota")
	private String moTa;
	
	@ManyToOne
	@JoinColumn(name = "id_loaisp")
	private LoaiSanPhamEntity idLoaiSP;
	
	@Column(name = "soluongton")
	private int soLuongTon;

	
	
	public SanPhamEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SanPhamEntity(int idSP, String tenSP, int gia, byte[] anhSP, String moTa, LoaiSanPhamEntity idLoaiSP,
			int soLuongTon) {
		super();
		this.idSP = idSP;
		this.tenSP = tenSP;
		this.gia = gia;
		this.anhSP = anhSP;
		this.moTa = moTa;
		this.idLoaiSP = idLoaiSP;
		this.soLuongTon = soLuongTon;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public byte[] getAnhSP() {
		return anhSP;
	}

	public void setAnhSP(byte[] anhSP) {
		this.anhSP = anhSP;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public LoaiSanPhamEntity getIdLoaiSP() {
		return idLoaiSP;
	}

	public void setIdLoaiSP(LoaiSanPhamEntity idLoaiSP) {
		this.idLoaiSP = idLoaiSP;
	}

	public int getSoLuongTon() {
		return soLuongTon;
	}

	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}

	public int getIdSP() {
		return idSP;
	}
	
	
}
