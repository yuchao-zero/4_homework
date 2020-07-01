package club.banyuan.servlet;

import club.banyuan.dao.impl.UserDaoImpl;
import club.banyuan.util.JdbcUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    boolean flag = false;
    try {
      UserDaoImpl userDao = new UserDaoImpl(JdbcUtils.getConnection());
      flag = userDao
          .getLogin(request.getParameter("loginName"), request.getParameter("password"));
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    response.setCharacterEncoding("utf-8");
    PrintWriter writer = response.getWriter();
    writer.println("<html>");
    writer.println("<meta charset='utf-8'/>");
    writer.println("<body>");
    writer.println(flag ? "登陆成功" : "登陆失败，请重新登陆");
    writer.println("</body>");
    writer.println("</html>");
    writer.flush();
    writer.close();
  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }
}
