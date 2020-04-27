import java.util.Scanner;
import java.util.Arrays;

 class FourNumber {

    public static final int POSTION_TOTAL = 4;

    private char[] value;
    //构造方法
    public FourNumber(char[] value) {
        this.value = value;
    }

    public void setValue(char[] value) {
        this.value = value;
    }

    public char[] getValue() {
        return value;
    }

    public  NumberCompareResult compare(FourNumber fourNumber) {
        NumberCompareResult numberCompareResult = new NumberCompareResult();
        // fourNumber.value;
        char [] target = fourNumber.getValue();
        for (int i = 0; i < POSTION_TOTAL; i++) {
            if (value[i] == target[i]) {
                numberCompareResult.countOnePositionRight();
            } else {
                String source = new String(value);
                if (source.contains(target[i] + "")) {
                    numberCompareResult.countOneValueRight();
                }
            }
        }


        return numberCompareResult;
    }

    public static FourNumber generateFourNumberRandom() {
        char [] digitChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        FourNumber rlt = new FourNumber(new char[POSTION_TOTAL]);

        for (int i = 0; i < POSTION_TOTAL ; i++) {
            int index = (int)(Math.random() * (digitChars.length - i));
            rlt.getValue()[i] = digitChars[index];
            digitChars[index] = digitChars[digitChars.length - i - 1];
        }

        return rlt;
    }

    public static FourNumber generateFourNumberFromUserInput() {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNext()) {
            String input = scanner.nextLine();
            if (input.length() != POSTION_TOTAL) {
                System.out.println("输入不合法，请重新输入!");
                return generateFourNumberFromUserInput();
            }
            char [] inputChars = input.toCharArray();
            for (int i = 0; i < inputChars.length; i++) {
                if (inputChars[i] < '0' || inputChars[i] > '9') {
                    System.out.println("输入不合法，请重新输入!");
                    return generateFourNumberFromUserInput();
                }
            }

            return new FourNumber(inputChars);
        }
        System.out.println("输入异常！");
        return null;
    }


}
public class GuessNum {
    public static void main(String[] args) {
        System.out.println("猜一猜4个不重复的数字，请输入4个数字：");

        FourNumber answer = FourNumber.generateFourNumberRandom();
        System.out.println(Arrays.toString(answer.getValue()));

        while (true) {
            FourNumber userInput = FourNumber.generateFourNumberFromUserInput();

            NumberCompareResult result = answer.compare(userInput);
            if (result.isSuccess()) {
                System.out.println("回答正确");
                return;
            }

            result.printResult();

            System.out.println("请输入4个数字：");
        }
    }
}
 class NumberCompareResult {
    private int positionRightCount;

    private int valueRightCount;

    public int getPositionRightCount() {
        return positionRightCount;
    }
    public void setPositionRightCount(int positionRightCount) {
        this.positionRightCount = positionRightCount;
    }
    public int getValueRightCount() {
        return valueRightCount;
    }
    public void setValueRightCount(int valueRightCount) {
        this.valueRightCount = valueRightCount;
    }

    public void countOnePositionRight() {
        positionRightCount++;
        valueRightCount++;
    }

    public void countOneValueRight() {
        valueRightCount++;
    }

    boolean isSuccess() {
        return FourNumber.POSTION_TOTAL == positionRightCount;
    }

    void printResult() {
        System.out.printf("包含了%d个正确的数字\n", valueRightCount);
        if (positionRightCount == 0) {
            System.out.println("但是这些数字位置错误");
        } else {
            System.out.printf("%d个数字的位置正确 \n", positionRightCount);

        }

    }
}
