package club.banyuan;

public class MapTest {

  public static void main(String[] args) {
    Map map = new HashMap();
    map.put("abc","bcd");
    map.put("abc","bcd");
    map.put("abc",null);
    map.put("abc","123");
    System.out.println(map.size());
    System.out.println(map.get("123"));
    System.out.println(map.get("abc"));
    System.out.println(map.containsKey("abc"));
    System.out.println(map.containsKey("ab"));
    System.out.println(map.containsValue("bcd"));
    System.out.println(map.remove("abc"));
    System.out.println(map.size());
    System.out.println(map.isEmpty());

  }
}
