package com.example.controller;

import com.example.da.UserDAO;
import com.example.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class UserServlet {
    private UserDAO userDAO;
    public void init() { userDAO = new UserDAO(); }
    protected void doPost(HttpServletRequest request, HttpServletRequest response)
        throws SecurityException, IOException {
        doGet(request, response);
    }

    private void doGet(HttpServletRequest request, HttpServletRequest response) {
        throw ServletException, IOException {
            String acction = request.getServletPath();
            try {
                switch (acction){
                    case "/new":
                        showNewForm(request, response);
                        break;
                    case "/insert":
                        inserUser(request, response);
                        break;
                    case "/delete":
                        deleteUser(request, response);
                        break;
                    case "/edit":
                        showEditForm(request, response);
                        break;
                    case  "/update":
                        updateUser(request, response);
                        break;
                    default:
                        listUser(request, response);
                        break;
                }

            }catch (SQLException | ClassNotFoundException | IOException ex){
                throw new SecurityException(ex);
            }
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws  SQLException,IOException, SecurityException, ClassNotFoundException{
        List<User> listUser = userDAO.selectAllUsers();
        request.setAttribute("ListUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request,response);
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request,response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, ServletException, IOException, ClassNotFoundException{
            int id = Integer.parseInt(request.getParameter("id"));
            User existingUser = userDAO.selectUser(id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
            request.setAttribute("user", existingUser);
            dispatcher.forward(request,response);
    }

    private void inserUser(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, ClassNotFoundException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User newUser = new User(name, email, country);
        userDAO.insertUser(newUser);
        response.sendRedirect("list");
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, IOException, ClassNotFoundException{
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User book = new User(id, name, email, country);
        userDAO.updateUser(book);
        response.sendRedirect("list");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
        throws  SQLException, IOException, ClassNotFoundException{
        int id = Integer.parseInt(request.getParameter("id"));
        userDAO.deleteUser(id);
        response.sendRedirect("list");
    }
}
