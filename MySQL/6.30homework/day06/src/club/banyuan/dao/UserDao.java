package club.banyuan.dao;

import club.banyuan.entity.User;

/**
 * 自定义DAO接口
 */
public interface UserDao extends IBaseDao{
    public int add(User user);
    public User getLoginUser(String loginName,String pwd);
}
