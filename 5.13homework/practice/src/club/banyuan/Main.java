package club.banyuan;

public class Main {
    private static void printMethod(Weekday o){
        if(Weekday.valueofTypeDay(o.getTypeDay()).isWeekDay()){
            System.out.println(o + "不是假期");
        }else {
            System.out.println(o + "是假期");
        }
    }
    public static void main(String[] args) {
        //静态values（）方法，该方法返回枚举中值的数组
        for (Weekday o:Weekday.values()
             ) {
            printMethod(o);
        }
        Weekday sat = Weekday.SATURDAY;
        for (Weekday day:Weekday.values()
        ) {
            System.out.println(day.compareTo(sat));
        }
    }
}
