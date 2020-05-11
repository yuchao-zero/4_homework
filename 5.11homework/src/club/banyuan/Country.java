package club.banyuan;

// TODO: 实现 Measurable 接口. getMeasure() 返回国家的人口总数. 提供构造方法，让DataSetTester运行正常
public class Country implements Measurable{
    private int populationOfCountry;

    //通过构造方法，不需要再set和get方法
    public Country(int populationOfCountry) {
        this.populationOfCountry = populationOfCountry;
    }

    @Override
    public double getMeasure() {
        return populationOfCountry;
    }
}
