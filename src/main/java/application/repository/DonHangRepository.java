package application.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import application.entity.DonHang;

public interface DonHangRepository extends JpaRepository<DonHang, Integer> {
	List<DonHang> findBySdt(String sdt);
	//List<DonHang> findBySdtAndByNgayDatHang(String sdt,Date ngayDatHang);
}
