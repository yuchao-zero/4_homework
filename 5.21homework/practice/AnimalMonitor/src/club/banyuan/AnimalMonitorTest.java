package club.banyuan;


import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class AnimalMonitorTest {

  @Test

  public void test() {

    AnimalMonitorImpl animalMonitor = new AnimalMonitorImpl();

    List<String> animal = new ArrayList<>();
    animal.add("大象");
    animal.add("山地大猩猩");
    animal.add("水牛");
    animal.add("河马");

//    animalMonitor.printList();
//    System.out.println("-------------------------------------------");
//    animalMonitor.printSightingsOf("水牛");
//    System.out.println("-------------------------------------------");
//    animalMonitor.printSightingsBy(0);
//    System.out.println("-------------------------------------------");
    animalMonitor.printEndangered(animal, 50);
    System.out.println("-------------------------------------------");
    animalMonitor.printCounts("水牛");
    animalMonitor.printCounts("大象");
    System.out.println("-------------------------------------------");
    animalMonitor.printSightingsInPeriod(0);
    System.out.println("-------------------------------------------");
    animalMonitor.printSightingsOfInPeriod(0,2,"大象");
    System.out.println("-------------------------------------------");
    System.out.println(animalMonitor.getCount("大象"));
    System.out.println("-------------------------------------------");
    animalMonitor.removeZeroCounts();
    animalMonitor.printList();
    System.out.println("-------------------------------------------");
    //System.out.println(animalMonitor.getAnimalBy(1,1));


  }
}
