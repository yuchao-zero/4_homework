package club.banyuan;

public class ReadyMadeCake extends Cake{
    private int quantity;

    public ReadyMadeCake(int n, double r ,int quantity) {//已在构造方法中set，不需要再设置set方法
        super(n, r);
        this.quantity = quantity;
    }

    @Override
    public double calcPrice() {
        return price * quantity;
    }


    public int getQuantity() {
        return quantity;
    }
}
