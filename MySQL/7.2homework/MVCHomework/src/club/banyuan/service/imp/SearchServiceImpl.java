package club.banyuan.service.imp;

import club.banyuan.dao.UserDao;
import club.banyuan.dao.imp.ProductDaoImpl;
import club.banyuan.entity.Product;
import club.banyuan.entity.User;
import club.banyuan.service.SearchService;
import club.banyuan.service.UserService;
import club.banyuan.util.JdbcUtils;
import java.sql.SQLException;
import java.util.List;

public class SearchServiceImpl implements SearchService {

    @Override
    public List<Product> getProductByName(String proName) throws Exception {
        ProductDaoImpl productDao = new ProductDaoImpl(JdbcUtils.getConnection());
        return productDao.getProductByName(proName);
    }
}