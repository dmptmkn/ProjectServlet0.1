package org.example.servlets;

import org.example.dto.CreateUserDto;
import org.example.service.UserService;
import org.example.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    private final UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/register.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreateUserDto newUser = CreateUserDto.builder()
                .name(req.getParameter("name"))
                .lastName(req.getParameter("lastname"))
                .age(req.getParameter("age"))
                .login(req.getParameter("login"))
                .password(req.getParameter("password"))
                .build();

        userService.create(newUser);
        resp.sendRedirect("/login");
    }
}
