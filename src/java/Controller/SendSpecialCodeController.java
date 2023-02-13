/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.Manager;
import Model.Staff;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 *
 * @author phong
 */
@WebServlet(name = "SendSpecialCodeController", urlPatterns = "/SendSpecialCodeController")
public class SendSpecialCodeController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SendCodeController generateCode = new SendCodeController();
        ArrayList<Staff> staffs = Manager.getAllStaff();
        String subject = "New Special Code Today";
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Clock currentClock = Clock.systemDefaultZone();
        LocalDateTime currentDate = LocalDateTime.now(currentClock).withNano(0);
        PrintWriter out = response.getWriter();

        for (Staff staff : staffs) {
            LocalDateTime local = LocalDateTime.parse(staff.getLastActive(), dateFormat);
            LocalDateTime tempDateTime = LocalDateTime.from(local).withNano(0);
            long dayDistance = tempDateTime.until(currentDate, ChronoUnit.DAYS);
            if (dayDistance > 0) {
                String getDate = getData(currentDate);
                String specialCode = generateCode.generateVerifycationCode();
                String to = staff.getEmailStaff();
                String message = htmlEmail(staff.getName(), specialCode);
                Manager.updateStaffSpeicalCode(staff.getEmailStaff(), specialCode, getDate);
                SendEmailController.send(to, subject, message, "lifeofcoffie@gmail.com", "shgwxqwapkgwzqkk");
            }
        }
        out.print("SUCCESS");
    }

    private String htmlEmail(String name, String generateCode) {
        String htmlEmail = "       <div style=\"background:#f9f9f9;padding-bottom: 70px;\">\n"
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
                + "                                                                Hey " + name + ",</h2>\n"
                + "                                                            <p>\n"
                + "                                                                We send a special code for today, expired 24 hours. In case you forget your password, you can use your special code to change or reset your password.\n"
                + "                                                                Have a great day! \n"
                + "                                                            </p>\n"
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
                + "                                                                This was sent by automatically. So don't reply here.</p>\n"
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
                + "        </div>\n"
                + "    </div>";
        return htmlEmail;
    }

    private String getData(LocalDateTime local) {
        return local.getYear() + "-"
                + getMonth(local.getMonthValue()) + "-" + getMonthDay(local.getDayOfMonth()) + " "
                + local.getHour() + ":" + local.getMinute() + ":"
                + local.getSecond();
    }

    private String getMonthDay(int getDay) {
        if (getDay < 10) {
            return "0" + getDay;
        } else {
            return String.valueOf(getDay);
        }
    }

    private String getMonth(int getMonth) {
        if (getMonth < 10) {
            return "0" + getMonth;
        } else {
            return String.valueOf(getMonth);
        }
    }
}
