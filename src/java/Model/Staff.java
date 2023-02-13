/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author phong
 */
public class Staff {
    private int idStaff;
    private String name;
    private String DoB;
    private String gender;
    private String address;
    private int phoneNumber;
    private String emailStaff;
    private String password;
    private String role;
    private String lastActive;
    private String joinDate;
    private String staffImage;
    private String specialCode;

    public Staff() {
    }

    public Staff(int idStaff, String name, String DoB, String gender, String address, int phoneNumber, String emailStaff, String password, String role, String lastActive, String joinDate, String staffImage, String specialCode) {
        this.idStaff = idStaff;
        this.name = name;
        this.DoB = DoB;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailStaff = emailStaff;
        this.password = password;
        this.role = role;
        this.lastActive = lastActive;
        this.joinDate = joinDate;
        this.staffImage = staffImage;
        this.specialCode = specialCode;
    }

    public int getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(int idStaff) {
        this.idStaff = idStaff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDoB() {
        return DoB;
    }

    public void setDoB(String DoB) {
        this.DoB = DoB;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailStaff() {
        return emailStaff;
    }

    public void setEmailStaff(String emailStaff) {
        this.emailStaff = emailStaff;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLastActive() {
        return lastActive;
    }

    public void setLastActive(String lastActive) {
        this.lastActive = lastActive;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getStaffImage() {
        return staffImage;
    }

    public void setStaffImage(String staffImage) {
        this.staffImage = staffImage;
    }

    public String getSpecialCode() {
        return specialCode;
    }

    public void setSpecialCode(String specialCode) {
        this.specialCode = specialCode;
    }

    
    

}
