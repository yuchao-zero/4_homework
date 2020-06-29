package club.banyuan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

//商品的查询（如：按商品名称及描述查询“华为”），并将查询结果放入map集合中模拟成购物车效果
//将上述map集合中的数据生成用户aaa的订单
//查询用户aaa的订单及订单详情信息

public class Product {

  private String name = null;
  private Integer stock = null;
  private static Map<String, Integer> ProductsMap = new HashMap<>();

  public void setName(String name) {
    this.name = name;
  }

  public void setStock(Integer stock) {
    this.stock = stock;
  }

  public String getName() {
    return name;
  }

  public Integer getStock() {
    return stock;
  }

  public static void main(String[] args) {

    mapProduct();

    searchOrder();
//    userOrder();
  }

  public static void userOrder() {
    Connection connectionOrder = null;
    PreparedStatement preparedStatementOrder = null;
    ResultSet resultSetOrder = null;

    try {
      connectionOrder = JdbcUtils.getConnection("shoppingStreet");
      String sqlOrder = "insert into shoppingStreet.order(id,userId,loginName) "
          + "values(null,(select id from user where loginName = 'aaa'),'aaa') ";
      preparedStatementOrder = connectionOrder.prepareStatement(sqlOrder);
      int i = preparedStatementOrder.executeUpdate();
      System.out.println(i > 0 ? "订单生成成功" : "失败");
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      try {
        JdbcUtils.close(connectionOrder, preparedStatementOrder, resultSetOrder);
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }
  }

  public static void mapProduct() {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      connection = JdbcUtils.getConnection("shoppingStreet");
      String sql = "select name,stock from product where name like '%华为%'";
      String sqlOrder = "select name,stock from product where name like '%华为%'";
      preparedStatement = connection.prepareStatement(sql);
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        Product product = new Product();
        product.setName(resultSet.getString(1));
        product.setStock(resultSet.getInt(2));
        ProductsMap.put(product.getName(), product.getStock());
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      try {
        JdbcUtils.close(connection, preparedStatement, resultSet);
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }
//    通过keySet方法拿到key的值
    for (String s : ProductsMap.keySet()
    ) {
      System.out.println("商品名称:" + s + " 数量:" + ProductsMap.get(s));
    }
  }

  public static void searchOrder() {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      connection = JdbcUtils.getConnection("shoppingStreet");
      String sql = "select * from shoppingStreet.order where loginName = 'aaa'";
      preparedStatement = connection.prepareStatement(sql);
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        System.out.println("id:" + resultSet.getInt(1) + " userId:" + resultSet.getInt(2)
            + " loginName:" + resultSet.getString(3));
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      try {
        JdbcUtils.close(connection, preparedStatement, resultSet);
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }
  }
}
