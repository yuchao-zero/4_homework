package club.banyuan; import java.io.*;

public class Encode {

  public static final int FIRST_UPPER = 65;
  public static final int FIRST_LOWER = 97;
  public static final int NUM_CHARS = 26;
  public static final int OFFSET = 3;

  public static void main(String[] args) throws IOException {
    BufferedReader inStream = null;
    BufferedWriter outStream = null;

    String inputFilePath = args[0];
    String outputFilePath = args[1];

    System.out.println("输入文件：" + inputFilePath);
    System.out.println("输出文件：" + outputFilePath);
    // TODO
    //  完成此部分代码，调用 caesarEncode 对传入的inputFilePath文件进行加密
    //  将加密后的文本输出到 outputFilePath 文件中
    FileReader fileReader = new FileReader(inputFilePath);
    inStream = new BufferedReader(fileReader);
    FileWriter fileWriter = new FileWriter(outputFilePath);
    outStream = new BufferedWriter(fileWriter);
    char[] temp = new char[1024];
    int count;
    while ((count = inStream.read(temp)) != -1) {
      for (int i = 0; i < count; i++) {
        outStream.write(caesarEncode(temp[i]));
      }
    }
    outStream.close();
    inStream.close();

    System.out.println("加密成功！");
  }

  /**
   * 通过字母表偏移量对字母进行加密
   *
   * @param ch
   * @return
   */
  public static char caesarEncode(char ch) {

    if (Character.isUpperCase(ch)) {
      return (char) ((ch - FIRST_UPPER + OFFSET) % NUM_CHARS + FIRST_UPPER);
    } else if (Character.isLowerCase(ch)) {
      return (char) ((ch - FIRST_LOWER + OFFSET) % NUM_CHARS + FIRST_LOWER);
    } else {
      return ch;
    }
  }

}