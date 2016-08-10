package org.redhat.integration;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utility {
	
	
	
	/*
	 --------------
	 PUBLIC METHODS
	 --------------
	 */
		
	public String computedate() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // format of a MySQL datetime
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);

		return f.format(cal.getTime());
		
	}
	
		
	public String computehash(String msg) throws NoSuchAlgorithmException {
		byte[] b = msg.getBytes();
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		
		md5.update(b, 0, b.length);
		byte[] r = md5.digest();
		
		return hexStringFromBytes(r);
	}
	
	
	/*
	 ---------------
	 PRIVATE METHODS
	 ---------------
	 */
	private String hexStringFromBytes(byte[] b) {
		char[] hexChars =
			{
			'0',
			'1',
			'2',
			'3',
			'4',
			'5',
			'6',
			'7',
			'8',
			'9',
			'A',
			'B',
			'C',
			'D',
			'E',
			'F' };

		String hex = "";
		int msb;
		int lsb = 0;
		int i;
		// MSB maps to idx 0 
		for (i = 0; i < b.length; i++) {
			msb = ((int) b[i] & 0x000000FF) / 16;
			lsb = ((int) b[i] & 0x000000FF) % 16;
			hex = hex + hexChars[msb] + hexChars[lsb];
		}
		return (hex);
	}

}


