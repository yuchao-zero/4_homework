package club.banyuan;

public class Main {
    private static void printMethod(Weekday o) {
        Weekday weekday = Weekday.valueOfTypeDay(o.getTypeDay());
        if(weekday == null){
            System.out.println("不存在的对象");
            return;
        }
        if (weekday.isWeekDay()) {
            System.out.println(o + "不是假期");
        } else {
            System.out.println(o + "是假期");
        }
    }

    public static void main(String[] args) {
        //静态values（）方法，该方法返回枚举中值的数组
        for (Weekday o : Weekday.values()
        ) {
            printMethod(o);
        }
        Weekday sat = Weekday.SATURDAY;
        for (Weekday day : Weekday.values()
        ) {
            System.out.println(day.compareTo(sat));
            if (day.compareTo(sat) > 0) {
                System.out.println("大于sat");
            }
            if (day.compareTo(sat) < 0) {
                System.out.println("小于sat");
            }
            if (day.compareTo(sat) == 0) {
                System.out.println("等于sat");
            }
        }
    }
}
