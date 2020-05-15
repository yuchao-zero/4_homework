package club.banyuan;

import static java.lang.Integer.parseInt;

/**
 * Calculator类提供了用于解析包含简单表达式的输入字符串以及计算表达式结果的功能。
 */

public class Calculator {

    public Calculator() {
    }

    /**
     * 0 个符号: IllegalInputException: "Illegal Token Length"
     * 1 个符号:
     * "quit" (不区分大小写): QuitException
     * 所有其他情况: IllegalInputException: "Illegal Argument"
     * 2 个符号:
     * "-" 和数字: 返回负数
     * "-" 和非数字: IllegalInputException: "Illegal Argument"
     * 其他字符串: IllegalInputException: "Illegal Operator"
     * 3 个符号:
     * 数字1, "+", 数字2: 返回两个数字的和
     * 数字1, "/", 0: DivideByZeroException
     * 数字1, "/", 非零数字:  返回两个数字的商
     * 非数字，其他输入，其他输入: IllegalInputException: "Illegal Argument"
     * 数字1, 其他输入, 非数字: IllegalInputException: "Illegal Argument"
     * 数字1, 非运算符, 数字2: IllegalInputException: "Illegal Operator"
     * 4 更多的运算符: IllegalInputException: "Illegal Token Length"
     * <p>
     * Note: 所有数字都是整数
     *
     * @param tokens 符号数组，包含用户输入的操作数或操作符
     * @return 计算表达式的结果
     * @throws CalculatorException 如果用户输入不合法，或者已键入“ quit”。抛出CalculatorException 的几个子类之一，以便提供有关错误原因的更多信息.
     */
    public static int compute(String[] tokens) throws CalculatorException,
            IllegalInputException, QuitException, DivideByZeroException {
        // 不同符号数量的各种情况
        switch (tokens.length) {
            case 0:
                // TODO: complete the cases
                throw new IllegalInputException("Illegal Token Length");

            case 1:
                // 只有一种情况，用户输入 quit
                // TODO: complete the cases
                if (tokens[0].equals("quit")) {
                    throw new QuitException();
                } else {
                    throw new IllegalInputException("Illegal Argument");
                }

            case 2:
                // 只有一种情况，用户输入 负数
                // TODO: complete the cases
                if (tokens[0].equals("-") && isNumeric(tokens[1])) {
                    return -parseInt(tokens[1]);
                }else if(tokens[0].equals("-") && !isNumeric(tokens[1])){
                    throw new IllegalInputException("Illegal Argument");
                }else {
                    throw new IllegalInputException("Illegal Operator");
                }

            case 3:
                // 计算表达式
                // TODO: complete the cases
                if(isNumeric(tokens[0]) && tokens[1].equals("+") && isNumeric(tokens[2])){
                    return Integer.parseInt(tokens[0]) + Integer.parseInt(tokens[2]);
                }else if(isNumeric(tokens[0]) && tokens[1].equals("/") && tokens[2].equals("0")){
                    throw new DivideByZeroException();
                }else if(isNumeric(tokens[0]) && tokens[1].equals("/") && isNumeric(tokens[2]) && Integer.parseInt(tokens[2]) !=0){
                    return Integer.parseInt(tokens[0]) / Integer.parseInt(tokens[2]);
                    //Todo  (unexpected output)need to modify
                    //it's ok
                }else if(isNumeric(tokens[0]) && isNumeric(tokens[2]) && !(tokens[1].equals("+") || tokens[1].equals("/"))){
                    throw new IllegalInputException("Illegal Operator");
                }else {
                    throw new IllegalInputException("Illegal Argument");
                }

            default:
                // 4个或等多操作符号抛出异常
                // TODO: complete the cases
                throw new IllegalInputException("Illegal Token Length");
        }

    }

    /**
     *
     * @param str
     * @return 字符串是否是数字
     */
    public static boolean isNumeric(String str) {
        for (int i = str.length(); --i >= 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 将字符串转换成整数
     * @param str
     * @return int
     */
    public static int toNum(String str){
        return parseInt(str);
    }

    /**
     * 将输入字符串解析为表达式并对其求值。
     * <p>
     * 如果输入是合法表达式，则打印结果
     * <p>
     * 否则抛出CalculatorException。根据异常类型打印消息。
     * <p>
     * 始终打印出输入内容。为此使用finally块。
     * <p>
     * 始终遵循以下规则打印两行：
     * 第一行:
     * -No Exception: "The result is: " + result
     * -QuitException: "Quitting"
     * -DivideByZeroException: "Tried to divide by zero"
     * -IllegalInputException: "Illegal input: " + illegalinputtype(given to constructor)
     * -CalculatorException: <should never happen> e.getMessage()
     * 第二行:
     * "Input was: " + input
     *
     * @param input 可能包含数学表达式的字符串
     * @return true 如果String等于"quit"; false 其他情况
     */
    public static boolean parseAndCompute(String input) {
        // 提取所有运算符号
        String[] tokens = input.split(" ");
        try {
            // TODO: complete implementation.
            System.out.println("The result is: " + compute(tokens));
        } catch (QuitException e) {
            // TODO: complete implementation.
            System.out.println("Quitting");
            System.out.println("Thanks!");
            return true;
        } catch (IllegalInputException e) {
            // TODO: complete implementation.
            System.out.println("Illegal input: " + e.getExceptionType());
        } catch (CalculatorException | DivideByZeroException e) {
            // 这捕获了剩下的CalculatorException情况：DivideByZeroException
            // TODO: complete implementation.
            System.out.println("Tried to divide by zero");
        }

        // TODO: complete implementation.

        // 未指定退出
        finally {
            System.out.print("Input was: ");
            for (String t:tokens
            ) {
                System.out.print(t + " ");
            }
            System.out.println();
        }
        return false;
    }

}
