/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.Manager;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Random;

/**
 *
 * @author ADMIN
 */
@WebServlet(name="SendCodeController", urlPatterns = "/SendCodeController")
public class SendCodeController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String to = request.getParameter("email");
        User user = Manager.searchAccount(to);
        HttpSession session = request.getSession();

        if (user != null) {
            String subject = "Your Coffie email verification";
            String code = generateVerifycationCode();
            session.setAttribute("generateCode", code);
            String message = htmlEmail(user.getNickname(), code);
            SendEmailController.send(to, subject, message, "lifeofcoffie@gmail.com",
                    "shgwxqwapkgwzqkk");
        }
    }

    public String generateVerifycationCode() {
        Random random = new Random();
        String captcha = "";
        String numberCharacters = "0123456789";

        char character = 'A';

        for (int i = 1; i < 26; i++) {
            numberCharacters += Character.toString(character).toLowerCase() + character;
            character += 1;
        }
        do {
            for (int i = 0; i < 5; i++) {
                int characterIndex = random.nextInt(numberCharacters.length());
                captcha += numberCharacters.charAt(characterIndex) + "";
            }
            if (captcha.length() == 5) {
                break;
            }
        } while (true);
        return captcha;
    }

    public String htmlEmail(String nickName, String generateCode) {
        String contentHtmlEmail = "        <div style=\"background:#f9f9f9;padding-bottom: 70px;\">\n"
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
                + "                                                                Before we change the email on your account, we just need\n"
                + "                                                                to confirm that this is you. Below is the verification\n"
                + "                                                                code for your Coffie account.\n"
                + "                                                            </p>\n"
                + "\n"
                + "                                                        </div>\n"
                + "                                                    </td>\n"
                + "                                                </tr>\n"
                + "                                                <tr>\n"
                + "                                                    <td style=\"font-size:0px;padding:20px 0;word-break:break-word\">\n"
                + "                                                        <div\n"
                + "                                                            style=\"background:#f2f3f4;background-color:#f2f3f4;margin:0px auto;max-width:504px\">\n"
                + "\n"
                + "                                                            <table align=\"center\" border=\"0\" cellpadding=\"0\"\n"
                + "                                                                cellspacing=\"0\" role=\"presentation\"\n"
                + "                                                                style=\"background:#f2f3f4;background-color:#f2f3f4;width:100%\">\n"
                + "                                                                <tbody>\n"
                + "                                                                    <tr>\n"
                + "                                                                        <td\n"
                + "                                                                            style=\"direction:ltr;font-size:0px;padding:20px 0;text-align:center\">\n"
                + "                                                                            <div\n"
                + "                                                                                style=\"font-family:Poppins,Helvetica Neue,Helvetica,Arial,Lucida Grande,sans-serif;font-size:32px;font-weight:bold;line-height:36px;text-align:center;color:#4f5660\">\n"
                + "                                                                                " + generateCode + "</div>\n"
                + "                                                                        </td>\n"
                + "                                                                    </tr>\n"
                + "                                                                </tbody>\n"
                + "                                                            </table>\n"
                + "                                                        </div>\n"
                + "                                                    </td>\n"
                + "                                                </tr>\n"
                + "                                                <tr>\n"
                + "                                                    <td align=\"left\"\n"
                + "                                                        style=\"font-size:0px;padding:0px;word-break:break-word\">\n"
                + "                                                        <div\n"
                + "                                                            style=\"font-family:Poppins,Helvetica Neue,Helvetica,Arial,Lucida Grande,sans-serif;font-size:13px;line-height:1;text-align:left;color:#000000\">\n"
                + "                                                            <p style=\"font-size:14px;line-height:20px;color: #4f5660!important;\">Don't share this code with anyone.<br>\n"
                + "                                                                If you didn't ask for this code, please ignore this\n"
                + "                                                                email.</p>\n"
                + "                                                        </div>\n"
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
                + "        </div>";
        return contentHtmlEmail;
    }
}
