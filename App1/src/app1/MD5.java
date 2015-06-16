/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app1;

/**
 *
 * @author Massa
 */
import java.security.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MD5 {
	public String md5(String str) {
		String s = str;
		if (s == null) {
			return "";
		} 
		else {
			String value = null;
			MessageDigest md5 = null;
			try {
				md5 = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException ex) {
				Logger.getLogger(MD5.class.getName()).log(Level.SEVERE, null,
						ex);
			}
			sun.misc.BASE64Encoder baseEncoder = new sun.misc.BASE64Encoder();
			try {
				value = baseEncoder.encode(md5.digest(s.getBytes("utf-8")));
			} catch (Exception ex) {
			}
			return value;
		}
	}
        
      /*  public static void main(String[] args) {
        MD5 md = new MD5();

    }*/
        
}