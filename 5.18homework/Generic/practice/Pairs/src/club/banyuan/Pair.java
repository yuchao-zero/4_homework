package club.banyuan;

public class Pair<T> {

  private T first;
  private T second;

  public Pair(T firstElement, T secondElement) {
    first = firstElement;
    second = secondElement;
  }

  public T getFirst() {
    return first;
  }

  public T getSecond() {
    return second;
  }

  /**
   * 向Pair类添加方法swap，该方法交换第一个和第二个元素的内容
   */
  public void swapMethod(T firstElement, T secondElement){
    T temp;
    temp = firstElement;
    firstElement = secondElement;
    secondElement = temp;
  }
}