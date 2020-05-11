package club.banyuan;

public class DataSet {
  // TODO: 定义private 实例变量
  private double sum;
  private int count;
  private Object maximum;
  private Measurer measurer;

  public DataSet(Measurer aMeasurer) {
    sum = 0;
    count = 0;
    maximum = null;
    measurer = aMeasurer;
  }

  public DataSet(){

  }

  // TODO： 重载方法，使得Contry统计 DataSetTester 运行成功
  public void add(Object x) {
    sum = sum + measurer.measure(x);
    if (count == 0 || measurer.measure(maximum) < measurer.measure(x)) {
      maximum = x;
    }
    count++;
  }

  public void add(Measurable x){ //父类的引用指向子类的对象
    sum = sum + x.getMeasure(); //调用子类重写的方法
    Measurable max = (Measurable)maximum;
    if(count == 0 || x.getMeasure() > max.getMeasure() ){
      maximum = x;
    }
    count++;
  }

  public double getAverage() {
    // TODO: Check divide by zero. Compute the average value.
    return sum / count;
  }

  public Object getMaximum() {
    return maximum;
  }


}