package application.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "loaisanpham")
public class LoaiSanPhamEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_loaisp")
	private int idLoaiSP;
	
	@Column(name = "tenloai")
	private String tenLoai;
	
//	@OneToMany(mappedBy = "idLoaiSP",cascade = CascadeType.ALL)
//	private Collection<SanPhamEntity> sanPhamEntities;

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public int getIdLoaiSP() {
		return idLoaiSP;
	}

//	public Collection<SanPhamEntity> getSanPhamEntities() {
//		return sanPhamEntities;
//	}
//
//	public void setSanPhamEntities(Collection<SanPhamEntity> sanPhamEntities) {
//		this.sanPhamEntities = sanPhamEntities;
//	}
}
