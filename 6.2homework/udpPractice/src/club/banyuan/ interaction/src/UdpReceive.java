import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpReceive {

  public static void main(String[] args) throws IOException {
    /**
     * DatagramSocket 通讯的数据管道
     * 服务端端口3000
     */
    DatagramSocket ds = new DatagramSocket(3000);
    byte[] bytes = new byte[1024];
    Scanner scanner = new Scanner(System.in);
    while (true) {
      /**
       * DatagramPacket 封装数据
       */
      DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
      System.out.println("I'm waiting a message...");
      ds.receive(dp);
      System.out.print("I received a message : ");

      String strReceive = new String(dp.getData(), 0, dp.getLength()) +
          " from " + dp.getAddress().getHostAddress() + " : " + dp.getPort();//客户端随机连接一个端口到服务端
      System.out.println(strReceive);

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      System.out.print("I'll sent a message: ");
      String word = scanner.nextLine();
      DatagramPacket dp1 = new DatagramPacket(word.getBytes(), word.length(),
          InetAddress.getByName("127.0.0.1"),
          dp.getPort());
      ds.send(dp1);

      System.out.println("over");
    }
  }
}
