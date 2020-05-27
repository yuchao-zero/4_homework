package club.banyuan;

import java.io.File;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

public class Command {

  public static void main(String[] args) throws IOException {
    switch (args[0]) {
      //显示当前路径下的文件夹和文件名称
      case "ls":
        File dir = new File("./");
        System.out.println(dir.getAbsolutePath());
        System.out.println(dir.getCanonicalPath());
        String[] str = dir.list();
        if (str == null) {
          System.out.println("当前目录为空");
        } else {
          for (String one : str) {
            System.out.println(one);
          }
        }
        break;
      case "rm":

    }
  }

  @Test
  public void test() throws IOException {
    main(new String[]{"ls"});
  }
}
