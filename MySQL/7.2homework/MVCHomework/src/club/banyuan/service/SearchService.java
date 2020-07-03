package club.banyuan.service;

import club.banyuan.entity.Product;
import club.banyuan.entity.User;
import java.sql.SQLException;
import java.util.List;

public interface SearchService {
    public List<Product> getProductByName(String proName) throws Exception;
}