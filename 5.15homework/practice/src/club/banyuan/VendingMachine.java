package club.banyuan;

import java.util.Scanner;

public class VendingMachine {
    /**
     * 用户塞入硬币，balanceOfMachine的值为塞入硬币的总和
     * 用户买了产品，balanceOfMachine的值为塞入硬币的总和减去产品的价格
     * 用户退出硬币的时候，balanceOfMachine的值归零
     */
    public static int balanceOfMachine = 0;
    private static final int accessCode = 1110;
    private static int income = 0;

    /**
     * 为了退出嵌套switch返回主菜单，用一个方法来封装嵌套的switch，返回主菜单
     */
    public static void switchOfUsableCoinMenu() {
        while (true) {
            System.out.println();
            Print.displayUsableCoinMenu();
            System.out.print("Your choice:");
            int selectCoin = new Scanner(System.in).nextInt();
            switch (selectCoin) {
                case 1:
                    System.out.println("You have inserted $" + Coin.PLUNK.getValue() + ".");
                    VendingMachine.balanceOfMachine += Coin.PLUNK.getValue();
                    break;
                case 2:
                    System.out.println("You have inserted $" + Coin.TWO_DOLLARS.getValue() + ".");
                    VendingMachine.balanceOfMachine += Coin.TWO_DOLLARS.getValue();
                    break;
                case 3:
                    System.out.println("You have inserted $" + Coin.FIVE_DOLLARS.getValue() + ".");
                    VendingMachine.balanceOfMachine += Coin.FIVE_DOLLARS.getValue();
                    break;
                case 4:
                    System.out.println("You have inserted $" + Coin.TEN_DOLLARS.getValue() + ".");
                    VendingMachine.balanceOfMachine += Coin.TEN_DOLLARS.getValue();
                    break;
                case 0:
                    break;//退出嵌套switch
                default:
                    System.out.println("Invalid choice!");
            }
            // TODO 如果选择了选项0，程序应当返回主菜单，返回之前打印售货机信息
            //TODO 将整个嵌套的switch封装成一个方法试试
            if (selectCoin == 0) {
                return;
            }
            /**
             * 如果投入的钱足以购买某种产品，请用大写的“O”表示“开灯”
             */
            for (int i = 0; i < Production.values().length; i++) {
                if (balanceOfMachine >= Production.values()[i].getPrice()) {
                    Production.values()[i].canBePurchased = "O";
                }
                if (Production.values()[i].left == 0) {
                    Production.values()[i].canBePurchased = "X";
                }
            }
            if (balanceOfMachine > 99) {
                balanceOfMachine = 99;
            }
            System.out.println();
            Print.displayVending();
        }
    }

