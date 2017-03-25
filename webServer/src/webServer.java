import java.io.*;
import java.net.*;

public class webServer {

	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(9999);
		Socket sock = server.accept();
		
		FileInputStream in = new FileInputStream("D://35398//Java//workspace//webServer//login.html");
		OutputStream out = sock.getOutputStream();
		
		int len = 0;
		byte buffer[] = new byte[2048];
		while((len=in.read(buffer))>0){
			out.write(buffer,0,len);
		}
		System.out.println("ok");
		in.close();
		out.close();
		sock.close();
		server.close();
		
	}

}
