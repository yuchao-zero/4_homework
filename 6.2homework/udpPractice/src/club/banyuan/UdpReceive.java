package club.banyuan;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceive {

  public static void main(String[] args) throws IOException {
    /**
     * DatagramSocket 通讯的数据管道
     */
    DatagramSocket ds = new DatagramSocket(3000);
    byte[] bytes = new byte[1024];
    while (true) {
      /**
       * DatagramPacket 封装数据
       */
      DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
      System.out.println("I'm waiting a message...");
      ds.receive(dp);
      System.out.print("I received a message : ");

      String strReceive = new String(dp.getData(), 0, dp.getLength()) +
          " from " + dp.getAddress().getHostAddress() + " : " + dp.getPort();
      System.out.println(strReceive);
      System.out.println();
    }
  }
}