    public static void switchOfUsableProductionMenu() {
        while (true) {
            System.out.println();
            Print.displayUsableProductionMenu();
            System.out.print("Your choice:");
            int selectCoin = new Scanner(System.in).nextInt();
            switch (selectCoin) {
                case 1:
                    System.out.println("You have pressed button A.");
                    if (Production.JUICE.left == 0 || balanceOfMachine < Production.JUICE.getPrice()) {
                        System.out.println("invalid choice");
                        break;
                    } else {
                        Print.flag = "A";
                        balanceOfMachine -= Production.JUICE.getPrice();
                        Production.JUICE.left--;
                        income += Production.JUICE.getPrice();
                        for (int i = 0; i < Production.values().length; i++) {
                            if (balanceOfMachine < Production.values()[i].getPrice()) {
                                Production.values()[i].canBePurchased = " ";
                            }
                        }
                        if (Production.JUICE.left == 0) {
                            Production.JUICE.canBePurchased = "X";
                        }
                        System.out.println();
                        Print.displayVending();
                        Print.flag = "=";
                        return;
                    }
                case 2:
                    System.out.println("You have pressed button B.");
                    if (Production.COLA.left == 0 || balanceOfMachine < Production.COLA.getPrice()) {
                        System.out.println("invalid choice");
                        break;
                    } else {
                        Print.flag = "B";
                        balanceOfMachine -= Production.COLA.getPrice();
                        Production.COLA.left--;
                        income += Production.COLA.getPrice();
                        for (int i = 0; i < Production.values().length; i++) {
                            if (balanceOfMachine < Production.values()[i].getPrice()) {
                                Production.values()[i].canBePurchased = " ";
                            }
                        }
                        if (Production.COLA.left == 0) {
                            Production.COLA.canBePurchased = "X";
                        }
                        System.out.println();
                        Print.displayVending();
                        Print.flag = "=";
                        return;
                    }
                case 3:
                    System.out.println("You have pressed button C.");
                    if (Production.TEA.left == 0 || balanceOfMachine < Production.TEA.getPrice()) {
                        System.out.println("invalid choice");
                        break;
                    } else {
                        Print.flag = "C";
                        balanceOfMachine -= Production.TEA.getPrice();
                        Production.TEA.left--;
                        income += Production.TEA.getPrice();
                        for (int i = 0; i < Production.values().length; i++) {
                            if (balanceOfMachine < Production.values()[i].getPrice()) {
                                Production.values()[i].canBePurchased = " ";
                            }
                        }
                        if (Production.TEA.left == 0) {
                            Production.TEA.canBePurchased = "X";
                        }
                        System.out.println();
                        Print.displayVending();
                        Print.flag = "=";
                        return;
                    }
                case 4:
                    System.out.println("You have pressed button D.");
                    if (Production.WATER.left == 0 || balanceOfMachine < Production.WATER.getPrice()) {
                        System.out.println("invalid choice");
                        break;
                    } else {
                        Print.flag = "D";
                        balanceOfMachine -= Production.WATER.getPrice();
                        Production.WATER.left--;
                        income += Production.WATER.getPrice();
                        for (int i = 0; i < Production.values().length; i++) {
                            if (balanceOfMachine < Production.values()[i].getPrice()) {
                                Production.values()[i].canBePurchased = " ";
                            }
                        }
                        if (Production.WATER.left == 0) {
                            Production.WATER.canBePurchased = "X";
                        }
                        System.out.println();
                        Print.displayVending();
                        Print.flag = "=";
                        return;
                    }
                case 5:
                    System.out.println("You have pressed button E.");
                    if (Production.COFFEE.left == 0 || balanceOfMachine < Production.COFFEE.getPrice()) {
                        System.out.println("invalid choice");
                        break;
                    } else {
                        Print.flag = "E";
                        balanceOfMachine -= Production.COFFEE.getPrice();
                        Production.COFFEE.left--;
                        income += Production.COFFEE.getPrice();
                        for (int i = 0; i < Production.values().length; i++) {
                            if (balanceOfMachine < Production.values()[i].getPrice()) {
                                Production.values()[i].canBePurchased = " ";
                            }
                        }
                        if (Production.COFFEE.left == 0) {
                            Production.COFFEE.canBePurchased = "X";
                        }
                        System.out.println();
                        Print.displayVending();
                        Print.flag = "=";
                        return;
                    }
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            if (selectCoin == 0) {
                return;
            }
            System.out.println();
            Print.displayVending();
            Print.flag = "=";
        }
    }

    public static void switchOfAdminServiceMenu() {
        while (true) {
            System.out.println();
            Print.displayAdminServiceMenu();
            System.out.print("Your choice:");
            int selectCoin = new Scanner(System.in).nextInt();
            switch (selectCoin) {
                case 1:
                    System.out.println("(9-1) Machine status");
                    //TODO 计算收入
                    System.out.println("Amount of revenue: $" + income);
                    System.out.println("Amount of inserted coins: $" + balanceOfMachine);
                    for (int i = 0; i < Production.values().length; i++) {
                        if (Production.values()[i].left == 0) {
                            System.out.println(Production.values()[i].getLetter() + ". " + Production.values()[i].getName() +
                                    " (" + Production.values()[i].getPrice()
                                    + ") " + "(sold out)");
                        } else {
                            System.out.println(Production.values()[i].getLetter() + ". " + Production.values()[i].getName() +
                                    " (" + Production.values()[i].getPrice()
                                    + ") " + " (" + Production.values()[i].left + " " + "letter)");
                        }
                    }
                    break;
                case 2:
                    System.out.println("(9-2) All money is being withdrawn.");
                    System.out.println("$" + income + " is withdrawn.");
                    income = 0;
                    balanceOfMachine = 0;
                    break;
                case 3:
                    Print.displayRefill_Product_Menu();
                    switch_Of_Refill_Product_Menu();
                    break;
                case 4:
                    Print.displayChange_ProductionMenu();
                    switchOfChangeProduction();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            if (selectCoin == 0) {
                return;
            }
            System.out.println();
           // Print.displayVending();//测试阶段出现界面，尝试取消

        }
    }

    //TODO 如果在服务菜单中选择了选项3，将显示一个子菜单，供用户选择要补充库存到全部数量的产品（固定为10）。然后将再次显示服务菜单
    public static void switch_Of_Refill_Product_Menu() {
        while (true) {
            System.out.println();
            Print.displayAdminServiceMenu();
            System.out.print("Your choice:");
            int selectCoin = new Scanner(System.in).nextInt();
            switch (selectCoin) {
                case 1:
                    System.out.println("You have refilled product A to full.");
                    Production.JUICE.left = 10;
                    //Print.displayAdminServiceMenu();
                    break;
                case 2:
                    System.out.println("You have refilled product B to full.");
                    Production.COLA.left = 10;
                    //Print.displayAdminServiceMenu();
                    break;
                case 3:
                    System.out.println("You have refilled product C to full.");
                    Production.TEA.left = 10;
                    //Print.displayAdminServiceMenu();
                    break;
                case 4:
                    System.out.println("You have refilled product D to full.");
                    Production.WATER.left = 10;
                    //Print.displayAdminServiceMenu();
                    break;
                case 5:
                    System.out.println("You have refilled product E to full.");
                    Production.COFFEE.left = 10;
                    //Print.displayAdminServiceMenu();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            if (selectCoin == 0) {
                return;
            }
            System.out.println();

            //TODO change the BUG :如果增加了打印售货机界面的方法，会发现B的信息还是"X"
            //Print.displayVending();
        }
    }

    public static void switchOfChangeProduction() {
        while (true) {
            System.out.println();
            System.out.print("Your choice:");
            int selectCoin = new Scanner(System.in).nextInt();
            switch (selectCoin) {
                case 1:
                    System.out.println("You are changing product A.");
                    System.out.println("Enter new product name:" + new Scanner(System.in).next());
                    System.out.println("Enter new product price:" + new Scanner(System.in).nextInt());
                    Production.JUICE.left = 10;
                    System.out.println("The new product E has been filled to full.");
                    Print.displayAdminServiceMenu();
                    break;
                case 2:
                    System.out.println("You are changing product B.");
                    System.out.println("Enter new product name:" + new Scanner(System.in).next());
                    System.out.println("Enter new product price:" + new Scanner(System.in).nextInt());
                    Production.COLA.left = 10;
                    System.out.println("The new product E has been filled to full.");
                    Print.displayAdminServiceMenu();
                    break;
                case 3:
                    System.out.println("You are changing product C.");
                    System.out.println("Enter new product name:" + new Scanner(System.in).next());
                    System.out.println("Enter new product price:" + new Scanner(System.in).nextInt());
                    Production.TEA.left = 10;
                    System.out.println("The new product E has been filled to full.");
                    Print.displayAdminServiceMenu();
                    break;
                case 4:
                    System.out.println("You are changing product D.");
                    System.out.println("Enter new product name:" + new Scanner(System.in).next());
                    System.out.println("Enter new product price:" + new Scanner(System.in).nextInt());
                    Production.WATER.left = 10;
                    System.out.println("The new product E has been filled to full.");
                    Print.displayAdminServiceMenu();
                    break;
                case 5:
                    System.out.println("You are changing product E.");
                    System.out.println("Enter new product name:" + new Scanner(System.in).next());
                    System.out.println("Enter new product price:" + new Scanner(System.in).nextInt());
                    Production.COFFEE.left = 10;
                    System.out.println("The new product E has been filled to full.");
                    Print.displayAdminServiceMenu();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            if (selectCoin == 0) {
                return;
            }
            System.out.println();
            Print.displayVending();
        }
    }

    public static int getBalanceOfMachine() {
        return balanceOfMachine;
    }

    public static int getAccessCode() {
        return accessCode;
    }

    public static int getIncome() {
        return income;
    }
}
