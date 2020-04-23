package club.banyuan.animal;
import club.banyuan.animal.Cat;

public class Dog {

  public String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void bark() {
    System.out.println(name + ": 汪汪");
  }

  public void playWith(Cat cat) {
    System.out.printf("狗狗%s和猫咪%s一起玩\n", name, cat.name);
    cat.bark();
  }
}
