import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.Socket;

public class UpLoadClient {
	public static void main(String[] args) throws Exception {
		BufferedReader br = null;
		String path = null;
		String fileName = null;
		String ip = null;
		while (true) {
			System.out.println("请输入文件路径：");
			br = new BufferedReader(new InputStreamReader(System.in));
			path = br.readLine();
			File file = new File(path);
			fileName = path.substring(path.lastIndexOf("//") + 1);
			if (file.isDirectory() || !file.exists())
				System.out.println("路径不正确！");
			else
				break;
		}
		System.out.println("请输入服务器地址：");
		br = new BufferedReader(new InputStreamReader(System.in));
		ip = br.readLine();
		System.out.println("确认上传：" + path + "文件吗（y/n）？");
		br = new BufferedReader(new InputStreamReader(System.in));
		String result = br.readLine();
		if ("n".equalsIgnoreCase(result)) {
			br.close();
			return;
		}
		Socket socket = new Socket(ip, 3000);
		FileInputStream fs = new FileInputStream(path);
		byte[] bytes = new byte[1024];
		BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
		while (true) {
			if (fileName.getBytes().length < 255)
				//fileName += "/u0000";
				break;
			else
				break;
		}
		bos.write(fileName.getBytes());
		bos.flush();
		int len = 0;
		while ((len = fs.read(bytes)) != -1) {
			bos.write(bytes, 0, len);
		}
		bos.close();
		fs.close();
		br.close();
		socket.close();
		System.out.println("文件上传完毕！");
	}
}