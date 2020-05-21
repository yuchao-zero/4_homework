package club.banyuan;


import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class AnimalMonitorTest {

  @Test

  public void test(){
    List<Sighting> sightings = new ArrayList<>();

    sightings.add(new Sighting(0, "山地大猩猩", 3, 1, 0));
    sightings.add(new Sighting(0, "水牛", 10, 1, 0));
    sightings.add(new Sighting(0, "大象", 0, 1, 0));
    sightings.add(new Sighting(1, "山地大猩猩", 1, 2, 0));
    sightings.add(new Sighting(2, "山地大猩猩", 3, 3, 0));
    sightings.add(new Sighting(3, "山地大猩猩", 0, 2, 0));
    sightings.add(new Sighting(3, "水牛", 2, 1, 0));
    sightings.add(new Sighting(3, "河马", 25, 1, 0));

    sightings.add(new Sighting(0, "山地大猩猩", 4, 1, 1));
    sightings.add(new Sighting(0, "水牛", 16, 1, 1));
    sightings.add(new Sighting(1, "河马", 20, 1, 1));
    sightings.add(new Sighting(3, "水牛", 0, 2, 1));
    sightings.add(new Sighting(3, "河马", 30, 2, 1));

    sightings.add(new Sighting(0, "山地大猩猩", 1, 1, 2));
    sightings.add(new Sighting(1, "山地大猩猩", 2, 2, 2));
    sightings.add(new Sighting(2, "山地大猩猩", 0, 3, 2));
    sightings.add(new Sighting(3, "河马", 30, 2, 2));
    sightings.add(new Sighting(3, "大象", 24, 2, 2));

    AnimalMonitorImpl animalMonitor = new AnimalMonitorImpl();

    animalMonitor.setSightings(sightings);

    //System.out.println(animalMonitor.getAnimalBy(1,1));
    animalMonitor.printList();
    System.out.println("-------------------------------------------");
    animalMonitor.printSightingsOf("水牛");
    System.out.println("-------------------------------------------");
    animalMonitor.printSightingsBy(0);
    System.out.println("-------------------------------------------");
    //animalMonitor.printEndangered(sightings.,3);
    animalMonitor.printCounts("水牛");
    animalMonitor.printCounts("大象");
  }
}