package club.banyuan.service;

import club.banyuan.entity.User;
import java.sql.SQLException;

public interface UserService {
    public User login(String username, String password) throws SQLException;
}
