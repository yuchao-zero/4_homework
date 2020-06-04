package club.banyuan;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
    服务器端
 */
public class TcpServe {

  public static void main(String[] args) throws IOException {
    //创建服务器端，端口号：3000
    ServerSocket serverSocket = new ServerSocket(3000);

    //获取客户端对象
    Socket socket = serverSocket.accept();

    //创建服务器端输出流，把从客户端获得的文件保存到服务器本地
    FileOutputStream file = new FileOutputStream("./uploadFile.txt");
    //获取网络输入字节流，获取客户端传来的数据
    InputStream inputStream = socket.getInputStream();

    int len = 0;
    byte[] bytes = new byte[1024];
    while ((len = inputStream.read(bytes)) != -1) {
      //保存从客户端收到的文件
      file.write(bytes, 0, len);
    }

    //获取网络输出字节流，向客户端发送数据
    OutputStream outputStream = socket.getOutputStream();

    //向客户端发送信息：“上传成功”
    outputStream.write("上传成功".getBytes());
    System.out.println("success");

    //关闭客户端
    socket.close();
  }
  
}

