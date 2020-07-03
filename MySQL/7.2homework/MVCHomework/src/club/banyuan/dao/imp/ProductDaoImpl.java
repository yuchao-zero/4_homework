package club.banyuan.dao.imp;

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

  @Override
  public List<Product> getProductByName(String proName) throws Exception {
    List<Product> productList=new ArrayList<Product>();
    String searchSql = "select * from product where name like ? or description like ?";
    ResultSet resultSet = null;
    try {
      resultSet = executeQuery(searchSql,new String[]{"%"+proName+"%","%"+proName+"%"});
      while (resultSet.next()){
        Product product = tableToClass(resultSet);
        productList.add(product);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      closeResource(resultSet);
      closeResource();
    }

    return productList;
  }

  @Override
  public Product tableToClass(ResultSet rs) throws Exception {
    Product product = new Product();
    product.setId(rs.getInt("id"));
    product.setName(rs.getString("name"));
    product.setDescription(rs.getString("description"));
    product.setPrice(rs.getDouble("price"));
    product.setStock(rs.getInt("stock"));
    product.setQuantity(1);
    return product;
  }
}