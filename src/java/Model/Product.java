/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Base64;

/**
 *
 * @author phong
 */
public class Product {

    private int idProduct;
    private String nameProduct;
    private float Price;
    private byte[] imageProduct;
    private String imageType;
    private String type;
    private String createTime;
    private String creater;
    private String updateTime;
    private String updater;
    private float rate;

    public Product() {
    }

    public Product(int idProduct, String nameProduct, float Price, byte[] imageProduct, String imageType, String type, String createTime, String creater, String updateTime, String updater, float rate) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.Price = Price;
        this.imageProduct = imageProduct;
        this.imageType = imageType;
        this.type = type;
        this.createTime = createTime;
        this.creater = creater;
        this.updateTime = updateTime;
        this.updater = updater;
        this.rate = rate;
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

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public byte[] getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(byte[] imageProduct) {
        this.imageProduct = imageProduct;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public byte[] convertFromBase64ToBinary(String base64) {
        try {
            byte[] encoded = org.apache.tomcat.util.codec.binary.Base64.decodeBase64(base64.getBytes());
            return encoded;
        } catch (Exception byteError) {
        }
        return null;
    }

    public String getBase64ProductType() {
        String base64;
        byte[] getDefaultAvatar = this.imageProduct;
        String codeFromBase64 = Base64.getEncoder().encodeToString(getDefaultAvatar);
        base64 = codeFromBase64;
        return base64;
    }

    public String getBase64Product() {
        String base64;
        byte[] getDefaultAvatar = this.imageProduct;
        String codeFromBase64 = Base64.getEncoder().encodeToString(getDefaultAvatar);
        base64 = "data:image/png;base64, " + codeFromBase64;
        return base64;
    }
}
