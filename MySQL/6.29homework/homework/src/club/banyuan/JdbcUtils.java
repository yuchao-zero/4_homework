package club.banyuan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {
  private static final String USER = "root";
  private static final String URL = "jdbc:mysql://localhost:3306/";
  private static final String PWD = "ych417130";
  private static final String DB = "db1";

  public static Connection getConnection(String dbName) throws SQLException {
    String url = URL + DB;
    if (dbName != null && dbName != ""){
      url = URL + dbName;
    }
    return DriverManager.getConnection(url,USER,PWD);
  }

  public static void close(Connection connection, Statement statement) throws SQLException {
    if (statement != null){
      statement.close();
    }
    if(connection != null){
      connection.close();
    }
  }

  public static void close(Connection connection,Statement statement, ResultSet resultSet)
      throws SQLException {
    if (resultSet != null){
      resultSet.close();
    }
    if (statement != null){
      statement.close();
    }
    if(connection != null){
      connection.close();
    }
  }
}

