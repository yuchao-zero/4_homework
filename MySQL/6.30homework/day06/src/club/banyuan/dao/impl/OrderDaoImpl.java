package club.banyuan.dao.impl;

import club.banyuan.dao.OrderDao;
import club.banyuan.entity.Order;
import java.sql.Connection;
import java.sql.ResultSet;

public class OrderDaoImpl extends BaseDaoImpl implements OrderDao {

  public OrderDaoImpl(Connection connection) {
    super(connection);
  }

  @Override
  public int add(Order order) {
    Integer id = 0;
    String sql = "insert into shoppingStreet.order(id,userId,cost,createTime) values(null,?,?,?)";
    Object[] parms = new Object[]{order.getUserId(), order.getCost(), order.getCreateTime()};
    try {
      id = this.executeInsert(sql, parms);
      order.setId(id);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      this.closeResource();
    }
    return id;
  }

  @Override
  public Order tableToClass(ResultSet rs) throws Exception {
    Order order = new Order();
    order.setId(rs.getInt("id"));
    order.setUserId(rs.getInt("userId"));
    order.setCost(rs.getDouble("cost"));
    order.setCreateTime(rs.getDate("createTime"));
    return order;
  }
}
