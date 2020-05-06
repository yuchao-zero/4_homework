package club.banyuan;

public abstract class   Cake {

  protected int id;
  protected double price;

  public Cake(int n, double r) {
    id = n;
    price = r;
  }

  public abstract double calcPrice();

  public String toString() { //返回字符串本身
    return id + "\t" + price;
  }
}