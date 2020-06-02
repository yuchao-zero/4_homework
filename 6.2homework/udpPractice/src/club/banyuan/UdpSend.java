package club.banyuan;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpSend {

  public static void main(String[] args) throws IOException {
    DatagramSocket ds = new DatagramSocket();
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.print("sent a message: ");
      String word = scanner.nextLine();
      byte[] bytes = word.getBytes();
      DatagramPacket dp = new DatagramPacket(bytes, bytes.length,
          InetAddress.getByName("127.0.0.1"),
          3000);
      ds.send(dp);
    }
  }
}
