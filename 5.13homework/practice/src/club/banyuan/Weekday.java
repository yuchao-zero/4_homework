package club.banyuan;

public enum Weekday {
    MONDAY("monday"),
    TUESDAY("tuesday"),
    WEDNESDAY("wednesday"),
    THURSDAY("thursday"),
    FRIDAY("friday"),
    SATURDAY("saturday"),
    SUNDAY("sunday");

    private final String typeDay;


    Weekday(String typeDay) {
        this.typeDay = typeDay;
    }

    @Override
    public String toString() {
        return this.typeDay;
    }

    public static Weekday valueOfTypeDay(String typeDay) {//返回对象实例
        Weekday[] values = values();
        for (Weekday one : values()) {
            if (one.typeDay.equals(typeDay)) {
                return one;
            }
        }
        return null;
    }

    public String getTypeDay() {
        return typeDay;
    }

    public boolean isWeekDay() {
        return !isHoliday();
    }

    public boolean isHoliday() {
        return this == SATURDAY || this == SUNDAY;
    }
}