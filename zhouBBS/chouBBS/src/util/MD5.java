package com.sxt.bbs.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	private static String[] md5 = "0,1,2,3,4,5,6,7,8,9,a,b,c,d,e,f".split(",");

	public static String md5Encode(String passwd) {
		if (passwd == null || passwd.equals("")) {
			return "";
		}

		StringBuffer result = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] b = md.digest(passwd.getBytes());
			for (int i = 0; i < b.length; i++) {
				int temp = b[i] < 0 ? b[i] + 256 : b[i];
				int a1 = temp / 16;
				int a2 = temp % 16;
				result.append(md5[a1]);
				result.append(md5[a2]);
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();

		}
		return result.toString();
	}

	public static void main(String[] args) {
		md5Encode("liangjie");
	}
}
