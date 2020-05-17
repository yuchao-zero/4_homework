package club.banyuan;

public class Print {
    public static String flag = "=";

    public static void displayVending() {
        System.out.println("*---------------------------*");
        System.out.println("|     Vending   Machine     |");
        System.out.println("*---------------------------*");
        System.out.println("|   A    B    C    D    E   |");
        System.out.println("|  $10  $ 6  $ 5  $ 8  $ 7  |");
        //TODO change information
        System.out.println("|  [" + Production.JUICE.canBePurchased + "]  [" + Production.COLA.canBePurchased + "]  ["
                + Production.TEA.canBePurchased + "]  [" + Production.WATER.canBePurchased + "]  ["
                + Production.COFFEE.canBePurchased + "]  |");//状态栏显示剩余金额是否可以购买当前产品
        System.out.println("*---------------------------*");
        //TODO change information
        System.out.printf("|                    [$:%2d] |\n",
                VendingMachine.getBalanceOfMachine());//当前售货机剩余的金额
        System.out.println("|                           |");
        System.out.println("|           [=" + flag + "=]           |");
        System.out.println("*---------------------------*");
        //System.out.println();
    }

    /**
     * 打印主菜单
     */
    public static void displayMainMenu() {
        for (String mainMenu : Menu.getMainMenu()) {
            System.out.println(mainMenu);
        }
        System.out.println();
    }

    /**
     * 打印产品菜单
     */
    public static void displayProductionMenu() {
        for (String productionMenu : Menu.getProductionMenu()) {
            System.out.println(productionMenu);
        }
        System.out.println();
    }

    /**
     * 打印可以硬币选项菜单
     */
    public static void displayUsableCoinMenu() {
        for (String usableCoinMenu : Menu.getUsableCoinMenu()) {
            System.out.println(usableCoinMenu);
        }
        System.out.println();
    }

    /**
     * 打印可用产品选项的子菜单
     */
    public static void displayUsableProductionMenu(){
        for (String usableProductionMenu : Menu.getUsableProductionMenu()) {
            System.out.println(usableProductionMenu);
        }
        System.out.println();
    }
    /**
     * 打印管理员服务菜单
     */
    public static void displayAdminServiceMenu(){
        for (String adminServiceMenu :Menu.getAdminServiceMenu()) {
            System.out.println(adminServiceMenu);
        }
        System.out.println();
    }
    /**
     * 打印管理员添加产品菜单
     */
    public static void displayRefill_Product_Menu(){
        for (String refill_Product_Menu:Menu.getRefill_Product_Menu()) {
            System.out.println(refill_Product_Menu);
        }
        System.out.println();
    }

    /**
     * 打印管理员更改产品菜单
     */
    public static void displayChange_ProductionMenu(){
        for (String change_ProductionMenu:Menu.getChange_ProductionMenu()) {
            System.out.println(change_ProductionMenu);
        }
    }
}
