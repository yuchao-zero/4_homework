package club.banyuan;

public class PairUtil {
    //TODO 新增一个类PairUtil实现其中一个静态泛型的方法swap，其参数为Pair对象。该方法应返回一个新的Pair对象，并交换第一和第二个元素。
    public static <T> Pair<T> swap(Pair<T> pair){
        return new Pair<>(pair.getSecond(),pair.getFirst());
    }

    /**
     * PairUtil中增加一个minmax方法，该方法接收Measurable实现类对象的数组，计算数组中的最小和最大元素，并返回包含最小和最大值的Pair对象。
     * @param arr
     * @param <T>
     * @return
     */
    public static <T extends Measurable> Pair<T> minMax(T arr[]){
        T min = arr[0];
        T max = arr[0];
        for (T a:arr) {
            if(a.getMeasure() < min.getMeasure()){
                min = a;
            }
            if(a.getMeasure() > max.getMeasure()){
                max = a;
            }
        }
        return new Pair<>(min,max);
    }
    //重复练习4的问题，但要求数组元素实现Comparable接口。
    public static <T extends Comparable<T>> Pair<T> minMax(T[] arr){
        T min = arr[0];
        T max = arr[0];
        for (T a:arr) {
            if(a.compareTo(min) < 0){
                min = a;
            }
            if(a.compareTo(max) > 0){
                max = a;
            }
        }
        return new Pair<>(min,max);
    }
}
