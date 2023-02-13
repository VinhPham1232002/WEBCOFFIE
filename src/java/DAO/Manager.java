/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import Model.*;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Manager {

    public static int saveUserSignIn(User user) {
        int status = 0;

        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO [CUSTOMER] (EMAIL, PASSWORD, GENDER, PHONE, NICKNAME, AVATAR) VALUES(?, ?, ?, ?, ?, ?)");
            statement.setNString(1, user.getEmail());
            statement.setNString(2, user.getPassword());
            statement.setString(3, user.getGender());
            statement.setInt(4, user.getPhoneNumber());
            statement.setNString(5, user.getNickname());
            statement.setString(6, user.getBase64Avatar());
            status = statement.executeUpdate();
            connection.close();
        } catch (Exception sqlConnected) {
            sqlConnected.printStackTrace();
        }
        return status;
    }

    public static List<User> getAllAccount() {
        List<User> listAccount = new LinkedList<>();

        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT [IDCUSTOMER], [EMAIL], [PASSWORD], [GENDER], [PHONE], [ADDRESS], [NICKNAME], [AVATAR], [VERIFY], [JOINDATE] FROM [CUSTOMER]");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                User user = new User();
                user.setID(result.getInt(1));
                user.setEmail(result.getNString(2));
                user.setPassword(result.getNString(3));
                user.setGender(result.getString(4));
                user.setPhoneNumber(result.getInt(5));
                user.setAddress(result.getNString(6));
                user.setNickname(result.getNString(7));
                user.setBase64(result.getString(8));
                user.setVerify(result.getString(9));
                user.setJoinDate(result.getString(10));
                listAccount.add(user);
            }
            connection.close();
        } catch (Exception errorConnection) {
            errorConnection.printStackTrace();
        }
        return listAccount;
    }

    public static User searchAccount(String emailAccount) {
        User user = new User();
        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT [IDCUSTOMER], [EMAIL], [PASSWORD], [GENDER], [PHONE], [ADDRESS], [NICKNAME], [AVATAR], [VERIFY], [JOINDATE] FROM [CUSTOMER] WHERE [EMAIL] = ?");
            statement.setNString(1, emailAccount);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                user.setID(result.getInt(1));
                user.setEmail(result.getString(2));
                user.setPassword(result.getNString(3));
                user.setGender(result.getString(4));
                user.setPhoneNumber(result.getInt(5));
                user.setAddress(result.getNString(6));
                user.setNickname(result.getNString(7));
                user.setBase64(result.getString(8));
                user.setVerify(result.getString(9));
                user.setJoinDate(result.getString(10));
            }
            connection.close();
            if (user.getEmail() == null) {
                return null;
            } else {
                return user;
            }
        } catch (Exception errorSQL) {
            System.out.println(errorSQL.getMessage());
        }
        return null;
    }

    public static int changedPassword(String emailAccount, String newPassword) {
        User user = new User();
        int status = 0;
        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE CUSTOMER SET PASSWORD = ? WHERE EMAIL = ?");
            statement.setNString(1, newPassword);
            statement.setString(2, emailAccount);
            status = statement.executeUpdate();
            connection.close();
        } catch (Exception errorSQL) {
            errorSQL.printStackTrace();
        }
        return status;
    }

    public static int changeInformation(String email, String input, String statementQuery) {
        int status = 0;
        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement(statementQuery);
            statement.setNString(1, input);
            statement.setString(2, email);
            status = statement.executeUpdate();
            connection.close();
        } catch (Exception errorSQL) {
            errorSQL.printStackTrace();
        }
        return status;
    }

    public static int changeEmail(String email, String input, String statementQuery) {
        int status = 0;
        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement(statementQuery);
            statement.setString(1, input);
            statement.setString(2, email);
            status = statement.executeUpdate();
            connection.close();
        } catch (Exception errorSQL) {
            errorSQL.printStackTrace();
        }
        return status;
    }

    public static String convertToBase64(int ID) {
        String base64 = null;
        byte[] imageData = null;
        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT [AVATAR] FROM [CUSTOMER] WHERE [IDCUSTOMER] = ?");
            statement.setInt(1, ID);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                imageData = result.getBytes("AVATAR");
            }
            base64 = Base64.getEncoder().encodeToString(imageData);
            connection.close();
        } catch (Exception convertError) {
            convertError.printStackTrace();
            return null;
        }
        return base64;
    }

    public static int verifyAccount(String email) {
        int status = 0;
        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE CUSTOMER SET VERIFY = ? WHERE EMAIL = ?");
            statement.setString(1, "VERIFY");
            statement.setString(2, email);
            status = statement.executeUpdate();
            connection.close();
        } catch (Exception sqlError) {

        }
        return status;
    }

    public static int deleteAccount(String email) {
        int status = 0;
        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM CUSTOMER WHERE EMAIL = ?");
            statement.setString(1, email);
            status = statement.executeUpdate();
            connection.close();
        } catch (Exception sqlError) {

        }
        return status;
    }

    public static int addOrder(String orderID, int idCustomer, int idProduct,
            String name, String type, int quantity, float price,
            float total, String base64Image, String address) {
        int status = 0;

        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement
                    = connection.prepareStatement("INSERT INTO [ORDERCUSTOMER] (IDORDER, IDCUSTOMER, IDPRODUCT, NAMEPRODUCT, TYPE, QUANTITY, PRICE, TOTAL, IMAGEPRODUCT, ADDRESS) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, orderID);
            statement.setInt(2, idCustomer);
            statement.setInt(3, idProduct);
            statement.setString(4, name);
            statement.setString(5, type);
            statement.setInt(6, quantity);
            statement.setFloat(7, price);
            statement.setFloat(8, total);
            statement.setString(9, base64Image);
            statement.setString(10, address);
            status = statement.executeUpdate();
        } catch (Exception sqlError) {

        }
        return status;
    }

    public static Order searchOrder(String orderID, int idCustomer) {
        Order order = new Order();
        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM [ORDERCUSTOMER] WHERE [IDORDER] = ? AND [IDCUSTOMER] = ?");
            statement.setString(1, orderID);
            statement.setInt(2, idCustomer);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                order.setIdOrder(result.getString(1));
                order.setIdCustomer(result.getInt(2));
                order.setIdProduct(result.getInt(3));
                order.setAddressCustomer(result.getString(4));
                order.setNameProduct(result.getString(5));
                order.setType(result.getString(6));
                order.setQuantity(result.getInt(7));
                order.setStatus(result.getString(8));
                order.setPrice(result.getFloat(9));
                order.setTotal(result.getFloat(10));
                order.setOrder(result.getString(11));
                order.setOrderTime(result.getString(12));
                order.setDelay(result.getString(13));
                order.setDelayedTime(result.getString(14));
                order.setComplete(result.getString(15));
                order.setCompletedTime(result.getString(16));
                order.setCancel(result.getString(17));
                order.setCancelTime(result.getString(18));
                order.setProductImage(result.getString(19));
                order.setDistanceTime(result.getString(20));
                order.setRate(result.getInt(21));
            }
            connection.close();
            return order;
        } catch (Exception sqlError) {

        }
        return null;
    }

    public static Order searchOrder(String orderID) {
        Order order = new Order();
        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT OC.*, CUSTO.AVATAR, CUSTO.[NICKNAME] from [ORDERCUSTOMER] AS OC, [CUSTOMER] AS CUSTO WHERE [IDORDER] = ?");
            statement.setString(1, orderID);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                order.setIdOrder(result.getString(1));
                order.setIdCustomer(result.getInt(2));
                order.setIdProduct(result.getInt(3));
                order.setAddressCustomer(result.getString(4));
                order.setNameProduct(result.getString(5));
                order.setType(result.getString(6));
                order.setQuantity(result.getInt(7));
                order.setStatus(result.getString(8));
                order.setPrice(result.getFloat(9));
                order.setTotal(result.getFloat(10));
                order.setOrder(result.getString(11));
                order.setOrderTime(result.getString(12));
                order.setDelay(result.getString(13));
                order.setDelayedTime(result.getString(14));
                order.setComplete(result.getString(15));
                order.setCompletedTime(result.getString(16));
                order.setCancel(result.getString(17));
                order.setCancelTime(result.getString(18));
                order.setProductImage(result.getString(19));
                order.setDistanceTime(result.getString(20));
                order.setRate(result.getInt(21));
                order.setImageCustomer(result.getString(22));
                order.setNameCustomer(result.getString(23));
            }
            connection.close();
            return order;
        } catch (Exception sqlError) {

        }
        return null;
    }

    public static int updateStatus(String orderID, String orderStatus) {
        int status = 0;
        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE [ORDERCUSTOMER] SET [STATUS] = ? WHERE [IDORDER] = ?");
            statement.setString(1, orderStatus);
            statement.setString(2, orderID);
            status = statement.executeUpdate();
            connection.close();
        } catch (Exception sqlError) {

        }
        return status;
    }

    public static ArrayList getAllOrders(int idCustomer) {
        ArrayList<Order> orders = new ArrayList<>();

        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * from [ORDERCUSTOMER] WHERE IDCUSTOMER = ? ORDER BY [ORDER] DESC");
            statement.setInt(1, idCustomer);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Order order = new Order();
                order.setIdOrder(result.getString(1));
                order.setIdCustomer(result.getInt(2));
                order.setIdProduct(result.getInt(3));
                order.setAddressCustomer(result.getString(4));
                order.setNameProduct(result.getString(5));
                order.setType(result.getString(6));
                order.setQuantity(result.getInt(7));
                order.setStatus(result.getString(8));
                order.setPrice(result.getFloat(9));
                order.setTotal(result.getFloat(10));
                order.setOrder(result.getString(11));
                order.setOrderTime(result.getString(12));
                order.setDelay(result.getString(13));
                order.setDelayedTime(result.getString(14));
                order.setComplete(result.getString(15));
                order.setCompletedTime(result.getString(16));
                order.setCancel(result.getString(17));
                order.setCancelTime(result.getString(18));
                order.setProductImage(result.getString(19));
                order.setDistanceTime(result.getString(20));
                order.setRate(result.getInt(21));
                orders.add(order);
            }
            connection.close();
            return orders;
        } catch (Exception sqlError) {

        }
        return null;
    }

    public static ArrayList getAllOrders() {
        ArrayList<Order> orders = new ArrayList<>();

        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT OC.*, CUSTO.AVATAR, CUSTO.[NICKNAME] from [ORDERCUSTOMER] AS OC, [CUSTOMER] AS CUSTO ORDER BY [ORDER] DESC");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Order order = new Order();
                order.setIdOrder(result.getString(1));
                order.setIdCustomer(result.getInt(2));
                order.setIdProduct(result.getInt(3));
                order.setAddressCustomer(result.getString(4));
                order.setNameProduct(result.getString(5));
                order.setType(result.getString(6));
                order.setQuantity(result.getInt(7));
                order.setStatus(result.getString(8));
                order.setPrice(result.getFloat(9));
                order.setTotal(result.getFloat(10));
                order.setOrder(result.getString(11));
                order.setOrderTime(result.getString(12));
                order.setDelay(result.getString(13));
                order.setDelayedTime(result.getString(14));
                order.setComplete(result.getString(15));
                order.setCompletedTime(result.getString(16));
                order.setCancel(result.getString(17));
                order.setCancelTime(result.getString(18));
                order.setProductImage(result.getString(19));
                order.setDistanceTime(result.getString(20));
                order.setRate(result.getInt(21));
                order.setImageCustomer(result.getString(22));
                order.setNameCustomer(result.getString(23));
                orders.add(order);
            }
            connection.close();
            return orders;
        } catch (Exception sqlError) {

        }
        return null;
    }

    public static ArrayList<Order> searchOrderByName(String input) {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * from [ORDERCUSTOMER] WHERE [NAMEPRODUCT] LIKE ? ORDER BY [ORDER] DESC");
            statement.setString(1, "%" + input + "%");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Order order = new Order();
                order.setIdOrder(result.getString(1));
                order.setIdCustomer(result.getInt(2));
                order.setIdProduct(result.getInt(3));
                order.setAddressCustomer(result.getString(4));
                order.setNameProduct(result.getString(5));
                order.setType(result.getString(6));
                order.setQuantity(result.getInt(7));
                order.setStatus(result.getString(8));
                order.setPrice(result.getFloat(9));
                order.setTotal(result.getFloat(10));
                order.setOrder(result.getString(11));
                order.setOrderTime(result.getString(12));
                order.setDelay(result.getString(13));
                order.setDelayedTime(result.getString(14));
                order.setComplete(result.getString(15));
                order.setCompletedTime(result.getString(16));
                order.setCancel(result.getString(17));
                order.setCancelTime(result.getString(18));
                order.setProductImage(result.getString(19));
                order.setDistanceTime(result.getString(20));
                order.setRate(result.getInt(21));
                orders.add(order);
            }
            connection.close();
            return orders;
        } catch (Exception sqlError) {

        }
        return null;
    }

    public static ArrayList getAllOrdersWithProduct(int idProduct) {
        ArrayList<Order> orders = new ArrayList<>();

        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * from [ORDERCUSTOMER] WHERE IDPRODUCT = ? ORDER BY [ORDER] DESC");
            statement.setInt(1, idProduct);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Order order = new Order();
                order.setIdOrder(result.getString(1));
                order.setIdCustomer(result.getInt(2));
                order.setIdProduct(result.getInt(3));
                order.setAddressCustomer(result.getString(4));
                order.setNameProduct(result.getString(5));
                order.setType(result.getString(6));
                order.setQuantity(result.getInt(7));
                order.setStatus(result.getString(8));
                order.setPrice(result.getFloat(9));
                order.setTotal(result.getFloat(10));
                order.setOrder(result.getString(11));
                order.setOrderTime(result.getString(12));
                order.setDelay(result.getString(13));
                order.setDelayedTime(result.getString(14));
                order.setComplete(result.getString(15));
                order.setCompletedTime(result.getString(16));
                order.setCancel(result.getString(17));
                order.setCancelTime(result.getString(18));
                order.setProductImage(result.getString(19));
                order.setDistanceTime(result.getString(20));
                order.setRate(result.getInt(21));

                orders.add(order);
            }
            connection.close();
            return orders;
        } catch (Exception sqlError) {

        }
        return null;
    }

    public static ArrayList<Order> searchOrdertByID(String idOrder) {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT OC.*, CUSTO.AVATAR, CUSTO.[NICKNAME] from [ORDERCUSTOMER] AS OC, [CUSTOMER] AS CUSTO WHERE OC.[IDORDER] LIKE ? ORDER BY OC.[IDORDER] ASC");
            statement.setString(1, "%" + idOrder + "%");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Order order = new Order();
                order.setIdOrder(result.getString(1));
                order.setIdCustomer(result.getInt(2));
                order.setIdProduct(result.getInt(3));
                order.setAddressCustomer(result.getString(4));
                order.setNameProduct(result.getString(5));
                order.setType(result.getString(6));
                order.setQuantity(result.getInt(7));
                order.setStatus(result.getString(8));
                order.setPrice(result.getFloat(9));
                order.setTotal(result.getFloat(10));
                order.setOrder(result.getString(11));
                order.setOrderTime(result.getString(12));
                order.setDelay(result.getString(13));
                order.setDelayedTime(result.getString(14));
                order.setComplete(result.getString(15));
                order.setCompletedTime(result.getString(16));
                order.setCancel(result.getString(17));
                order.setCancelTime(result.getString(18));
                order.setProductImage(result.getString(19));
                order.setDistanceTime(result.getString(20));
                order.setRate(result.getInt(21));
                order.setImageCustomer(result.getString(22));
                order.setNameCustomer(result.getString(23));
                orders.add(order);
            }
            connection.close();
            return orders;
        } catch (Exception sqlError) {

        }
        return null;
    }

    public static Product searchProduct(String productName) {
        int status = 0;
        Product product = new Product();
        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT [IDPRODUCT], [NAME], [PRICE], [IMAGE], [TYPE], [CREATER], [CREATEON], [UPDATER], [LASTUPDATE], [RATE] FROM PRODUCT WHERE NAME = ?");
            statement.setString(1, productName);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                product.setIdProduct(result.getInt(1));
                product.setNameProduct(result.getString(2));
                product.setPrice(result.getFloat(3));
                product.setImageProduct(result.getBytes(4));
                product.setType(result.getString(5));
                product.setCreater(result.getString(6));
                product.setCreateTime(result.getString(7));
                product.setUpdater(result.getString(8));
                product.setUpdateTime(result.getString(9));
                product.setRate(result.getFloat(10));
            }
            connection.close();
            return product;
        } catch (Exception sqlError) {

        }
        return null;
    }

    public static ArrayList getAllProducts() {
        ArrayList<Product> products = new ArrayList<>();

        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT [IDPRODUCT], [NAME], [PRICE], [IMAGE], [TYPE], [CREATER], [CREATEON], [UPDATER], [LASTUPDATE], [RATE], [IMAGETYPE] FROM PRODUCT");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Product product = new Product();
                product.setIdProduct(result.getInt(1));
                product.setNameProduct(result.getString(2));
                product.setPrice(result.getFloat(3));
                product.setImageProduct(result.getBytes(4));
                product.setType(result.getString(5));
                product.setCreater(result.getString(6));
                product.setCreateTime(result.getString(7));
                product.setUpdater(result.getString(8));
                product.setUpdateTime(result.getString(9));
                product.setRate(result.getFloat(10));
                product.setImageType(result.getString(11));
                products.add(product);
            }
            connection.close();
            return products;
        } catch (Exception sqlError) {

        }
        return null;
    }

    public static int addProduct(String productName, float price, byte[] imageBinary, String imageType, String type, String creater) {
        int status = 0;

        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO [PRODUCT] ([NAME], [PRICE], [IMAGE], [IMAGETYPE], [TYPE], [CREATER]) VALUES(?,?,?,?,?,?)");
            statement.setString(1, productName);
            statement.setFloat(2, price);
            statement.setBytes(3, imageBinary);
            statement.setString(4, imageType);
            statement.setString(5, type);
            statement.setString(6, creater);
            status = statement.executeUpdate();
            connection.close();
        } catch (Exception sqlError) {
        }
        return status;
    }

    public static int updateProduct(String productName, float price, byte[] imageBinary, String imageType, String type, String updater, int idProduct) {
        int status = 0;
        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE [PRODUCT] SET NAME = ?, PRICE = ?, IMAGE = ?, IMAGETYPE = ?, TYPE = ?, UPDATER = ?, LASTUPDATE = GETDATE() WHERE [IDPRODUCT] = ?");
            statement.setString(1, productName);
            statement.setFloat(2, price);
            statement.setBytes(3, imageBinary);
            statement.setString(4, imageType);
            statement.setString(5, type);
            statement.setString(6, updater);
            statement.setInt(7, idProduct);
            status = statement.executeUpdate();
            connection.close();
        } catch (Exception sqlError) {
        }
        return status;
    }

    public static int updateRateOrder(int idCustomer, String productName, String idOrder, String rate) {
        int status = 0;
        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE [ORDERCUSTOMER] SET RATE = ? WHERE [IDCUSTOMER] = ? AND [IDORDER] = ? AND [NAMEPRODUCT] = ?");
            statement.setInt(1, Integer.parseInt(rate));
            statement.setInt(2, idCustomer);
            statement.setString(3, idOrder);
            statement.setString(4, productName);
            status = statement.executeUpdate();
            connection.close();
        } catch (Exception sqlError) {
        }
        return status;
    }

    public static int updateRateProduct(int idProduct, String productName, String rate) {
        int status = 0;
        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE [PRODUCT] SET RATE = ? WHERE [IDPRODUCT] = ? AND [NAME] = ?");
            statement.setFloat(1, Float.parseFloat(rate));
            statement.setInt(2, idProduct);
            statement.setString(3, productName);
            status = statement.executeUpdate();
            connection.close();
        } catch (Exception sqlError) {
        }
        return status;
    }

    public static String getProductAverageRate() {
        double total = 0;
        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT TOP 1 "
                    + "(SELECT COUNT(RATE) FROM ORDERCUSTOMER WHERE RATE = 5) AS FIVE, "
                    + "(SELECT COUNT(RATE) FROM ORDERCUSTOMER WHERE RATE = 4) AS FOUR, "
                    + "(SELECT COUNT(RATE) FROM ORDERCUSTOMER WHERE RATE = 3) AS THREE, "
                    + "(SELECT COUNT(RATE) FROM ORDERCUSTOMER WHERE RATE = 2) AS TWO, "
                    + "(SELECT COUNT(RATE) FROM ORDERCUSTOMER WHERE RATE = 1) AS ONE");
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                int fiveStar = result.getInt(1);
                int fourStar = result.getInt(2);
                int threeStar = result.getInt(3);
                int twoStar = result.getInt(4);
                int oneStar = result.getInt(5);
                int totalResponse = fiveStar * 5 + fourStar * 4 + threeStar * 3 + twoStar * 2 + oneStar * 1;
                int totalStar = fiveStar + fourStar + threeStar + twoStar + oneStar;
                total = (double) totalResponse / totalStar;
            }
            connection.close();
        } catch (Exception sqlError) {
        }
        return String.format("%.1f", total);
    }

    public static int getNumberOfRate(int idProduct) {
        int total = 0;
        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT COUNT(OD.RATE) AS TOTALRATE FROM ORDERCUSTOMER AS OD WHERE OD.RATE > 0 AND OD.IDPRODUCT = ?");
            statement.setInt(1, idProduct);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                total = result.getInt(1);
            }
            connection.close();
        } catch (Exception sqlError) {
        }
        return total;
    }

    public static int deleteProduct(String productName, int idProduct) {
        int status = 0;
        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE [PRODUCT] WHERE [NAME] = ? AND [IDPRODUCT] = ?");
            statement.setString(1, productName);
            statement.setInt(2, idProduct);
            status = statement.executeUpdate();
            connection.close();
        } catch (Exception sqlError) {
        }
        return status;
    }

    public static ArrayList<Product> searchProductByName(String nameProduct) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from product where [NAME] LIKE ? ORDER BY [IDPRODUCT] ASc");
            statement.setString(1, "%" + nameProduct + "%");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Product product = new Product();
                product.setIdProduct(result.getInt(1));
                product.setNameProduct(result.getString(2));
                product.setPrice(result.getFloat(3));
                product.setImageProduct(result.getBytes(4));
                product.setImageType(result.getString(5));
                product.setType(result.getString(6));
                product.setCreater(result.getString(7));
                product.setCreateTime(result.getString(8));
                product.setUpdater(result.getString(9));
                product.setUpdateTime(result.getString(10));
                product.setRate(result.getFloat(11));
                products.add(product);
            }
            connection.close();
            return products;
        } catch (Exception sqlError) {

        }
        return null;
    }

    public static ArrayList getOrdersAchivement(int idCustomer) {
        ArrayList<Integer> listNumberOrders = new ArrayList<>();

        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("select TOP 1 (select COUNT(ORD.STATUS) as PROCESS from [ORDERCUSTOMER] AS ORD WHERE ORD.STATUS = 'PROCESS' AND IDCUSTOMER = ?) as PROCESS, (select COUNT(ORD.STATUS) as CANCELLED from [ORDERCUSTOMER] AS ORD WHERE ORD.STATUS = 'CANCELLED' AND IDCUSTOMER = ?) as CANCELLED, \n"
                    + "(select COUNT(ORD.STATUS) as COMPLETED from [ORDERCUSTOMER] AS ORD WHERE ORD.STATUS = 'COMPLETED' AND IDCUSTOMER = ?) as COMPLETED, (select COUNT(ORD.STATUS) as COMPLETED from [ORDERCUSTOMER] AS ORD WHERE ORD.STATUS = 'DELAYED' AND IDCUSTOMER = ?) as DELAYED from [ORDERCUSTOMER] WHERE IDCUSTOMER = ?");
            statement.setInt(1, idCustomer);
            statement.setInt(2, idCustomer);
            statement.setInt(3, idCustomer);
            statement.setInt(4, idCustomer);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                listNumberOrders.add(result.getInt(1));
                listNumberOrders.add(result.getInt(2));
                listNumberOrders.add(result.getInt(3));
                listNumberOrders.add(result.getInt(4));
            }

            connection.close();
            return listNumberOrders;
        } catch (Exception sqlError) {

        }
        return listNumberOrders;
    }

    public static ArrayList getProductAchivement(int idProduct) {
        ArrayList<Integer> listNumberOrders = new ArrayList<>();

        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("select TOP 1 (select COUNT(ORD.STATUS) as PROCESS from [ORDERCUSTOMER] AS ORD WHERE ORD.STATUS = 'PROCESS' AND IDPRODUCT = ?) as PROCESS, (select COUNT(ORD.STATUS) as CANCELLED from [ORDERCUSTOMER] AS ORD WHERE ORD.STATUS = 'CANCELLED' AND IDPRODUCT = ?) as CANCELLED, \n"
                    + "(select COUNT(ORD.STATUS) as COMPLETED from [ORDERCUSTOMER] AS ORD WHERE ORD.STATUS = 'COMPLETED' AND IDPRODUCT = ?) as COMPLETED, (select COUNT(ORD.STATUS) as COMPLETED from [ORDERCUSTOMER] AS ORD WHERE ORD.STATUS = 'DELAYED' AND IDPRODUCT = ?) as DELAYED  from [ORDERCUSTOMER]");
            statement.setInt(1, idProduct);
            statement.setInt(2, idProduct);
            statement.setInt(3, idProduct);
            statement.setInt(4, idProduct);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                listNumberOrders.add(result.getInt(1));
                listNumberOrders.add(result.getInt(2));
                listNumberOrders.add(result.getInt(3));
                listNumberOrders.add(result.getInt(4));
            }

            connection.close();
            return listNumberOrders;
        } catch (Exception sqlError) {

        }
        return listNumberOrders;
    }

    public static int updateTime(String orderID, String distanceTime, String query) {
        int status = 0;
        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, distanceTime);
            statement.setString(2, orderID);
            status = statement.executeUpdate();
            connection.close();
        } catch (Exception sqlError) {

        }
        return status;
    }

    public static int deleteTime(String orderID, String statusDelivery, String query) {
        int status = 0;
        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, statusDelivery);
            statement.setString(2, orderID);
            status = statement.executeUpdate();
            connection.close();
        } catch (Exception sqlError) {

        }
        return status;
    }

    public static int transportUpdate(int idCustomer, String idOrder, int idProduct, String customerNickName, int phoneNumber, float shippingCost) {
        int status = 0;
        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO TRANSPORT ([IDCUSTOMER], [IDORDER], [IDPRODUCT], [CUSTOMERNIKCNAME], [PHONENUMBER], [TRANSPORTCOST])VALUES(?, ?, ?, ?, ?, ?)");
            statement.setInt(1, idCustomer);
            statement.setString(2, idOrder);
            statement.setInt(3, idProduct);
            statement.setString(4, customerNickName);
            statement.setInt(5, phoneNumber);
            statement.setFloat(6, shippingCost);
            status = statement.executeUpdate();
            connection.close();
        } catch (Exception sqlError) {

        }
        return status;
    }

    public static Transport searchOrderTransport(int idCustomer, String idOrder) {
        Transport transport = new Transport();
        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM TRANSPORT WHERE [IDCUSTOMER] = ? AND [IDORDER] = ?");
            statement.setInt(1, idCustomer);
            statement.setString(2, idOrder);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                transport.setIdCustomer(result.getInt(1));
                transport.setIdOrder(result.getString(2));
                transport.setIdProduct(result.getInt(3));
                transport.setCustomerName(result.getString(4));
                transport.setPhoneNumber(result.getInt(5));
                transport.setTransportName(result.getString(6));
                transport.setShippingCost(result.getFloat(7));
                transport.setStatus(result.getString(8));
                transport.setDescription(result.getString(9));
            }
            connection.close();
            if (transport.getIdCustomer() == 0) {
                return null;
            }
            return transport;
        } catch (Exception sqlError) {

        }
        return null;
    }

    public static int updateTransportStatus(String description, String idOrder) {
        int status = 0;

        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE TRANSPORT SET [STATUS] = ?, [DESCRIPTION] = ? WHERE [IDORDER] = ?");
            statement.setString(1, "CANCELLED");
            statement.setString(2, description);
            statement.setString(3, idOrder);
            status = statement.executeUpdate();
            connection.close();
        } catch (Exception sqlError) {

        }
        return status;
    }

    public static int updateTransportStatus(String description, String idOrder, String statusDelivery) {
        int status = 0;

        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE TRANSPORT SET [STATUS] = ?, [DESCRIPTION] = ? WHERE [IDORDER] = ?");
            statement.setString(1, statusDelivery);
            statement.setString(2, description);
            statement.setString(3, idOrder);
            status = statement.executeUpdate();
            connection.close();
        } catch (Exception sqlError) {

        }
        return status;
    }

    public static int addStaff(String name, String dob, String gender, String address, int phoneNumber, String email, String role, String staffImage) {
        int status = 0;
        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO STAFF(NAME, DOB, GENDER, ADDRESS, PHONENUMBER, EMAIL, ROLE, STAFFIMAGE) VALUES(?,?,?,?,?,?,?,?)");
            statement.setString(1, name);
            statement.setString(2, dob);
            statement.setString(3, gender);
            statement.setString(4, address);
            statement.setInt(5, phoneNumber);
            statement.setString(6, email);
            statement.setString(7, role);
            statement.setString(8, staffImage);
            status = statement.executeUpdate();
            connection.close();
        } catch (Exception sqlError) {

        }
        return status;
    }

    public static int updateStaff(String name, String dob, String gender, String address, int phoneNumber, String email, String role, String staffImage) {
        int status = 0;
        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE STAFF SET NAME = ?, DOB = ?, GENDER = ?, ADDRESS = ?, PHONENUMBER = ?, ROLE = ?, STAFFIMAGE = ? WHERE EMAIL = ?");
            statement.setString(1, name);
            statement.setString(2, dob);
            statement.setString(3, gender);
            statement.setString(4, address);
            statement.setInt(5, phoneNumber);
            statement.setString(6, role);
            statement.setString(7, staffImage);
            statement.setString(8, email);
            status = statement.executeUpdate();
            connection.close();
        } catch (Exception sqlError) {

        }
        return status;
    }

    public static int deleteStaff(String email, String name) {
        int status = 0;
        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE STAFF WHERE EMAIL = ? AND NAME = ?");
            statement.setString(1, name);
            statement.setString(2, email);
            status = statement.executeUpdate();
            connection.close();
        } catch (Exception sqlError) {

        }
        return status;
    }

    public static int updateStaffPassWord(String email, String name, String password) {
        int status = 0;
        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE STAFF SET PASSWORD = ? WHERE EMAIL = ? AND NAME = ?");
            statement.setString(1, password);
            statement.setString(2, name);
            statement.setString(3, email);
            status = statement.executeUpdate();
            connection.close();
        } catch (Exception sqlError) {
        }
        return status;
    }

    public static int updateStaffSpeicalCode(String email, String specialCode, String lastActive) {
        int status = 0;
        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE STAFF SET SPECIALCODE = ?, LASTACTIVE = ? WHERE EMAIL = ?");
            statement.setString(1, specialCode);
            statement.setString(2, lastActive);
            statement.setString(3, email);
            status = statement.executeUpdate();
            connection.close();
        } catch (Exception sqlError) {
        }
        return status;
    }

    public static Staff searchStaff(String email) {
        Staff staff = new Staff();
        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM STAFF WHERE EMAIL = ? ORDER BY [IDSTAFF] ASC");
            statement.setString(1, email);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                staff.setIdStaff(result.getInt(1));
                staff.setName(result.getString(2));
                staff.setDoB(result.getString(3));
                staff.setGender(result.getString(4));
                staff.setAddress(result.getString(5));
                staff.setPhoneNumber(result.getInt(6));
                staff.setEmailStaff(result.getString(7));
                staff.setPassword(result.getString(8));
                staff.setRole(result.getString(9));
                staff.setLastActive(result.getString(10));
                staff.setJoinDate(result.getString(11));
                staff.setStaffImage(result.getString(12));
                staff.setSpecialCode(result.getString(13));
            }
            connection.close();
            return staff;
        } catch (Exception sqlError) {

        }
        return staff;
    }

    public static ArrayList<Staff> searchStaffByName(String name) {
        ArrayList<Staff> staffList = new ArrayList<>();
        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM STAFF WHERE NAME LIKE ? ORDER BY [IDSTAFF] ASC");
            statement.setString(1, "%" + name + "%");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Staff staff = new Staff();
                staff.setIdStaff(result.getInt(1));
                staff.setName(result.getString(2));
                staff.setDoB(result.getString(3));
                staff.setGender(result.getString(4));
                staff.setAddress(result.getString(5));
                staff.setPhoneNumber(result.getInt(6));
                staff.setEmailStaff(result.getString(7));
                staff.setPassword(result.getString(8));
                staff.setRole(result.getString(9));
                staff.setLastActive(result.getString(10));
                staff.setJoinDate(result.getString(11));
                staff.setStaffImage(result.getString(12));
                staff.setSpecialCode(result.getString(13));
                staffList.add(staff);
            }
            connection.close();
            return staffList;
        } catch (Exception sqlError) {

        }
        return staffList;
    }

    public static ArrayList<Staff> getAllStaff() {
        ArrayList<Staff> staffList = new ArrayList<>();
        try {
            Connection connection = new DBContext().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM STAFF ORDER BY [IDSTAFF] ASC");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Staff staff = new Staff();
                staff.setIdStaff(result.getInt(1));
                staff.setName(result.getString(2));
                staff.setDoB(result.getString(3));
                staff.setGender(result.getString(4));
                staff.setAddress(result.getString(5));
                staff.setPhoneNumber(result.getInt(6));
                staff.setEmailStaff(result.getString(7));
                staff.setPassword(result.getString(8));
                staff.setRole(result.getString(9));
                staff.setLastActive(result.getString(10));
                staff.setJoinDate(result.getString(11));
                staff.setStaffImage(result.getString(12));
                staff.setSpecialCode(result.getString(13));
                staffList.add(staff);
            }
            connection.close();
            return staffList;
        } catch (Exception sqlError) {

        }
        return staffList;
    }
}
