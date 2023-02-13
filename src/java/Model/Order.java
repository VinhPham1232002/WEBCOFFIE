/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author phong
 */
public class Order {
    private String idOrder;
    private int idCustomer;
    private int idProduct;
    private String nameProduct;
    private String type;
    private int quantity;
    private String status;
    private float price;
    private float total;
    private String order;
    private String orderTime;
    private String cancel;
    private String cancelTime;
    private String delay;
    private String delayedTime;
    private String complete;
    private String completedTime;
    private String productImage;
    private String distanceTime;
    private String addressCustomer;
    private String imageCustomer;
    private String nameCustomer;
    private int rate;

    public Order() {
    }

    public Order(String idOrder, int idCustomer, int idProduct, String nameProduct, String type, int quantity, String status, float price, float total, String order, String orderTime, String cancel, String cancelTime, String delay, String delayedTime, String complete, String completedTime, String productImage, String distanceTime, String addressCustomer, String imageCustomer, String nameCustomer, int rate) {
        this.idOrder = idOrder;
        this.idCustomer = idCustomer;
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.type = type;
        this.quantity = quantity;
        this.status = status;
        this.price = price;
        this.total = total;
        this.order = order;
        this.orderTime = orderTime;
        this.cancel = cancel;
        this.cancelTime = cancelTime;
        this.delay = delay;
        this.delayedTime = delayedTime;
        this.complete = complete;
        this.completedTime = completedTime;
        this.productImage = productImage;
        this.distanceTime = distanceTime;
        this.addressCustomer = addressCustomer;
        this.imageCustomer = imageCustomer;
        this.nameCustomer = nameCustomer;
        this.rate = rate;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getCancel() {
        return cancel;
    }

    public void setCancel(String cancel) {
        this.cancel = cancel;
    }

    public String getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(String cancelTime) {
        this.cancelTime = cancelTime;
    }

    public String getDelay() {
        return delay;
    }

    public void setDelay(String delay) {
        this.delay = delay;
    }

    public String getDelayedTime() {
        return delayedTime;
    }

    public void setDelayedTime(String delayedTime) {
        this.delayedTime = delayedTime;
    }

    public String getComplete() {
        return complete;
    }

    public void setComplete(String complete) {
        this.complete = complete;
    }

    public String getCompletedTime() {
        return completedTime;
    }

    public void setCompletedTime(String completedTime) {
        this.completedTime = completedTime;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getDistanceTime() {
        return distanceTime;
    }

    public void setDistanceTime(String distanceTime) {
        this.distanceTime = distanceTime;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    public String getImageCustomer() {
        return imageCustomer;
    }

    public void setImageCustomer(String imageCustomer) {
        this.imageCustomer = imageCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    
    
    
}
