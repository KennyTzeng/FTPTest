import java.io.File;
import java.io.FileOutputStream;

import org.apache.commons.net.ftp.FTPClient;
//Download File
public class FTPTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			FTPClient ftp = new FTPClient();
			//connect to FTP server via IP,port
			ftp.connect("XXX.XXX.XXX.XXX",21);
			//login to FTP server by account and password
			ftp.login("TEST", "TEST");
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			//specify the file's path and filename which you want to place the file
			File file = new  File("D:/ftp/interns.xml");
			FileOutputStream fos = new FileOutputStream(file);
			//specify the filename your'e going to download at FTP server
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
