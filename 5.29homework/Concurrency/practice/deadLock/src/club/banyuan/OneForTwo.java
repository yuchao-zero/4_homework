package club.banyuan;

public class OneForTwo implements Runnable {

  @Override
  public void run() {
    synchronized (TestThread.lock1) {
      System.out.println("One For Two lock1");

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      synchronized (TestThread.lock2) {
        System.out.println("One For Two lock2");
      }
    }
  }
}
