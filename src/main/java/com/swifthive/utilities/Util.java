package com.swifthive.utilities;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import com.swifthive.model.Response;
import com.swifthive.model.ResponseCode;

public class Util {

	private static final Logger logger = LogManager.getLogger(Util.class);
	private StringBuilder stringBuilder;

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	Response response;

	@Autowired
	ResponseCode responseCode;

	public Response responseBuilder(Long uniqueId, Long clientId, int code) {
		stringBuilder = new StringBuilder();
		response.setUniqueId(uniqueId);
		response.setClientId(clientId);
		response.setResponseCode(String.format("%03d", code));
		response.setResponseMessage(stringBuilder.append(responseCode.getResponseMessage()[code]).toString());
		return response;
	}

	public void sendEmailOneRecipient(String mailFrom, String mailToSingleRecipient, String subject, String message) {
		try {
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setFrom(mailFrom);
			msg.setTo(mailToSingleRecipient);
			msg.setSubject(subject);
			msg.setText(message);
			msg.setSentDate(new Date());
			javaMailSender.send(msg);
		} catch (Exception ex) {
			logger.error(ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
		}
	}

	public void sendEmailMultipleRecipient(String mailTo, List<String> mailToMultipleRecipient, String subject,
			String message) {
		try {
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setFrom(mailTo);
			//msg.setTo(mailToMultipleRecipient);
			msg.setSubject(subject);
			msg.setText(message);
			msg.setSentDate(new Date());
			javaMailSender.send(msg);
		} catch (Exception ex) {
			logger.error(ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
		}

	}

	public void sendEmailWithAttachment() {

		try {
			MimeMessage msg = javaMailSender.createMimeMessage();

			// true = multipart message
			MimeMessageHelper helper;

			helper = new MimeMessageHelper(msg, true);

			helper.setTo("to_@email");

			helper.setSubject("Testing from Spring Boot");

			// default = text/plain
			// helper.setText("Check attachment for image!");

			// true = text/html
			helper.setText("<h1>Check attachment for image!</h1>", true);

			// hard coded a file path
			// FileSystemResource file = new FileSystemResource(new
			// File("path/android.png"));

			helper.addAttachment("my_photo.png", new ClassPathResource("android.png"));

			javaMailSender.send(msg);

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String encryptString(String a, Long b) {
		String hashtext = null;

		try {
			// getInstance() method is called with algorithm SHA-512
			MessageDigest md = MessageDigest.getInstance("SHA-512");

			// digest() method is called
			// to calculate message digest of the input string
			// returned as array of byte
			byte[] messageDigest = md.digest(a.concat(String.valueOf(b)).getBytes());

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
			logger.error(ex.getMessage() + "\n" + ex.getLocalizedMessage() + "\n" + ex.getStackTrace());
			hashtext = "0";
		}
		return hashtext;
	}

	// Base64 Basic Decoding
	public String base64Decode(String value) {
		return new String(Base64.getDecoder().decode(value));
	}

	public String base64Encode(String value) {
		return Base64.getEncoder().encodeToString(value.getBytes());
	}

	public String accessValidation(String value) {
		return base64Encode(base64Encode(base64Encode(base64Encode(base64Encode(value)))));
	}
}
