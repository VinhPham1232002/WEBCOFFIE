/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.Manager;
import Model.User;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "ChangingController", urlPatterns = "/ChangingController")
public class ChangingController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String inputChange = request.getParameter("inputChange");
        String email = request.getParameter("email").trim();
        String controller = request.getParameter("controller").trim();
        HttpSession session = request.getSession();
        String content = "False";
        String statement = "";
        User user = Manager.searchAccount(email);

        if (inputChange != null && email != null && controller != null) {
            if ("nickName".equals(controller)) {
                statement = "UPDATE CUSTOMER SET NICKNAME = ? WHERE EMAIL = ?";
                Manager.changeInformation(email, inputChange, statement);
                user = Manager.searchAccount(email);
                content = user.getNickname();
            } else if ("gender".equals(controller)) {
                statement = "UPDATE CUSTOMER SET GENDER = ? WHERE EMAIL = ?";
                Manager.changeInformation(email, inputChange, statement);
                user = Manager.searchAccount(email);
                content = user.getGender();
            } else if ("image".equals(controller)) {
                statement = "UPDATE CUSTOMER SET AVATAR = ? WHERE EMAIL = ?";
                Manager.changeInformation(email, inputChange, statement);
                user = Manager.searchAccount(email);
                content = user.getBase64Avatar();
            } else if ("address".equals(controller)) {
                statement = "UPDATE CUSTOMER SET ADDRESS = ? WHERE EMAIL = ?";
                Manager.changeInformation(email, inputChange, statement);
                user = Manager.searchAccount(email);
                content = user.getAddress();
            } else if ("email".equals(controller)) {
                String password = request.getParameter("password");
                user = Manager.searchAccount(email);
                if (user.getPassword().equals(password)) {
                    statement = "UPDATE CUSTOMER SET EMAIL = ? WHERE EMAIL = ?";
                    int status = Manager.changeEmail(email, inputChange, statement);
                    if (status > 0) {
                        user = Manager.searchAccount(inputChange);
                        content = user.getEmail();
                    }
                }
            } else if ("password".equals(controller)) {
                user = Manager.searchAccount(email);
                String currentPassword = request.getParameter("currentpassword");
                if (user.getPassword().equals(currentPassword)) {
                    statement = "UPDATE CUSTOMER SET PASSWORD = ? WHERE EMAIL = ?";
                    Manager.changeEmail(email, inputChange, statement);
                    content = "True";
                }
            }
            session.setAttribute("user", user);
        }
        response.getWriter().write(content);
    }
}
