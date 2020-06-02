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
      System.out.print("I'll sent a message: ");
      String word = scanner.nextLine();
      byte[] bytes = word.getBytes();
      DatagramPacket dp = new DatagramPacket(bytes, bytes.length,
          InetAddress.getByName("127.0.0.1"),
          3000);
      ds.send(dp);
      System.out.println("sent over");

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      byte[] buf = new byte[1024];
      DatagramPacket datagramPacket = new DatagramPacket(buf, 1024);

      System.out.println("waiting a message");
      ds.receive(datagramPacket);
      System.out.print("received a message: ");

      String str = new String(datagramPacket.getData(), 0, datagramPacket.getLength()) +
          " from " + datagramPacket.getAddress().getHostAddress() + " : " + datagramPacket
          .getPort();
      System.out.println(str);
    }
  }
}
