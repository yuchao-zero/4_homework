package club.banyuan;

public class Main {

  public static void main(String[] args) {
    Person person = new Person();
    Person zhangsan = new Person("张三", 18);
    Person lisi = new Person("李四");
    Person wangwu = new Person("王五");
    Person zhaoliu = new Person("赵六", 20);

    //int a = person.getNum();
    //int b = zhangsan.getNum();
    //int c = lisi.getNum();
    //int d = wangwu.getNum();

    System.out.printf("一共创建了%d个对象\n",Person.count);
    System.out.printf("两个参数的构造方法被调用了%d次\n",Person.numberOfCall);

  }
}
