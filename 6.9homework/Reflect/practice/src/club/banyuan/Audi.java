package club.banyuan;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Audi extends Car implements Runnable {

  Audi(int velocity) {
    this.velocity = velocity;
  }

  @Override
  public void run() {
    String simpleName = this.getClass().getSimpleName();
    System.out.println(simpleName + " run " + velocity + "km/h");
    Method[] methods = this.getClass().getMethods();
    List<Method> methodArrayList = new ArrayList<>(Arrays.asList(methods));
    MyAnnotationProcessor processor = new MyAnnotationProcessor();
    Collections.sort(methodArrayList, (m1, m2) -> {
      return processor.getSequence(m1) - processor.getSequence(m2);
    });

    for (Method m : methodArrayList
    ) {
      System.out.println(m);
    }
  }
}

class Car {

  int velocity;
}

interface Runnable {

  public void run();
}
