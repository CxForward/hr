package pc.hcy.learn.web;

import pc.hcy.learn.service.impl.UserServiceImpl;
import pc.hcy.learn.pojo.User;
import pc.hcy.learn.service.UserService;
import pc.hcy.learn.utils.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    public void userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.findUserByuserNameAndPassword(username, password);
        if (user != null) {
            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher("/manage.jsp").forward(request, response);
        } else {
            System.out.println("失败");
            request.setAttribute("error", "登录失败");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    public String userLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("user");
        response.sendRedirect("login.jsp");
        return null;
    }

    public String toAddPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/adduser.jsp").forward(request, response);
        return null;
    }

    public String userAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setSex(new Byte(request.getParameter("sex")));
        user.setBirthday(DateUtil.parseToDate(request.getParameter("birthday"), DateUtil.yyyyMMdd));
        user.setCreatetime(new Date());
        user.setContent(request.getParameter("content"));
        userService.saveUser(user);
        List userList = userService.findAllUser();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("/listuser.jsp").forward(request, response);
        return null;
    }

    public List userList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List userList = userService.findAllUser();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("/listuser.jsp").forward(request, response);
        return null;
    }

    public String toUpdatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        User user = userService.findUserById(id);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/updateuser.jsp").forward(request, response);
        return null;
    }

    public String updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setId(new Long(request.getParameter("id")));
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setSex(new Byte(request.getParameter("sex")));
        user.setBirthday(DateUtil.parseToDate(request.getParameter("birthday"), DateUtil.yyyyMMdd));
        user.setCreatetime(new Date());
        user.setContent(request.getParameter("content"));
        userService.updateUser(user);
        List userList = userService.findAllUser();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("/listuser.jsp").forward(request, response);
        return null;
    }

    public String deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        userService.delete(id);
        List userList = userService.findAllUser();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("/listuser.jsp").forward(request, response);
        return null;
    }

}
