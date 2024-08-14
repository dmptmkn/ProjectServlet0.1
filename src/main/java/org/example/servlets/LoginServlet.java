package org.example.servlets;

import org.example.dto.UserDto;
import org.example.service.UserService;
import org.example.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private final UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/login.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        UserDto userDto = userService.login(login, password);
        if (userDto != null) {
            req.getSession().setAttribute("user", userDto);
            resp.sendRedirect("/profile");
        } else {
            resp.getWriter().write("<body>");
            resp.getWriter().write("<h3>Incorrect login/password!</h3>");
            resp.getWriter().write("</body>");
        }
    }
}
