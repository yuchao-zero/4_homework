package club.banyuan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class User {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("请输入用户名：");
    String name = sc.nextLine();
    System.out.println("请输入密码：");
    String password = sc.nextLine();
    validate(name, password);
  }

  public static void validate(String name, String password) {
    Connection conn = null;
    PreparedStatement preparedStatement = null;
    try {
      conn = JdbcUtils.getConnection("shoppingStreet");
      preparedStatement = conn.prepareStatement
          ("insert into user(loginname,username,password) values('aaa',?,?)");
      preparedStatement.setString(1, name);
      preparedStatement.setString(2, password);
      int i = preparedStatement.executeUpdate();
      System.out.println(i > 0 ? "用户注册成功" : "失败");
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      try {
        JdbcUtils.close(conn, preparedStatement);
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }
  }
}
