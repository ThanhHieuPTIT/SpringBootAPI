package application.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import application.dao.GetCTDonHang;
import application.entity.CTDonHang;
import application.service.CTDonHangService;
import application.service.SanPhamService;

@RestController
public class CTDonHangAPI {
	@Autowired
	private CTDonHangService service;
	
	@Autowired
	private SanPhamService sanPhamService;
	
	@GetMapping("ctdonhang/{idDH}")
	public List<GetCTDonHang> list(@PathVariable Integer idDH){
		List<CTDonHang> listCTDH = service.list(idDH);
		List<GetCTDonHang> getCTDonHang = new ArrayList<GetCTDonHang>();
		for(CTDonHang ctdh: listCTDH) {
			String tenSP = sanPhamService.get(ctdh.getIdSP()).getTenSP();
			String anhSP = sanPhamService.get(ctdh.getIdSP()).getAnhSP();
			int soLuong = ctdh.getSoLuong();
			int gia = ctdh.getSoLuong() * sanPhamService.get(ctdh.getIdSP()).getGia();
			getCTDonHang.add(new GetCTDonHang(tenSP, anhSP, soLuong, gia));
		}
		return getCTDonHang;
	}
	
	@PostMapping("ctdonhang")
	public void add(@RequestBody List<CTDonHang> list) {
		for(CTDonHang item:list) {
			service.save(item);
		}
	}
}
