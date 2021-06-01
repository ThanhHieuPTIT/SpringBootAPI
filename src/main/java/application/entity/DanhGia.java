package application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="danhgia")
@IdClass(DanhGiaID.class)
public class DanhGia {
	@Id
	private String sdt;
	
	@Id
	@Column(name="id_sp")
	private String idSP;
	
	@Column
	private int vote;
	
	public DanhGia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DanhGia(String sdt, String idSP, int vote) {
		super();
		this.sdt = sdt;
		this.idSP = idSP;
		this.vote = vote;
	}

	public void setIdSP(String idSP) {
		this.idSP = idSP;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public int getVote() {
		return vote;
	}

	public void setVote(int vote) {
		this.vote = vote;
	}

	public String getIdSP() {
		return idSP;
	}
	
}
