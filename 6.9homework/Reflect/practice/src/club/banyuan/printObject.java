package club.banyuan;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class printObject {

  public static void main(String[] args) {
    printInfo("a");
  }
  public static void printInfo(Object o) {
    Class<?> aClass = o.getClass();

    Field[] fields = aClass.getDeclaredFields();
    Method[] methods = aClass.getDeclaredMethods();

    List<Method> list = new ArrayList<>(Arrays.asList(methods));
    List<Field> list1 = new ArrayList<>(Arrays.asList(fields));

    list.sort((Comparator.comparing(Method::getName)));
    list1.sort((Comparator.comparing(Field::getName)));

    for (Method method : list) {
      System.out.println(method);
    }
    System.out.println("--------------------------------");
    for (Field field : list1) {
      System.out.println(field);
    }
  }
}