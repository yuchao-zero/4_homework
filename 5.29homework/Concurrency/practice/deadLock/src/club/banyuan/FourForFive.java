package club.banyuan;

public class FourForFive implements Runnable {

  @Override
  public void run() {
    synchronized (TestThread.lock4) {
      System.out.println("Four For Five lock4");

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      synchronized (TestThread.lock5) {
        System.out.println("Four For Five lock5");
      }
    }
  }
}
