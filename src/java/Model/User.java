/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Base64;
import javax.imageio.ImageIO;

/**
 *
 * @author ADMIN
 */
public class User {
    private int ID;
    private String email;
    private String password;
    private String gender;
    private int phoneNumber;
    private String address;
    private String nickname;
    private byte[] avatar;
    private String base64;
    private String verify;
    private String joinDate;
    
    public User() {
    }

    public User(int ID, String email, String password, String gender, int phoneNumber, String address, String nickname, byte[] avatar, String base64, String verify, String joinDate) {
        this.ID = ID;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.nickname = nickname;
        this.avatar = avatar;
        this.base64 = base64;
        this.verify = verify;
        this.joinDate = joinDate;
   }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public byte[] getAvatar() {
        BufferedImage image = null;
        ByteArrayOutputStream b = null;
        if (this.avatar == null) {
            try {
                image = ImageIO.read(new File("D:\\PRJ301ASSIGNMENT\\avatar\\logoAvatar.png"));
                b = new ByteArrayOutputStream();
                ImageIO.write(image, "png", b);

            } catch (IOException errorImg) {
            }
            if (b.toByteArray() != null) {
                this.avatar = b.toByteArray();
            }
        }
        return avatar;
    }

    public String getBase64Avatar() {
        String base64;
        if (this.base64 == null) {
            byte[] getDefaultAvatar = getAvatar();
            String codeFromBase64 = Base64.getEncoder().encodeToString(getDefaultAvatar);
            base64 = "data:image/png;base64, " + codeFromBase64;
        } else {
            base64 = this.base64;
        } 
        return base64;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }
    
}
