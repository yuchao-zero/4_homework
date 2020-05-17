package club.banyuan;

public enum Coin {
    PLUNK(1),
    TWO_DOLLARS(2),
    FIVE_DOLLARS(5),
    TEN_DOLLARS(10);

    private final int value;

    Coin(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
