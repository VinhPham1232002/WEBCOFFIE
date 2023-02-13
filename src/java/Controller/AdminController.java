/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.Manager;
import Model.Order;
import Model.Product;
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
 * @author ADMIN
 */
@WebServlet(name = "AdminController", urlPatterns = "/AdminController")
public class AdminController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String staffEmail = request.getParameter("emailStaff");
        String productName = request.getParameter("productName");
        String productID = request.getParameter("productID");
        String productType = request.getParameter("productTypeInput");
        String productPrice = request.getParameter("productPriceInput");
        String controller = request.getParameter("controller");
        Product product = Manager.searchProduct(productName);
        PrintWriter out = response.getWriter();

        Staff staff = Manager.searchStaff(staffEmail);

        if (controller.equals("showProduct")) {
            Clock currentClock = Clock.systemDefaultZone();
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            String split[] = product.getCreateTime().split("\\.");
            LocalDateTime local = LocalDateTime.parse(split[0], dateFormat);
            String getDateUpdate = "-";
            if (product.getUpdateTime() != null) {
                String splitUpdate[] = product.getUpdateTime().split("\\.");
                LocalDateTime localUpdate = LocalDateTime.parse(splitUpdate[0], dateFormat);
                String getDayUpdate = getDay(localUpdate);
                String getMonthUpdate = getMonth(localUpdate);
                getDateUpdate = getDayUpdate + "-" + getMonthUpdate + "-" + localUpdate.getYear() + " " + localUpdate.getHour() + ":" + localUpdate.getMinute() + ":" + localUpdate.getSecond();
            }
            String getDayCreater = getDay(local);
            String getMonthCreater = getMonth(local);
            String getDate = getDayCreater + "-" + getMonthCreater + "-" + local.getYear() + " " + local.getHour() + ":" + local.getMinute() + ":" + local.getSecond();

            String getType = product.getType().substring(0, 1) + product.getType().substring(1).toLowerCase();
            String collection = product.getNameProduct() + "+"
                    + getType + "+" + product.getPrice() + "+"
                    + product.getRate() + "+" + product.getCreater() + "+"
                    + getDate + "+" + product.getIdProduct() + "+"
                    + product.getUpdater() + "+" + getDateUpdate + "+"
                    + calculateOrderSuccess(Integer.parseInt(productID)) + "+"
                    + getProductAchivement(Integer.parseInt(productID));
            out.print(collection);
        } else if (controller.equals("filterProductType")) {
            String typeProduct = request.getParameter("typeProduct");
            ArrayList<Product> listProduct = Manager.getAllProducts();
            for (Product products : listProduct) {
                String type = products.getType().substring(0, 1) + products.getType().substring(1).toLowerCase();
                if (type.contains(typeProduct) || typeProduct.equalsIgnoreCase("All")) {
                    out.print("<div class=\"table__product-main-item\" onclick=\"orderSelect(this)\">\n"
                            + "     <img src=\"data:image/" + products.getImageType() + ";base64, " + products.getBase64ProductType() + "\" alt=\"\" style=\"width:150px;height:150px\">\n"
                            + "     <div class=\"table__product-main-item-box\">\n"
                            + "             <h5 class=\"table__product-main-item-title\">" + products.getNameProduct() + "</h5>\n"
                            + "             <div class=\"table__product-main-item-sub-title\">Product #" + products.getIdProduct() + "\n"
                            + "         </div>\n"
                            + "     </div>\n"
                            + "</div>");
                }
            }
        } else if (controller.equals("addProduct")) {
            String imageBinary = request.getParameter("productImage");
            String imageType = request.getParameter("imageType");
            byte[] getImageByte = product.convertFromBase64ToBinary(imageBinary);
            float priceFloat;
            if (productPrice.contains("$")) {
                productPrice = productPrice.substring(1);
            }
            try {
                priceFloat = Float.parseFloat(productPrice);
            } catch (NumberFormatException numberError) {
                out.print("Error");
                return;
            }
            Manager.addProduct(productName, priceFloat, getImageByte, imageType, productType.toUpperCase(), staff.getName());
            ArrayList<Product> listProduct = Manager.getAllProducts();
            for (Product products : listProduct) {
                out.print("<div class=\"table__product-main-item\" onclick=\"orderSelect(this)\">\n"
                        + "     <img src=\"data:image/" + products.getImageType() + ";base64, " + products.getBase64ProductType() + "\" alt=\"\" style=\"width:150px;height:150px\">\n"
                        + "     <div class=\"table__product-main-item-box\">\n"
                        + "             <h5 class=\"table__product-main-item-title\">" + products.getNameProduct() + "</h5>\n"
                        + "             <div class=\"table__product-main-item-sub-title\">Product #" + products.getIdProduct() + "\n"
                        + "         </div>\n"
                        + "     </div>\n"
                        + "</div>");
            }
        } else if (controller.equals("updateProduct")) {
            String imageBinary = request.getParameter("productImage");
            String imageType = request.getParameter("imageType");
            float priceFloat;
            if (productPrice.contains("$")) {
                productPrice = productPrice.substring(1);
            }
            try {
                priceFloat = Float.parseFloat(productPrice);
            } catch (NumberFormatException numberError) {
                out.print("Error");
                return;
            }
            byte[] getImageByte = product.convertFromBase64ToBinary(imageBinary);
            Manager.updateProduct(productName, priceFloat, getImageByte, imageType, productType.toUpperCase(), staff.getName(), product.getIdProduct());
            out.print("Done");
        } else if (controller.equals("deleteProduct")) {
            Manager.deleteProduct(productName, product.getIdProduct());
            out.print("Done");
        } else if (controller.equals("searchProduct")) {
            String inputSearch = request.getParameter("input");
            String productTypeSearch = request.getParameter("typeProduct");
            ArrayList<Product> listProduct = Manager.searchProductByName(inputSearch);

            for (Product products : listProduct) {
                if (products.getType().equalsIgnoreCase(productTypeSearch) || productTypeSearch.equalsIgnoreCase("All")) {
                    out.print("<div class=\"table__product-main-item\" onclick=\"orderSelect(this)\">\n"
                            + "     <img src=\"data:image/" + products.getImageType() + ";base64, " + products.getBase64ProductType() + "\" alt=\"\" style=\"width:150px;height:150px\">\n"
                            + "     <div class=\"table__product-main-item-box\">\n"
                            + "             <h5 class=\"table__product-main-item-title\">" + products.getNameProduct() + "</h5>\n"
                            + "             <div class=\"table__product-main-item-sub-title\">Product #" + products.getIdProduct() + "\n"
                            + "         </div>\n"
                            + "     </div>\n"
                            + "</div>");
                }
            }
        }
    }

    private String calculateOrderSuccess(int productID) {
        ArrayList<Order> orders = Manager.getAllOrdersWithProduct(productID);
        Clock currentClock = Clock.systemDefaultZone();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime currentDate = LocalDateTime.now(currentClock).withNano(0);

        float daySpend = 0.00f;
        float monthSpend = 0.00f;
        float yearSpend = 0.00f;

        for (Order order : orders) {
            if (order.getStatus().equals("COMPLETED")) {
                String[] split = order.getComplete().split("\\.");

                LocalDateTime local = LocalDateTime.parse(split[0], dateFormat);
                LocalDateTime tempDateTime = LocalDateTime.from(local).withNano(0);
                long hourDistance = tempDateTime.until(currentDate, ChronoUnit.HOURS);
                long dayDistance = tempDateTime.until(currentDate, ChronoUnit.DAYS);
                long monthDistance = tempDateTime.until(currentDate, ChronoUnit.MONTHS);
                long yearDistance = tempDateTime.until(currentDate, ChronoUnit.YEARS);

                if (dayDistance > 0 || hourDistance < 23) {
                    daySpend += order.getTotal();
                }
                if (monthDistance > 0) {
                    monthSpend += order.getTotal();
                }
                if (yearDistance > 0) {
                    yearSpend += order.getTotal();
                }
            }
        };
        float totalSpend = daySpend + monthSpend + yearSpend;
        return String.valueOf(daySpend) + "+" + String.valueOf(monthSpend) + "+" + String.valueOf(yearSpend) + "+" + String.valueOf(totalSpend);
    }

    private String getProductAchivement(int idProduct) {
        ArrayList<Integer> listNumber = Manager.getProductAchivement(idProduct);
        String process = "0";
        String cancelled = "0";
        String completed = "0";
        String delayed = "0";
        if (!listNumber.isEmpty()) {
            process = String.valueOf(listNumber.get(0));
            cancelled = String.valueOf(listNumber.get(1));
            completed = String.valueOf(listNumber.get(2));
            delayed = String.valueOf(listNumber.get(3));
        }
        String collection = process + "+" + cancelled + "+" + completed + "+" + delayed;
        return collection;
    }

    private String getDay(LocalDateTime local) {
        String getDay;
        if (local.getDayOfMonth() < 10) {
            getDay = "0" + local.getDayOfMonth();
        } else {
            getDay = String.valueOf(local.getDayOfMonth());
        }
        return getDay;
    }

    private String getMonth(LocalDateTime local) {
        String getMonth;
        if (local.getMonthValue() < 10) {
            getMonth = "0" + local.getMonthValue();
        } else {
            getMonth = String.valueOf(local.getMonthValue());
        }
        return getMonth;
    }
}
