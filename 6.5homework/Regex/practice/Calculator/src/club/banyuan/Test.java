package club.banyuan;

import java.util.Scanner;

public class Test {

  static void test(){
    System.out.println("hello");
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("请输入：");
    System.out.print("接收数字："+scanner.nextInt());
//    int a = scanner.nextInt();
//    int b = scanner.nextInt();
//    System.out.println(a + b);
    //System.out.println("接收完毕");
    //Class<Test> testClass = Test.class;
    //testClass.getMethod(test);
    System.out.println("再接收："+scanner.nextInt());
  }
}
