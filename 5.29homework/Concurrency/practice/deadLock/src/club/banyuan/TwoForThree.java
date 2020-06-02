package club.banyuan;

public class TwoForThree implements Runnable {

  @Override
  public void run() {
    synchronized (TestThread.lock2) {
      System.out.println("Two For Three lock2");

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      synchronized (TestThread.lock3) {
        System.out.println("Two For Three lock3");
      }
    }
  }
}
