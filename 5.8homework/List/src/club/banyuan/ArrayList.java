package club.banyuan;

public class ArrayList implements List {
  private int capacity ;//用于扩容
  private int size ; //记录当前数组大小
  private Object[] arrayList = new Object[capacity];//数组的大小一旦确定不能更改

  @Override
  public Object set(int index, Object element) {
    if (index >= size) {
      System.out.println("下标不合法");
      return null;
    }
    Object replaceElement = arrayList[index];
    arrayList[index] = element;
    return replaceElement;
  }

  //根据下标获取元素
  @Override
  public Object get(int index) {
    if (index >= size) {
      System.out.println("下标不合法");
      return null;
    }
    return arrayList[index];
  }

  @Override
  public void clear() {
    for (int i = 0; i < size; i++) {
      arrayList[i] = null;
    }
    size = 0;
  }

  //根据下标移除数组元素
  @Override
  public Object remove(int index) {
    if (index >= size) {
      System.out.println("下标不合法");
      return null;
    }
    for (int i = index; i < capacity -1; i++) {
          arrayList[i] = arrayList[i + 1];
    }
    size--;
    return arrayList;
  }

  //移除数组元素
  @Override
  public boolean remove(Object o) {
    boolean isfind = false;
    for(int i = 0;i < arrayList.length;i++){
      if(o == arrayList[i]){
        remove(i);
        i--;
        isfind = true;
      }
    }
    return isfind;
  }

  @Override
  public boolean add(Object o) {
    arrayListDilatation();
    for(int i = 0;i < capacity;i++){
      if(arrayList[i] == null){
        arrayList[i] = o;
        size++;
      }
    }
    return true;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public int size() {
    return size;
  }

  /**
   * 数组扩容
   */
  //扩容后要重新赋值到新数组
  private void arrayListDilatation() {
    if(capacity == size){  //有bug 如果false就不执行
      capacity++;
      Object[] newArray = new Object[capacity];
      for(int i = 0;i < capacity;i++) {
        if(i < arrayList.length) {
          newArray[i] = arrayList[i];
        }
      }
      arrayList = newArray;
    }
  }
}