package club.banyuan;

public class OrderCake extends Cake{
    private double weightlnKG;

    public OrderCake(int n,int r,double weightlnKG){
        super(n,r);
        this.weightlnKG = weightlnKG;
    }

    @Override
    public double calcPrice() {
        return price * weightlnKG;
    }

    public double getWeightlnKG() {
        return weightlnKG;
    }
}
