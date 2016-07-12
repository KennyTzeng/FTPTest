import java.io.File;
import java.io.FileOutputStream;

import org.apache.commons.net.ftp.FTPClient;
//FTP上傳
public class FTPTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			FTPClient ftp = new FTPClient();
			//連向IP.port
			ftp.connect("XXX.XXX.XXX.XXX",21);
			//登入FTP帳號密碼
			ftp.login("TEST", "TEST");
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			File file = new  File("D:/ftp/interns.xml");
			FileOutputStream fos = new FileOutputStream(file);
			if(ftp.retrieveFile("interns.xml", fos)){
				System.out.println("Success");
			}else{
				System.out.println("Fail");
			}
		}catch(Exception e){
			System.out.println("Fail");
			e.printStackTrace();
		}
	}

}
