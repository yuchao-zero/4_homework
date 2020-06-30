package club.banyuan.dao;


import java.sql.ResultSet;

/**
 * 数据库通用BaseDao接口 提供增删改的通用方法
 */
public interface IBaseDao {
    public ResultSet executeQuery(String sql,Object[] params);
    public int executeUpdate(String sql,Object[] params);
    public int executeInsert(String sql,Object[] params);
    public boolean closeResource();
    public boolean closeResource(ResultSet reSet);
    public Object tableToClass(ResultSet rs) throws Exception;
}

