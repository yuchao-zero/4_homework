package club.banyuan;

public class ThreeForFour implements Runnable {

  @Override
  public void run() {
    synchronized (TestThread.lock3) {
      System.out.println("Three For Four lock3");

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      synchronized (TestThread.lock4) {
        System.out.println("Three For Four lock4");
      }
    }
  }
}
