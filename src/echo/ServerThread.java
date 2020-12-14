package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerThread extends Thread {
	// 필드
	private Socket socket;

	// 생성자
	public ServerThread(Socket socket) {

		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			BufferedReader br = new BufferedReader(isr);

			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			while (true) {
				String msg = br.readLine();

				if (msg == null) {
					break;
				}
				if(msg.equals("배고파")) {
					String bb = "커피나 드십쇼";
					bw.write(bb);
					bw.newLine();
					bw.flush();
					System.out.println(bb);
				}else {
					System.out.println(msg);
				bw.write(msg);
				bw.newLine();
				bw.flush();
				}
			}
			bw.close();
			br.close();
			System.out.println("서버종료");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
