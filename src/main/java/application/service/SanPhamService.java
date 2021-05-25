package application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.entity.SanPhamEntity;
import application.repository.SanPhamRepository;

@Service
public class SanPhamService {
	
	@Autowired
	private SanPhamRepository repo;
	
	public List<SanPhamEntity> listAll(){
		return repo.findAll();
	}
	
	public void save(SanPhamEntity sanPhamEntity) {
		repo.save(sanPhamEntity);
	}
	
	public SanPhamEntity get(Integer id) {
		return repo.findOne(id);
	}
	
	public void delete(Integer id) {
		repo.delete(id);
	}
}
