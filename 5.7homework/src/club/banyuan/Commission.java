package club.banyuan;

public class Commission extends Hourly {
    private double allSales;
    private double commissionRate;

    public Commission(String eName, String eAddress, String ePhone, String socSecNumber, double rate,double commissionRate) {
        super(eName, eAddress, ePhone, socSecNumber, rate);
        this.commissionRate = commissionRate;
        allSales = 0;
    }

    public double getAllSales() {
        return allSales;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void addSales(double totalSales){
            allSales += totalSales;
    }

    @Override
    public double pay() {
        double payment = super.pay() + allSales * commissionRate;
        allSales = 0;
        return payment;
    }

    @Override
    public String toString() {
        return super.toString() + "\n总销售额:" + allSales;
    }
}
