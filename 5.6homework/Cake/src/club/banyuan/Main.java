package club.banyuan;

public class Main {
    public static void main(String[] args) {
        //1.声明一个由10个Cake对象组成的数组
        Cake[] cakes = new Cake[10];
        //2.输入Cake对象的数据并将其存储到数组中
        //n是编号，r是价格，quantity是数量，前五个按照数量卖
        cakes[0] = new ReadyMadeCake(1,5,5);//子类的每个对象都是父类的对象
        cakes[1] = new ReadyMadeCake(2,6,5);
        cakes[2] = new ReadyMadeCake(3,7,5);
        cakes[3] = new ReadyMadeCake(4,4,5);
        cakes[4] = new ReadyMadeCake(5,8,5);
        //后5个按照重量卖
        cakes[5] = new OrderCake(6,5,1.2);
        cakes[6] = new OrderCake(7,5,2.1);
        cakes[7] = new OrderCake(8,5,3.4);
        cakes[8] = new OrderCake(9,5,4.2);
        cakes[9] = new OrderCake(10,5,5.3);
        //显示所有蛋糕的总价
        double totalPrices = 0;
        for(int i = 0;i < cakes.length;i++){
            totalPrices += cakes[i].calcPrice();
        }
        System.out.println("蛋糕的总价为"+totalPrices);
        //显示ReadyMadeCake蛋糕的总价和数量之和
        double readyMadeCakeTotalPrices = 0;
        int readyMadeCakeNums = 0;
        for(int i = 0;i < 5;i++){
            readyMadeCakeTotalPrices += cakes[i].calcPrice();
            readyMadeCakeNums += ((ReadyMadeCake)cakes[i]).getQuantity();
        }
        System.out.println("ReadyMadeCake蛋糕总价为"+readyMadeCakeTotalPrices);
        System.out.println("ReadyMadeCake蛋糕数量和为"+readyMadeCakeNums);
        //显示最高价格出售的蛋糕的信息
        Cake temp = cakes[0];
        for(int i = 0;i < cakes.length - 1;i++){
            if(cakes[i].price >cakes[i+1].price){
                temp.price = cakes[i].price;
                temp.id = cakes[i].id;
            }
        }
        System.out.println("最高价格出售的蛋糕价格为"+temp.price);
        System.out.println("最高价格出售的蛋糕编号为"+temp.id);
    }
}
