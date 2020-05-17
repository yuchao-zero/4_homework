package club.banyuan;

public enum Production {
    JUICE("Juice",10," ",5,'A'),
    COLA("Cola",6," ",1,'B'),
    TEA("Tea",5," ",2,'C'),
    WATER("Water",8," ",1,'D'),
    COFFEE("Coffee",7," ",9,'E');
    public String name;
    private final int price;
    public String canBePurchased;
    public int left;
    private final char letter;

    Production(String name,int price,String canBePurchased,int left,char letter){
        this.name = name;
        this.price = price;
        this.canBePurchased = canBePurchased;
        this.left = left;
        this.letter = letter;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public char getLetter() {
        return letter;
    }
}
