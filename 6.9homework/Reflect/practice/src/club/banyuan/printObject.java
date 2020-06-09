package club.banyuan;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class printObject {

  public static void main(String[] args) {
    printInfo("a");
  }

  public static void printInfo(Object o) {
    Class<?> aClass = o.getClass();
    List<String> list = new ArrayList<>();
    Method[] methods = aClass.getMethods();
    for (Method m : methods) {
      list.add(m.getName());
    }
    sort(list);
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
  }

  public static void sort(List<String> list) {
    list.sort(String::compareTo);
  }
}
