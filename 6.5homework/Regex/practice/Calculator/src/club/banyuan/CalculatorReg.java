package club.banyuan;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorReg {

  /**
   * 使用正则表达式编写一个计算器，它接受命令形式:num <oper> num num表示一个正的小数, <oper> 表示操作符，可以是（+、-、*、/、%）之一
   */


  public static void main(String[] args) {
    Pattern pattern = Pattern.compile("(\\d+(\\.\\d+)?)\\s*[+\\-*/%]\\s*(\\d+(\\.\\d+)?)");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    while (!input.equals("quit")) {
      String put = scanner.nextLine();
      Matcher matcher = pattern.matcher(put);
      if (matcher.find()) {
        String operation = scanner.nextLine();
        switch (operation) {
          case "+":
            System.out
                .println(
                    Double.parseDouble(matcher.group(1)) + Double.parseDouble(matcher.group(3)));
            break;
          case "-":
            System.out
                .println(
                    Double.parseDouble(matcher.group(1)) - Double.parseDouble(matcher.group(3)));
            break;
          case "*":
            System.out
                .println(
                    Double.parseDouble(matcher.group(1)) * Double.parseDouble(matcher.group(3)));
            break;
          case "/":
            System.out
                .println(
                    Double.parseDouble(matcher.group(1)) / Double.parseDouble(matcher.group(3)));
            break;
          case "%":
            System.out
                .println(
                    Double.parseDouble(matcher.group(1)) % Double.parseDouble(matcher.group(3)));
            break;
          default:
            System.out.println("输入不合法，请重新输入");
            break;
        }
      } else {
        System.out.println("输入不合法，请重新输入");
      }
    }
  }
}
