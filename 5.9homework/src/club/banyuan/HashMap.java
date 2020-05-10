package club.banyuan;

import club.banyuan.collection.ArrayList;
import club.banyuan.collection.List;
import club.banyuan.util.Iterator;

public class HashMap implements Map {

  public static final int INIT_LENGTH = 20;
  private List[] listArr = new List[INIT_LENGTH];
  private int size;

  /**
   * @return Map中的键值对数量
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * @return true Map没有保存键值对
   */
  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * @return true Map中保存的键值对中包含了传入的键
   */
  @Override
  public boolean containsKey(Object key) {
    if(key == null){
      return false;
    }
    int hashCode = key.hashCode();
    List list = listArr[hashCode % INIT_LENGTH];

    if(list != null) {
      Iterator iterator = list.iterator();
      while (iterator.hasNext()) {
        Entry entry = (Entry) iterator.next();
        if (entry.getKey().equals(key)) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * @return true Map中保存了键值对中包含了传入的值
   */
  @Override
  public boolean containsValue(Object value) {
    for (int i = 0; i < listArr.length; i++) {
      if(listArr[i] == null){
        continue;
      }
      Iterator iterator = listArr[i].iterator();
      while (iterator.hasNext()) {
        Entry entry = (Entry) iterator.next();
        if (entry.getValue().equals(value)) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * 根据传入的键查询值，如果查询不到，则返回null
   */
  @Override
  public Object get(Object key) {
    if (key == null) {
      return null;
    }
//hashCode是一种算法
    int hashCode = key.hashCode();   //用hashCode计算出数组下标
    List list = listArr[hashCode % INIT_LENGTH];//对数组长度取余，确保下标不会越界
    if (list == null) {
      return null;
    }

    Iterator iterator = list.iterator();//调用迭代器遍历数组
    while (iterator.hasNext()) {
      Entry entry = (Entry) iterator.next();
      if (entry.getKey().equals(key)) {
        return entry.getValue();
      }
    }
    return null;
  }

  /**
   * 通过key保存value
   */
  @Override
  public Object put(Object key, Object value) {
    if (key == null) {
      return null;
    }

    int hashCode = key.hashCode();
    List list = listArr[hashCode % INIT_LENGTH];
    if (list == null) {
      list = new ArrayList();
      listArr[hashCode % INIT_LENGTH] = list;
    }
    Iterator iterator = list.iterator();
    while (iterator.hasNext()) {
      Entry entry = (Entry) iterator.next();
      if (entry.getKey().equals(key)) {
        entry.setValue(value);
        return value;
      }
    }
    list.add(new Entry(key, value));
    size++;
    return value;
  }

  /**
   * 移除key和保存的值
   */
  @Override
  public Object remove(Object key) {
    //实现思路:调用containsKey(Object key)方法，判断key是否存在
    //:通过key保存下value，最后移除此键值对
    if (!containsKey(key)) {
      System.out.println("key不存在");
      return null;
    }
    int hashCode = key.hashCode();
    List list = listArr[hashCode % INIT_LENGTH];
    Iterator iterator = list.iterator();
    while (iterator.hasNext()) {
      Entry entry = (Entry) iterator.next();
      if (entry.getKey().equals(key)) {
        Object temp = entry.getValue();
        list.remove(entry);
        size--;
        return temp;
      }
    }
    return null;
  }
}
