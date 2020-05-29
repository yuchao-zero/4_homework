package club.banyuan;

import java.io.File;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

public class Command {

  public void lsMethod(String[] args) {
    if (args.length == 1) {
      File dir = new File("./");
      String[] str = dir.list();
      if (str == null) {
        System.out.println("当前目录为空");
      } else {
        for (String one : str) {
          System.out.println(one);
        }
      }
    }
    if(args.length == 2 && !args[1].equals("-l")){
      String path = args[1];
      File dir = new File(path);
      String[] str = dir.list();
      if (str == null) {
        System.out.println("当前目录为空");
      } else {
        for (String one : str) {
          System.out.println(one);
        }
      }
    }
    if(args.length == 2 && args[1].equals("-l")){

    }

  }

  public static void main(String[] args) throws IOException {
    if (args.length == 0) {
      return;
    }
    if (args[0].equals("ls")) {
      //调用ls的方法
    }
    if (args[0].equals("cp")) {
      //调用cp的方法
    }
    if (args[0].equals("rm")) {
      //调用rm的方法
    }
    if (args[0].equals("cat")) {
      //调用cat的方法
    }

  }

  @Test
  public void test() throws IOException {
    main(new String[]{"ls"});
  }
}
