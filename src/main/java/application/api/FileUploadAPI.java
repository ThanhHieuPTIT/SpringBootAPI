package application.api;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import application.service.FileUploadHelper;

@RestController
public class FileUploadAPI {
	
	@Autowired
	private FileUploadHelper fileUploadHelper;
	
	@PostMapping("/upfile")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
		try {
			if(file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Không tìm thấy file lưu trữ");
			}
			
			if(!file.getContentType().equals("image/jpeg") && !file.getContentType().equals("image/png")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Không đúng định dạng file");
			}
			
			int f = fileUploadHelper.uploadFile(file);
			if(f==1) {
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
			}
			if(f==2) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File đã tồn tại.Đổi tên file để thêm mới..."); 
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Thất bại ! Thử lại"); 
	}
}
