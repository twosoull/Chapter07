package echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	 public static void main(String[] args) throws IOException {
		//서버소켓 객체생성
		 ServerSocket serverSocket = new ServerSocket();
		 
		 serverSocket.bind(new InetSocketAddress("192.168.0.2",10001));
		 
		 System.out.println("서버시작");
		 System.out.println("=======================");
		 System.out.println("[연결을 기다리고 있습니다.]");
		 while(true) {
		 //accept
		 Socket socket = serverSocket.accept();
		 System.out.println("클라이언트가 연결되었습니다.");
		 // 출장보내기.start();
		 Thread thread = new ServerThread(socket);
		 thread.start();
		 }
	}
}
