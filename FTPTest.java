import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;

public class FTPTest {
	// IP address and port of FTP server
	String IP = "XXX,XXX,XXX,XXX";
	int port = 21;
	// user account and password of FTP server
	String account = "TEST";
	String password = "TEST";
	FTPClient ftp = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FTPTest().upload();
	}
	
	public void download(){
		
		try{
			ftp = new FTPClient();
			ftp.connect(IP,port);
			ftp.login(account,password);
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			// the downloaded file will be saved to [D:/ftp folder] and named [interns.xml] 指定檔案要存的路徑及檔名
			File file = new  File("D:/ftp/interns.xml");
			FileOutputStream fos = new FileOutputStream(file);
			
			// [FTP server]change the directory from root directory 工作目錄可以從FTP上根目錄換到子目錄
			//ftp.changeWorkingDirectory("ga");
			
			// the filename you want to download on FTP server FTP上工作目錄裡欲下載檔案的檔名
			if(ftp.retrieveFile("interns.xml", fos)){
				System.out.println("Success");
			}else{
				System.out.println("Fail");
			}
		}catch(Exception e){
			System.out.println("Fail");
			e.printStackTrace();
		}finally{
			try {
				ftp.disconnect();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void upload(){
		
		try{
			ftp = new FTPClient();
			ftp.connect(IP,port);
			ftp.login(account,password);
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			// the path and filename of the file you want to upload 本機上欲上傳檔案的路徑及檔名
			File file = new File("D:/ftp/staff.xml");
			FileInputStream fis = new FileInputStream(file);
			
			// [FTP server]change the directory from root directory 工作目錄可以從FTP上根目錄換到子目錄
			//ftp.changeWorkingDirectory("ga");
			
			// specify the filename of the uploaded file on FTP server檔案上傳後在FTP上要存的檔名
			if(ftp.storeFile("staff.xml", fis)){
				System.out.println("Success");
			}else{
				System.out.println("Fail");
			}
		}catch(Exception e){
			System.out.println("Fail");
			e.printStackTrace();
		}finally{
			try {
				ftp.disconnect();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
