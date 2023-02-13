/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author phong
 */
@WebServlet(name="VerifyCodeController", urlPatterns = "/VerifyCodeController")
public class VerifyCodeController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        String inputCode = request.getParameter("inputCode");
        String code = (String)session.getAttribute("generateCode");
        String isChecked = null;
        
        if(inputCode != null && code != null){
            if(inputCode.equals(code)){
                isChecked = "True";
                session.removeAttribute("inputCode");
            }else{
                isChecked = "False";
            }
        }else{
            isChecked = "False";
        }
        response.getWriter().print(isChecked);
    }
}
