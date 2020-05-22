package club.banyuan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * 监视不同种类动物的数量。由观察者记录目击事件。
 */
public class AnimalMonitorImpl implements AnimalMonitor {

  // 记录所有发现的动物。
  private List<Sighting> sightings;

  /**
   * 创建一个AnimalMonitor。
   */
  public AnimalMonitorImpl() {
    this.sightings = new SightingFiller().getSightings();
  }

  /**
   * 打印所有目击动物的详细信息。
   */
  @Override
  public void printList() {
//    for (Sighting sighting : this.sightings) {
//      System.out.println(sighting.getDetails());
//    }
    sightings.forEach(this::printList);

  }

  private void printList(Sighting sighting) {
    System.out.println(sighting.getDetails());
  }

  /**
   * 打印给定动物的所有目击细节。
   *
   * @param animal 动物的类型。
   */
  @Override
  public void printSightingsOf(String animal) {
//    for (Sighting sighting : this.sightings) {
//      if (sighting.getAnimal().equals(animal)) {
//        System.out.println(sighting.getDetails());
//      }
//    }
    sightings.stream()
        .filter(sighting -> sighting.getAnimal().equals(animal))
        .forEach(this::printList);
  }

  /**
   * 打印给定观察者的所有目击动物。
   *
   * @param spotter 观察者的ID。
   */
  @Override
  public void printSightingsBy(int spotter) {
//    Set<String> noDuplicatesAnimal = new HashSet<>();
//    for (Sighting sighting : this.sightings) {
//      if (sighting.getSpotter() == spotter) {
//        noDuplicatesAnimal.add(sighting.getAnimal());
//      }
//    }
//    System.out.println("该观察者的所有目击动物为：" + noDuplicatesAnimal);
    sightings.stream().filter(sighting -> sighting.getSpotter() == spotter)
        //返回一个新流，数据类型为右侧的元素数据类型
        .map(Sighting::getAnimal)
        .distinct()
        .forEach(this::printList);
  }

  private void printList(String s) {
    System.out.println(s);
  }

  /**
   * 打印一份被视为濒临灭绝的动物的清单。
   *
   * @param animalNames     动物名称列表。
   * @param dangerThreshold 小于或等于此级别的动物总数被认为濒临灭绝的
   */
  @Override
  public void printEndangered(List<String> animalNames, int dangerThreshold) {
    List<String> list = new ArrayList<>();
    for (String animalName : animalNames) {
      if (getCount(animalName) <= dangerThreshold) {
        list.add(animalName);
      }
    }
    System.out.print("濒临灭绝的动物：");
    for (String s : list) {
      System.out.print(s + " ");
    }
    System.out.println();
  }

  /**
   * 打印在特定期间periodID内记录的所有目击事件的详细信息，并将其作为参数传递给该方法
   *
   * @param period 日期ID
   * @return 指定日期的清单
   */
  @Override
  public List<Sighting> printSightingsInPeriod(int period) {
    List<Sighting> list = new ArrayList<>();
    for (Sighting sighting : this.sightings) {
      if (sighting.getPeriod() == period) {
        System.out.println(sighting.getDetails());
        list.add(sighting);
      }
    }
    return list;
  }

  /**
   * 打印并返回指定日期区间内的清单
   *
   * @param fromPeriod 日期开始
   * @param toPeriod   日期结束
   * @param animal     动物类型
   */
  @Override
  public List<Sighting> printSightingsOfInPeriod(int fromPeriod, int toPeriod, String animal) {
    List<Sighting> list = new ArrayList<>();
    for (Sighting sighting : this.sightings) {
      if (sighting.getPeriod() >= fromPeriod && sighting.getPeriod() <= toPeriod && sighting
          .getAnimal().equals(animal)) {
        list.add(sighting);
        System.out.println(sighting.getDetails());
      }
    }
    return list;
  }

  /**
   * 打印特定动物类型的总的目击数量
   *
   * @param animal 动物类型
   */
  @Override
  public List<Sighting> printCounts(String animal) {
    int count = 0;
    List<Sighting> list = new ArrayList<>();
    for (Sighting sighting : this.sightings) {
      if (sighting.getAnimal().equals(animal)) {
        list.add(sighting);
        count += sighting.getCount();
      }
    }
    System.out.println(count);
    return list;
  }

  /**
   * 返回给定动物目击次数。
   *
   * @param animal 动物的类型。
   * @return 给定动物的目击次数总数。
   */
  @Override
  public int getCount(String animal) {
    int count = 0;
    for (Sighting sighting : sightings) {
      if (sighting.getAnimal().equals(animal)) {
        count += sighting.getCount();
      }
    }
    return count;
  }

  /**
   * 从发现清单中删除计数为零的记录。
   */
  @Override
  public void removeZeroCounts() {
    for (int i = 0; i < sightings.size(); i++) {
      if (sightings.get(i).getCount() == 0) {
        sightings.remove(i);
      }
    }
  }

  /**
   * 返回特定区域内给定类型的动物的所有动物清单。
   *
   * @param animal 动物的类型。
   * @param area   区域的ID。
   * @return 目击清单。
   */
  @Override
  public List<Sighting> getSightingsInArea(String animal, int area) {
    List<Sighting> list = new ArrayList<>();
    for (Sighting sighting : sightings) {
      if (sighting.getArea() == area && sighting.getAnimal().equals(animal)) {
        list.add(sighting);
      }
    }
    return list;
  }

  /**
   * 返回给定动物的所有目击清单。
   *
   * @param animal 动物的类型。
   * @return 给定动物的所有目击物清单。
   */
  @Override
  public List<Sighting> getSightingsOf(String animal) {
    List<Sighting> list = new ArrayList<>();
    for (Sighting sighting : sightings) {
      if (sighting.getAnimal().equals(animal)) {
        list.add(sighting);
      }
    }
    return list;
  }

  /**
   * @param spotter
   * @param period
   * @return 包含该观察者在特定日期看到的动物的名称，只包括数量大于零的动物
   */
  @Override
  public List<String> getAnimalBy(int spotter, int period) {
    List<Sighting> list = new ArrayList<>();
    List<String> animalName = new ArrayList<>();
    for (int i = 0; i < sightings.size(); i++) {
      if (sightings.get(i).getCount() == 0) {
        list.add(sightings.remove(i)); //删除数量等于零的动物
      }
    }
    for (Sighting sighting : list) {
      if (sighting.getSpotter() == spotter && sighting.getPeriod() == period) {
        animalName.add(sighting.getAnimal());
      }
    }
    return animalName;
  }

  /**
   * @param animal
   * @param period
   * @return 在该特定日期看到该动物的观察者
   */
  @Override
  public List<Integer> getSpotterBy(String animal, int period) {
    List<Integer> spotter = new ArrayList<>();
    for (Sighting sighting : sightings) {
      if (sighting.getAnimal().equals(animal) && sighting.getPeriod() == period) {
        spotter.add(sighting.getSpotter());
      }
    }
    return spotter;
  }
}
