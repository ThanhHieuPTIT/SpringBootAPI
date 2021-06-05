package application.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	
//	public String cha=new ClassPathResource("").getFile().getAbsolutePath();
//	public String con = "\\target";
//	public String UPLOAD_DIR = cha.substring(0,cha.indexOf(con)) + "\\src\\main\\resources\\static\\image";
//	public FileUploadHelper() throws IOException {
//	}
//
//
//	public int uploadFile(MultipartFile multipartFile)
//	{
//		int f=0;
//		try {
////			InputStream is = multipartFile.getInputStream();
////			byte data[] = new byte[is.available()];
////			is.read(data);
////			
////			FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+"\\"+multipartFile.getOriginalFilename());
////			fos.write(data);
////			fos.flush();
////			fos.close();
//			System.out.println(cha);
//			System.out.println(UPLOAD_DIR);
//			//String UPLOAD_DIR_copy = cha.substring(0,cha.indexOf(con)) + "\\target\\classes\\static\\image";
//			if(new File(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()).exists()) {
//				f = 2;
//			} else {
//				Files.copy(multipartFile.getInputStream(),Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
//				//Files.copy(multipartFile.getInputStream(),Paths.get(UPLOAD_DIR_copy+File.separator+multipartFile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
//				f=1;
//			}
//
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return f;
//	}
}
