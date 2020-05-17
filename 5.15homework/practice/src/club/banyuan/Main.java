package club.banyuan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //程序启动时，打印自动售货机的货品展示,然后显示主菜单
        Print.displayVending();
        System.out.println();
        while (true) {
            Print.displayMainMenu();
            Scanner scan = new Scanner(System.in);
            System.out.print("Your choice:");
            int put = scan.nextInt();
            switch (put) {
                case 1:
                    System.out.println();
                    Print.displayProductionMenu();
                    break;
                case 2:
                    VendingMachine.switchOfUsableCoinMenu();
                    System.out.println("Going back!");
                    System.out.println();
                    Print.displayVending();
                    System.out.println();
                    break;
                case 3:
                    VendingMachine.switchOfUsableProductionMenu();
                    System.out.println();
                    break;
                case 4:
                    System.out.println("(4) Return button is pressed.");
                    System.out.println("$" + VendingMachine.getBalanceOfMachine() + " has been returned.");
                    VendingMachine.balanceOfMachine = 0;
                    Print.displayVending();
                    System.out.println();
                    break;
                case 9:
                    System.out.println("(9) Opening service menu. Access code is required.");
                    System.out.print("Enter access code: ");
                    if (Integer.parseInt(new Scanner(System.in).nextLine()) != VendingMachine.getAccessCode()) {
                        System.out.println("Incorrect code!");
                        System.out.println();
                        Print.displayVending();
                        System.out.println();
                        break;//密码错误 返回主界面
                    }
                    System.out.println("Correct code!");
                    VendingMachine.switchOfAdminServiceMenu();
                    break;
                case 0:
                    System.exit(0);//退出程序
                default:
                    System.out.println("Invalid choice!");
                    System.out.println();
            }
        }
    }
}
