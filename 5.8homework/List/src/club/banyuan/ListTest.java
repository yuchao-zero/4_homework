package club.banyuan;

public class ListTest {

  public static void main(String[] args) {
    List list = new LinkedList();
    list.add(12);
    list.add(15);
   // list.clear();
    list.add(30);
    printList(list);
    list.remove(2);
    //list.set(1,30);
    printList(list);

    // System.out.println(list.size() == 2);
    // System.out.println((Integer) list.get(1) == 12);
     System.out.println(list.remove(Integer.valueOf(9)));
    // System.out.println((Integer) list.remove(0) == 15);
    list.clear();
     System.out.println(list.isEmpty());
    // list.add(22);
    // list.add(33);
    // list.add(44);
    // System.out.println(list.size() == 3);
    // System.out.println((Integer) list.set(2, 55) == 44);
    // list.clear();
    // System.out.println(list.size() == 0);

  }

  public static void printList(List list) {
    for (int i = 0; i < list.size(); i++) {
      System.out.println("[" + i + "]=" + list.get(i));
    }
  }
}
