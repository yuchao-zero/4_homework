package club.banyuan.dao.impl;

import club.banyuan.dao.UserDao;
import club.banyuan.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 继承了数据库通用接口的实现类
 * 自定义接口的实现类
 */
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

  public UserDaoImpl(Connection conn) {
    super(conn);
  }

  /**
   * 新增用户信息
   * 保存用户
   * @param user
   * @return
   */
  @Override
  public int add(User user) {
    String sql = "insert into user(id,loginName,userName,password,sex,email,mobile) values(null,?,?,?,?,?,?)";
    Object[] params = new Object[]{user.getLoginName()
        , user.getUserName(), user.getPassword(), user.getSex(), user.getEmail(), user.getMobile()};
    int i = executeInsert(sql, params);
    return i;
  }

  /**
   * 根据登录用户账号和密码，查询用户
   * @param loginName
   * @param pwd
   * @return 用户
   */
  @Override
  public User getLoginUser(String loginName, String pwd) {
    String sql = "select id,loginName,userName,password,sex,email,mobile from user "
        + "where loginName = ? and pwd = ?";
    ResultSet resultSet = executeQuery(sql,new String[]{loginName,pwd});
    User user = null;
    try {
      if(resultSet.next()){
        user = tableToClass(resultSet);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }catch (Exception e){
      e.printStackTrace();
    }finally {
      closeResource();
      closeResource(resultSet);
    }
    return user;
  }

  @Override
  public User tableToClass(ResultSet rs) throws Exception {
    User user = new User();
    user.setId(rs.getInt("id"));
    user.setEmail(rs.getString("email"));
    user.setLoginName(rs.getString("loginName"));
    user.setMobile(rs.getString("mobile"));
    user.setPassword(rs.getString("password"));
    user.setSex(rs.getInt("sex"));
    user.setUserName(rs.getString("userName"));
    return user;
  }
}
