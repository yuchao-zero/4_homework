package club.banyuan.controller;

import club.banyuan.dao.UserDao;
import club.banyuan.dao.imp.UserDaoImpl;
import club.banyuan.entity.User;
import club.banyuan.util.JdbcUtils;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegistServlet", urlPatterns = "/regist.do")
public class RegistServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    User user = new User();
    user.setLoginName(request.getParameter("loginName"));
//        user.setUserName(request.getParameter("userName"));
    user.setPassword(request.getParameter("password"));
//        user.setSex(Integer.valueOf(request.getParameter("sex")));
//        user.setEmail(request.getParameter("email"));
//        user.setMobile(request.getParameter("mobile"));
    boolean flag = false;
    try {
      UserDao userDao = new UserDaoImpl(JdbcUtils.getConnection());
      int id = userDao.add(user);
      if (id > 0) {
        response.sendRedirect("login.html");
      }
      System.out.println(id);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    response.sendRedirect("regist.html");
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }
}
