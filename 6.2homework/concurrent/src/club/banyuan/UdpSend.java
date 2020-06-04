package club.banyuan;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UdpSend implements Runnable {

  @Override
  public void run() {
    DatagramSocket ds = null;
    try {
      ds = new DatagramSocket();
    } catch (SocketException e) {
      e.printStackTrace();
    }
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.print("sent a message: ");
      String word = scanner.nextLine();
      byte[] bytes = word.getBytes();
      DatagramPacket dp = null;
      try {
        dp = new DatagramPacket(bytes, bytes.length,
            InetAddress.getByName("127.0.0.1"),
            3000);
      } catch (UnknownHostException e) {
        e.printStackTrace();
      }
      try {
        ds.send(dp);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
