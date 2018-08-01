import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//使用TCP协议写一个可以上传文件的服务器和客户端。  
public class UpLoad {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(3000);
		Socket socket = ss.accept();
		new Thread(new Receive(socket)) {
		}.start();
	}
}

class Receive implements Runnable {
	private Socket socket;

	public Receive(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
			byte[] bFileName = new byte[255];
			int len = bis.read(bFileName);
			String fileName = new String(bFileName, 0, len).trim();
			byte[] bytes = new byte[1024];
			FileOutputStream fos = new FileOutputStream("d://" + fileName);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			len = 0;
			while ((len = bis.read(bytes)) != -1) {
				bos.write(bytes, 0, len);
			}
			bos.close();
			fos.close();
			bis.close();
			socket.close();
			System.out.println("收到文件！！");
		} catch (Exception e) {
			System.out.println("文件上传出错！！！");
			e.printStackTrace();
		}
	}
}