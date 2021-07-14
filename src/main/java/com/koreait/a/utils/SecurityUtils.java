package com.koreait.a.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

public class SecurityUtils {
	// ũ�ν� ����Ʈ ��ũ��Ʈ(XXS)
		// ��ũ��Ʈ �Է��� ����ȭ
		public static String xxs(String str) {
			str = str.replaceAll("&", "&amp;");
			str = str.replaceAll("\"", "&quot;");
			str = str.replaceAll("<", "&lt;");
			str = str.replaceAll(">", "&gt;");
			return str;
		}
		
		public static String sha256(String str) {
			// java : java.security
			// MessageDigest;
			MessageDigest md = null;
			try {
				md = MessageDigest.getInstance("SHA-256");
				md.update(str.getBytes());
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			// md.digest() : ��ȣȭ �� ����Ʈ �迭
			StringBuilder sb = new StringBuilder();
			for (byte b : md.digest()) {
				sb.append(String.format("%02X", b));  // 16���� ǥ��� ��ȯ (%02x, %02X)
			}
			return sb.toString();
		}
		
		// ��ȣȭ: "1111" -> "MTExMQ=="
		public static String encodeBase64(String str) {
			// commons-codec
			// Base64
			// Base64.encodeBase64(pw.getBytes()) : ��ȣȭ �� ����Ʈ �迭
			return new String(Base64.encodeBase64(str.getBytes()));
		}
		
		// ��ȣȭ: "MTExMQ==" -> "1111"
		public static String decodeBase64(String str) {
			return new String(Base64.decodeBase64(str.getBytes()));
		}
		
		// �����ڵ� ����
		public static String getAuthCode(int length) {
			String authCode = "";
			char[] characters = {
					'A', 'B', 'C', 'D', 'E',
					'F', 'G', 'H', 'I', 'J',
					'K', 'L', 'M', 'N', 'O',
					'P', 'Q', 'R', 'S', 'T',
					'U', 'V', 'W', 'X', 'Y',
					'Z', '0', '1', '2', '3',
					'4', '5', '6', '7', '8',
					'9', '!', '@', '#', '$'
			};
			for (int i = 0; i < length; i++) {
				authCode += characters[(int)(Math.random() * characters.length)];
			}
			return authCode;
		}
		
	}