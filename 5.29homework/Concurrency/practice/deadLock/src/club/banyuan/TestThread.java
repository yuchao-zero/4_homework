package club.banyuan;

public class TestThread {

  public static final Object lock1 = new Object();
  public static final Object lock2 = new Object();
  public static final Object lock3 = new Object();
  public static final Object lock4 = new Object();
  public static final Object lock5 = new Object();

  public static void main(String[] args) {
    Thread thread1 = new Thread(new OneForTwo());
    Thread thread2 = new Thread(new TwoForThree());
    Thread thread3 = new Thread(new ThreeForFour());
    Thread thread4 = new Thread(new FourForFive());
    Thread thread5 = new Thread(new FiveForOne());
    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();
    thread5.start();
    System.out.println("启动线程结束...");
    System.out.println(thread1.getState());
    System.out.println(thread2.getState());
    System.out.println(thread3.getState());
    System.out.println(thread4.getState());
    System.out.println(thread5.getState());
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(thread1.getState());
    System.out.println(thread2.getState());
    System.out.println(thread3.getState());
    System.out.println(thread4.getState());
    System.out.println(thread5.getState());
  }

}
