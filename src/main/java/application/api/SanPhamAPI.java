package application.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import application.entity.SanPhamEntity;
import application.service.SanPhamService;

@RestController
public class SanPhamAPI {
	@Autowired
	private SanPhamService service;
	
	@GetMapping("/sanpham")
	public List<SanPhamEntity> list(){
		return service.listAll();
	}
} 