package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import application.entity.SanPhamEntity;

public interface SanPhamRepository extends JpaRepository<SanPhamEntity, Integer>{
	
}
