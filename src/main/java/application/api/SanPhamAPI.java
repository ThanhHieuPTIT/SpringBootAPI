package application.api;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import application.dao.LoaiAndKieu;
import application.entity.SanPham;
import application.service.SanPhamService;

@CrossOrigin
@RestController
public class SanPhamAPI {
	@Autowired
	private SanPhamService service;
	
	@GetMapping(value = {"/","/sanpham"})
	public List<SanPham> listEnable(){
		return service.listEnable();
	}
	
	@GetMapping("/sanphamdaxoa")
	public List<SanPham> listDisable(){
		return service.listDisable();
	}
	
	@GetMapping("/sanpham/{id}")
	public ResponseEntity<SanPham> get(@PathVariable Integer id) {
		try {
			SanPham sanpham = service.get(id);
			return new ResponseEntity<SanPham>(sanpham,HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<SanPham>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/sanpham/kieu-{idKieu}")
	public List<SanPham> listKieu(@PathVariable Integer idKieu){
		return service.listKieu(idKieu);
	}
	
	@GetMapping("/sanpham/loai-{idLoai}")
	public List<SanPham> listLoai(@PathVariable Integer idLoai){
		return service.listLoai(idLoai);
	}
	
	@GetMapping("/sanpham/loai-kieu")
	public List<SanPham> listLoaiandKieu(@RequestBody LoaiAndKieu id){
		return service.listLoaiAndKieu(id.getIdLoai(), id.getIdKieu());
	}
	
	@PostMapping("/sanpham")
	public void add(@RequestBody SanPham sanpham) {
		sanpham.setTrangThai(true);
		sanpham.setSoLuongTon(0);
		service.save(sanpham);
	}
	
	@PutMapping("/sanpham/{id}")
	public ResponseEntity<?> update(@RequestBody SanPham sanpham,@PathVariable Integer id) {
		try {
			SanPham exSanPhamEntity = service.get(id);			
			service.save(sanpham);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/xoasanpham/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		try {
			SanPham sanPham = service.get(id);
			if(sanPham != null) sanPham.setTrangThai(false);
			service.save(sanPham);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
} 