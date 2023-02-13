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
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 *
 * @author phong
 */
@WebServlet(name="VerifyController", urlPatterns = "/VerifyController")
public class VerifyController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String to = request.getParameter("emailVerify");
        User user = Manager.searchAccount(to);
        HttpSession session = request.getSession();

        if (user != null) {
            String subject = "Verify Email Address for Coffie";
            String message = htmlEmail(user.getNickname());
            if (session.getAttribute("emailVerify") != null) {
                session.removeAttribute("emailVerify");
            } else {
                session.setAttribute("emailVerify", to);
                session.setAttribute("loadingScreen", "unloading");
                Cookie cookieEmail = new Cookie("emailVerify", to);
                cookieEmail.setMaxAge(60 * 60 * 24);
                response.addCookie(cookieEmail);
                SendEmailController.send(to, subject, message, "lifeofcoffie@gmail.com",
                        "shgwxqwapkgwzqkk");
            }
        } else {
            session.removeAttribute("emailVerify");
        }

        out.print("<div class=\"table__verify\" style=\"display:block;\">\n"
                + "            <div class=\"table__verify-overlay\" onclick=\"closeVerify()\" style=\"opacity: 1;\">\n"
                + "                <div class=\"table__verify-box\" onclick=\"event.stopPropagation();\">\n"
                + "                    <div class=\"table__verify-title\">\n"
                + "                        <h2 class=\"table__verify-heading\">VERIFICATION EMAIL</h2>\n"
                + "                    </div>\n"
                + "                    <div class=\"table__verify-body\">\n"
                + "                        <span class=\"table__verify-description\">We have sent you a new verification email to <span>" + to + "</span>, please check both your inbox and spam folder</span>\n"
                + "                    </div>\n"
                + "                    <div class=\"table__verify-button\">\n"
                + "                        <div class=\"table__verify-box-button\">\n"
                + "                            <button type=\"button\" class=\"table__verify-btn\" onclick=\"closeVerify()\">Okay</button>\n"
                + "                        </div>\n"
                + "                    </div>\n"
                + "                </div>\n"
                + "            </div>\n"
                + "        </div>");
    }

    public String htmlEmail(String nickName) {
        String contentHtmlEmail = "    <div>\n"
                + "        <div style=\"background:#f9f9f9;padding-bottom: 70px;\">\n"
                + "            <div style=\"margin:0px auto;max-width:640px;background-color:transparent\">\n"
                + "                <table role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\"\n"
                + "                    style=\"font-size:0px;width:100%;background:transparent;text-align:center;border:0\">\n"
                + "                    <tbody>\n"
                + "                        <tr>\n"
                + "                            <td\n"
                + "                                style=\"text-align:center;vertical-align:top;direction: 1tr;font-size:0px;padding:40px 0;\">\n"
                + "                                <div\n"
                + "                                    style=\"vertical-align: top;display:inline-block;direction:1tr;font-size:13px;text-align:left;width:100%\">\n"
                + "                                    <table role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\"\n"
                + "                                        style=\"border:0;\">\n"
                + "                                        <tbody>\n"
                + "                                            <tr>\n"
                + "                                                <td style=\"word-break: break-word;font-size:0px;padding:0px;\"\n"
                + "                                                    align=\"center\">\n"
                + "                                                    <table role=\"presentation\" cellpaddin=\"0\" cellspacing=\"0\"\n"
                + "                                                        style=\"border-collapse:collapse;border-spacing:0px;text-align:center;\">\n"
                + "                                                        <tbody>\n"
                + "                                                            <tr>\n"
                + "                                                                <td style=\"width: 140px;\">\n"
                + "                                                                    <a href=\"index.jsp\" target=\"_blank\"\n"
                + "                                                                        data-saferedirecturl=\"\">\n"
                + "                                                                        <img src=\"https://cdn.dribbble.com/users/2898742/screenshots/5660488/media/2683281a8465f494668f5ccd4c89338b.jpg\"\n"
                + "                                                                            width=\"140px\"\n"
                + "                                                                            style=\"border-radius:50%;height:auto;line-height:100%;outline:none;text-decoration:none;\"\n"
                + "                                                                            alt=\"\">\n"
                + "                                                                    </a>\n"
                + "                                                                </td>\n"
                + "                                                            </tr>\n"
                + "                                                        </tbody>\n"
                + "                                                    </table>\n"
                + "                                                </td>\n"
                + "                                            </tr>\n"
                + "                                        </tbody>\n"
                + "                                    </table>\n"
                + "                                </div>\n"
                + "                            </td>\n"
                + "                        </tr>\n"
                + "                    </tbody>\n"
                + "                </table>\n"
                + "            </div>\n"
                + "            <div style=\"max-width:640px;margin:0 auto;border-radius:4px;overflow: hidden;\">\n"
                + "                <div style=\"margin:0 auto;max-width:640px;background-color:#ffffff\">\n"
                + "                    <table role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\"\n"
                + "                        style=\"font-size:0px;width:100%;background-color:#ffffff\" align=\"center\" border=\"0\">\n"
                + "                        <tbody>\n"
                + "                            <tr>\n"
                + "                                <td\n"
                + "                                    style=\"text-align: center;vertical-align: center;direction:1tr;font-size:0px;padding:40px 70px;\">\n"
                + "                                    <div\n"
                + "                                        style=\"vertical-align: top;display:inline-block;direction:1tr;font-size:13px;text-align:left;width:100%\">\n"
                + "                                        <table role=\"presentation\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"\n"
                + "                                            width=\"100%\">\n"
                + "                                            <tbody>\n"
                + "                                                <tr>\n"
                + "                                                    <td style=\"word-break: break-word;font-size:0px;padding:0px;\"\n"
                + "                                                        align=\"left\">\n"
                + "                                                        <div\n"
                + "                                                            style=\"color:#737f8d;font-family:Whitney,Helvetica Neue,Helvetica,Arial,Lucida Grande,sans-serif;font-size:16px;line-height:24px;text-align:left\">\n"
                + "\n"
                + "                                                            <h2\n"
                + "                                                                style=\"font-family:Whitney,Helvetica Neue,Helvetica,Arial,Lucida Grande,sans-serif;font-weight:500;font-size:20px;color:#4f545c;letter-spacing:0.27px\">\n"
                + "                                                                Hey " + nickName + ",</h2>\n"
                + "                                                            <p>\n"
                + "                                                                Thanks for registering for an account on <span\n"
                + "                                                                    style=\"background:#fde293;color:#222;\">Coffie</span>!\n"
                + "                                                                Before\n"
                + "                                                                we get started, we just need to confirm that this is\n"
                + "                                                                you. Click below to <span\n"
                + "                                                                style=\"background:#fde293;color:#222;\">verify</span> your email address:</p>\n"
                + "\n"
                + "                                                        </div>\n"
                + "                                                    </td>\n"
                + "                                                </tr>\n"
                + "                                                <tr>\n"
                + "                                                    <td style=\"word-break:break-word;font-size:0px;padding:10px 25px;padding-top:20px\"\n"
                + "                                                        align=\"center\">\n"
                + "                                                        <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\"\n"
                + "                                                            style=\"border-collapse:separate\" align=\"center\" border=\"0\">\n"
                + "                                                            <tbody>\n"
                + "                                                                <tr>\n"
                + "                                                                    <td style=\"border:none;border-radius:3px;color:white;padding:15px 19px\"\n"
                + "                                                                        align=\"center\" valign=\"middle\"\n"
                + "                                                                        bgcolor=\"#7289DA\"><a href=\"http://localhost:8088/Coffie/VerifyContinueController\"\n"
                + "                                                                            style=\"text-decoration:none;line-height:100%;background:#7289da;color:white;font-family:Ubuntu,Helvetica,Arial,sans-serif;font-size:15px;font-weight:normal;text-transform:none;margin:0px\"\n"
                + "                                                                            target=\"_blank\" data-saferedirecturl=\"\">\n"
                + "                                                                            <form action=\"verifyEmail\"></form>\n"
                + "                                                                            Verify Email\n"
                + "                                                                        </a></td>\n"
                + "                                                                </tr>\n"
                + "                                                            </tbody>\n"
                + "                                                        </table>\n"
                + "                                                    </td>\n"
                + "                                                </tr>\n"
                + "                                                <tr>\n"
                + "                                                    <td style=\"word-break:break-word;font-size:0px;padding:30px 0px\">\n"
                + "                                                        <p\n"
                + "                                                            style=\"font-size:1px;margin:0px auto;border-top:1px solid #dcddde;width:100%\">\n"
                + "                                                        </p>\n"
                + "                                                    </td>\n"
                + "                                                </tr>\n"
                + "                                                <tr>\n"
                + "                                                    <td style=\"word-break:break-word;font-size:0px;padding:0px\"\n"
                + "                                                        align=\"left\">\n"
                + "                                                        <div\n"
                + "                                                            style=\"color:#747f8d;font-family:Whitney,Helvetica Neue,Helvetica,Arial,Lucida Grande,sans-serif;font-size:13px;line-height:16px;text-align:left\">\n"
                + "                                                            <p style=\"text-align:center\">Need help? <a href=\"#\"\n"
                + "                                                                    style=\"font-family:Whitney,Helvetica Neue,Helvetica,Arial,Lucida Grande,sans-serif;color:#7289da\"\n"
                + "                                                                    target=\"_blank\" data-saferedirecturl=\"\">Contact our\n"
                + "                                                                    support team</a> or\n"
                + "                                                                hit us up on Facebook <a\n"
                + "                                                                    href=\"https://www.facebook.com/RogdriguesZ/\"\n"
                + "                                                                    style=\"font-family:Whitney,Helvetica Neue,Helvetica,Arial,Lucida Grande,sans-serif;color:#7289da\"\n"
                + "                                                                    target=\"_blank\"\n"
                + "                                                                    data-saferedirecturl=\"\">@lifecoffie</a>.<br>\n"
                + "                                                        </div>\n"
                + "                                                    </td>\n"
                + "                                                </tr>\n"
                + "                                            </tbody>\n"
                + "                                        </table>\n"
                + "                                    </div>\n"
                + "                                </td>\n"
                + "                            </tr>\n"
                + "                        </tbody>\n"
                + "                    </table>\n"
                + "                </div>\n"
                + "            </div>\n"
                + "            <div style=\"margin:0px auto;max-width:640px;background:transparent\">\n"
                + "                <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\"\n"
                + "                    style=\"font-size:0px;width:100%;background:transparent\" align=\"center\" border=\"0\">\n"
                + "                    <tbody>\n"
                + "                        <tr>\n"
                + "                            <td\n"
                + "                                style=\"text-align:center;vertical-align:top;direction:ltr;font-size:0px;padding:20px 0px\">\n"
                + "                                <div aria-labelledby=\"mj-column-per-100\" class=\"m_6611936027347281407mj-column-per-100\"\n"
                + "                                    style=\"vertical-align:top;display:inline-block;direction:ltr;font-size:13px;text-align:left;width:100%\">\n"
                + "                                    <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n"
                + "                                        <tbody>\n"
                + "                                            <tr>\n"
                + "                                                <td style=\"word-break:break-word;font-size:0px;padding:0px\"\n"
                + "                                                    align=\"center\">\n"
                + "                                                    <div\n"
                + "                                                        style=\"color:#99aab5;font-family:Whitney,Helvetica Neue,Helvetica,Arial,Lucida Grande,sans-serif;font-size:12px;line-height:24px;text-align:center\">\n"
                + "                                                        Sent by <span class=\"il\">Coffie</span> • <a href=\"\"\n"
                + "                                                            style=\"color:#1eb0f4;text-decoration:none\" target=\"_blank\"\n"
                + "                                                            data-saferedirecturl=\"\">check our blog</a> • <a\n"
                + "                                                            href=\"https://www.facebook.com/RogdriguesZ/\"\n"
                + "                                                            style=\"color:#1eb0f4;text-decoration:none\" target=\"_blank\"\n"
                + "                                                            data-saferedirecturl=\"\">@lifecoffie</a>\n"
                + "                                                    </div>\n"
                + "                                                </td>\n"
                + "                                            </tr>\n"
                + "                                            <tr>\n"
                + "                                                <td style=\"word-break:break-word;font-size:0px;padding:0px\"\n"
                + "                                                    align=\"center\">\n"
                + "                                                    <div\n"
                + "                                                        style=\"color:#99aab5;font-family:Whitney,Helvetica Neue,Helvetica,Arial,Lucida Grande,sans-serif;font-size:12px;line-height:24px;text-align:center\">\n"
                + "                                                        444 De Haro Street, Suite 200, San Francisco, CA 94107\n"
                + "                                                    </div>\n"
                + "                                                </td>\n"
                + "                                            </tr>\n"
                + "                                        </tbody>\n"
                + "                                    </table>\n"
                + "                                </div>\n"
                + "                            </td>\n"
                + "                        </tr>\n"
                + "                    </tbody>\n"
                + "                </table>\n"
                + "            </div>\n"
                + "        </div>\n"
                + "    </div>";
        return contentHtmlEmail;
    }
}
