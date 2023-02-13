/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author phong
 */
public class Transport {
    private int idCustomer;
    private String idOrder;
    private int idProduct;
    private String customerName;
    private int phoneNumber;
    private String transportName;
    private float shippingCost;
    private String status;
    private String description;

    public Transport() {
    }

    public Transport(int idCustomer, String idOrder, int idProduct, String customerName, int phoneNumber, String transportName, float shippingCost, String status, String description) {
        this.idCustomer = idCustomer;
        this.idOrder = idOrder;
        this.idProduct = idProduct;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.transportName = transportName;
        this.shippingCost = shippingCost;
        this.status = status;
        this.description = description;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTransportName() {
        return transportName;
    }

    public void setTransportName(String transportName) {
        this.transportName = transportName;
    }

    public float getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(float shippingCost) {
        this.shippingCost = shippingCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
