package com.swifthive.utilities;

import java.math.BigInteger;
import java.security.MessageDigest;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;

public class Crypto {

	private static final Logger logger = Logger.getLogger(Crypto.class);

	public static String encryptThisString(String a, String b) {
		String hashtext = null;

		try {
			// getInstance() method is called with algorithm SHA-512
			MessageDigest md = MessageDigest.getInstance("SHA-512");

			// digest() method is called
			// to calculate message digest of the input string
			// returned as array of byte
			byte[] messageDigest = md.digest(a.concat(b).getBytes());

			// Convert byte array into signum representation
			BigInteger no = new BigInteger(1, messageDigest);

			// Convert message digest into hex value
			hashtext = no.toString(16);

			// Add preceding 0s to make it 32 bit
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}

			// For specifying wrong message digest algorithms
		} catch (Exception ex) {
			logger.error(ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ExceptionUtils.getStackTrace(ex));
			hashtext = "0";
		}
		return hashtext;
	}
}
