/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import org.apache.tomcat.util.codec.binary.Base64;

/**
 *
 * @author ADMIN
 */
public class main {

    public static void main(String[] args) {
        byte[] encoded = Base64.encodeBase64("Hello".getBytes());
        System.out.println(new String(encoded));

        byte[] decoded = Base64.decodeBase64(encoded);
        System.out.println(new String(decoded)); // Outputs "Hello"
    }
}
