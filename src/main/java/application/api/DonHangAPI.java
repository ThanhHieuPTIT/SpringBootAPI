package application.api;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import application.dao.GetCTDonHang;
import application.dao.GetDonHang;
import application.entity.DonHang;
import application.entity.SanPham;
import application.service.DonHangService;
import application.service.KhacHangService;

@RestController
public class DonHangAPI {
	@Autowired
	private DonHangService service;
	
	@Autowired
	private KhacHangService khachHangService;
	
	@GetMapping("/donhang")
	public List<GetDonHang> list(){
		List<DonHang> listDonHang = service.listAll();
		List<GetDonHang> getDonHang = new ArrayList<GetDonHang>();
		for(DonHang dh: listDonHang) {
			String diaChi = khachHangService.get(dh.getSdt()).getDiaChi();
			String email = khachHangService.get(dh.getSdt()).getEmail();
			String tenKH = khachHangService.get(dh.getSdt()).getTenKH();
			getDonHang.add(new GetDonHang(dh,diaChi,email,tenKH));
		}
		return getDonHang;
	}
	
	@GetMapping("/donhang/{id}")
	public ResponseEntity<GetDonHang> get(@PathVariable Integer id){
		try {
			DonHang dh = service.get(id);
			String diaChi = khachHangService.get(dh.getSdt()).getDiaChi();
			String email = khachHangService.get(dh.getSdt()).getEmail();
			String tenKH = khachHangService.get(dh.getSdt()).getTenKH();
			// status 200
			return new ResponseEntity<GetDonHang>(new GetDonHang(dh,diaChi,email,tenKH),HttpStatus.OK);
		} catch(NoSuchElementException e) {
			// status 404
			return new ResponseEntity<GetDonHang>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("donhang/sdt-{sdt}")
	public List<DonHang> list(@PathVariable String sdt){
		return service.list(sdt);
	}
	
	@PostMapping("/donhang")
	public void add(@RequestBody DonHang donhang) {
		service.save(donhang);
	}
	
	@PutMapping("/donhang/{id}")
	public ResponseEntity<?> update(@RequestBody DonHang donhang,@PathVariable Integer id) {
		try {
			DonHang exDonHang = service.get(id);
			service.save(donhang);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}