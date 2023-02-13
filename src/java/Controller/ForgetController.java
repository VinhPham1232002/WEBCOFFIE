/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.Manager;
import Model.User;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author phong
 */
public class ForgetController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        Manager manager = new Manager();
        String to = request.getParameter("email");
        User user = Manager.searchAccount(to);
        HttpSession session = request.getSession();

        if (user != null) {
            String subject = "Password Reset Request for Coffie";
            String message = htmlEmail(user.getNickname());
            if (session.getAttribute("process") != null && session.getAttribute("emailReSign") != null) {
                session.removeAttribute("process");
                session.removeAttribute("emailReSign");
            } else {
                session.setAttribute("process", "completed");
                session.setAttribute("emailReSign", to);
                Cookie cookieEmail = new Cookie("emailCookies", to);
                cookieEmail.setMaxAge(60 * 60 * 24);
                response.addCookie(cookieEmail);
                SendEmailController.send(to, subject, message, "lifeofcoffie@gmail.com", "shgwxqwapkgwzqkk");
            }
        } else {
            session.removeAttribute("emailReSign");
            session.setAttribute("process", "failed");
        }
        response.sendRedirect("login.jsp");
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
                + "                                                            <p>Your <span\n"
                + "                                                                    style=\"background:#fde293;color:#222;\">Coffie</span>\n"
                + "                                                                password can be\n"
                + "                                                                reset by clicking the button below. If you did not\n"
                + "                                                                request a new password, please ignore this email.</p>\n"
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
                + "                                                                        bgcolor=\"#7289DA\"><a href=\"http://localhost:8088/Coffie/reset.jsp\"\n"
                + "                                                                            style=\"text-decoration:none;line-height:100%;background:#7289da;color:white;font-family:Ubuntu,Helvetica,Arial,sans-serif;font-size:15px;font-weight:normal;text-transform:none;margin:0px\"\n"
                + "                                                                            target=\"_blank\" data-saferedirecturl=\"\">\n"
                + "                                                                            <form action=\"resetpassword\"></form>\n"
                + "                                                                            Reset Password\n"
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
                + "                                                            <p style=\"text-align:center\">Need help? <a\n"
                + "                                                                    href=\"#\"\n"
                + "                                                                    style=\"font-family:Whitney,Helvetica Neue,Helvetica,Arial,Lucida Grande,sans-serif;color:#7289da\"\n"
                + "                                                                    target=\"_blank\" data-saferedirecturl=\"\">Contact our\n"
                + "                                                                    support team</a> or\n"
                + "                                                                hit us up on Facebook <a href=\"https://www.facebook.com/RogdriguesZ/\"\n"
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
                + "            <div style=\"margin:0px auto;max-width:640px;background:transparent\"><table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"font-size:0px;width:100%;background:transparent\" align=\"center\" border=\"0\"><tbody><tr><td style=\"text-align:center;vertical-align:top;direction:ltr;font-size:0px;padding:20px 0px\"><div aria-labelledby=\"mj-column-per-100\" class=\"m_6611936027347281407mj-column-per-100\" style=\"vertical-align:top;display:inline-block;direction:ltr;font-size:13px;text-align:left;width:100%\"><table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\"><tbody><tr><td style=\"word-break:break-word;font-size:0px;padding:0px\" align=\"center\"><div style=\"color:#99aab5;font-family:Whitney,Helvetica Neue,Helvetica,Arial,Lucida Grande,sans-serif;font-size:12px;line-height:24px;text-align:center\">\n"
                + "                Sent by <span class=\"il\">Coffie</span> • <a href=\"\" style=\"color:#1eb0f4;text-decoration:none\" target=\"_blank\" data-saferedirecturl=\"\">check our blog</a> • <a href=\"https://www.facebook.com/RogdriguesZ/\" style=\"color:#1eb0f4;text-decoration:none\" target=\"_blank\" data-saferedirecturl=\"\">@lifecoffie</a>\n"
                + "              </div></td></tr><tr><td style=\"word-break:break-word;font-size:0px;padding:0px\" align=\"center\"><div style=\"color:#99aab5;font-family:Whitney,Helvetica Neue,Helvetica,Arial,Lucida Grande,sans-serif;font-size:12px;line-height:24px;text-align:center\">\n"
                + "                444 De Haro Street, Suite 200, San Francisco, CA 94107\n"
                + "              </div></td></tr></tbody></table></div></td></tr></tbody></table></div>\n"
                + "        </div>\n"
                + "    </div>";
        return contentHtmlEmail;
    }
}
