package club.banyuan;

public class Menu {
    /**
     * 主菜单
     */
    private final static String[] mainMenu = new String[]{"What would you like to do?", " 1. Read product information",
            " 2. Insert coin", " 3. Press product button", " 4. Press return button", " 9. Open service menu (code required)",
            " 0. Quit"};
    /**
     * 产品子菜单
     */
    private final static String[] productionMenu = new String[]{"(1) The displayed products are:", "A. Juice ($10)",
            "B. Cola ($6)", "C. Tea ($5)", "D. Water ($8)", "E. Coffee ($7)"};

    /**
     * 可用硬币选项的子菜单
     */
    private final static String[] usableCoinMenu = new String[]{"(2) Which coin would you like to insert?", "1. $1", "2. $2",
            "3. $5", "4. $10", "0. Go back"};

    /**
     * 可用产品选项的子菜单
     */
    private final static String[] usableProductionMenu = new String[]{"(3) Which product button would you like to press?", "1. A",
            "2. B", "3. C", "4. D", "5. E", "0. Go back"};

    /**
     * 管理员服务菜单
     */
    private final static String[] adminServiceMenu = new String[]{"(9) What would you like to do?", " 1. Inspect machine status",
            " 2. Withdraw all money", " 3. Refill product", " 4. Change product", " 0. Go back"};

    /**
     *管理员添加产品菜单
     */
    private final static String[] refill_Product_Menu = new String[]{"(9-3) Which product would you like to refill?", " 1. A",
            " 2. B"," 3. C", " 4. D"," 5. E"," 0. Go back"};

    /**
     * 管理员更改产品菜单
     */
    private final static String[] change_ProductionMenu = new String[]{"(9-4) Which product would you like to change?","1. A",
            " 2. B"," 3. C", " 4. D"," 5. E"," 0. Go back"};

    public static String[] getMainMenu() {
        return mainMenu;
    }

    public static String[] getProductionMenu() {
        return productionMenu;
    }

    public static String[] getUsableCoinMenu() {
        return usableCoinMenu;
    }

    public static String[] getUsableProductionMenu() {
        return usableProductionMenu;
    }

    public static String[] getAdminServiceMenu() {
        return adminServiceMenu;
    }

    public static String[] getRefill_Product_Menu() {
        return refill_Product_Menu;
    }

    public static String[] getChange_ProductionMenu() {
        return change_ProductionMenu;
    }
}
