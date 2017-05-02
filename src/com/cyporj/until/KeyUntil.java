package com.cyporj.until;

import java.util.Random;

public class KeyUntil {
	
	 public static final String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	 public static final String letterChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	 public static final String numberChar = "0123456789";
     public static  String generateString(int length) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
	    for (int i = 0; i < length; i++) {
	    sb.append(numberChar.charAt(random.nextInt(numberChar.length())));
	   }
	    return sb.toString();
     }
 
	  public static void main(String[] args) {
	 System.out.println(generateString(15));
     }
}


