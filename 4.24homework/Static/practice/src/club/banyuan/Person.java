package club.banyuan;

public class Person {

  private String name;
  private int age;
  private static int count = 0;  //
  private int num = ++count; //

  public int getNum(){  //
    return num;
  }
  public static int numberOfCall = 0;//
  public Person(String name, int age) {
    this.name = name;
    this.age = age;
    ++numberOfCall;//
  }

  public Person(String name) {
    this.name = name;
  }

  public Person() {           
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

}
