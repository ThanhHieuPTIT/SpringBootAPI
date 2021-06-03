import java.io.IOException;

import org.springframework.core.io.ClassPathResource;

public class test {
	public static void main(String[] args) throws IOException {
		String cha = "E:\\Project\\Eclipse\\SpringBoot\\target\\classes\\static\\image";
		String con = "\\target";
		System.out.println(cha);
		System.out.println(cha.indexOf(con));
		System.out.println(cha.substring(0,cha.indexOf(con)));
		System.out.println(cha.substring(cha.indexOf(con)+7));
		
		String cha2=new ClassPathResource("").getFile().getAbsolutePath();
		System.out.println(cha.substring(0,cha.indexOf(con)));
		System.out.println(cha2);
	}
}
