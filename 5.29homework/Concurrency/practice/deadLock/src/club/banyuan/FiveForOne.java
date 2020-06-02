package club.banyuan;

public class FiveForOne implements Runnable {

  @Override
  public void run() {
    synchronized (TestThread.lock5) {
      System.out.println("Five For One lock5");

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      synchronized (TestThread.lock1) {
        System.out.println("Five For One lock1");
      }
    }
  }
}
