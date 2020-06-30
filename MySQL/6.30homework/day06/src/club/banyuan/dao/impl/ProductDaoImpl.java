package club.banyuan.dao.impl;

import club.banyuan.dao.ProductDao;
import club.banyuan.entity.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl extends BaseDaoImpl implements ProductDao {

  public ProductDaoImpl(Connection connection) {
    super(connection);
  }

  /**
   * @param proName
   * @return 产品类集合
   * @throws Exception
   */
  @Override
  public List<Product> getProductByName(String proName) throws Exception {
    List<Product> productList = new ArrayList<>();
    String sql = "select * from product where name like ? or description like ?";
    ResultSet rs = null;
    try {
      rs = executeQuery(sql, new String[]{"%" + proName + "%", "%" + proName + "%"});
      while (rs.next()) {
        Product product = tableToClass(rs);
        productList.add(product);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      closeResource(rs);
      closeResource();
    }

    return productList;
  }

  @Override
  public Product tableToClass(ResultSet rs) throws Exception {
    Product product = new Product();
    product.setId(rs.getInt(1));
    product.setName(rs.getString(2));
    product.setDescription(rs.getString(3));
    product.setPrice(rs.getDouble(4));
    product.setStock(rs.getInt(5));
    product.setQuantity(1);
    return product;
  }
}