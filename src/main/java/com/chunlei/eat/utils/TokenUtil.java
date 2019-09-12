package com.chunlei.eat.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TokenUtil {
	private static final String KEY_ALGORITHM = "AES";
	private static final String CIPHER_ALGORITHM_ECB = "AES/CBC/PKCS5Padding";
	private static final String Key = "liuchunleieat";
	private static final String IV = "d039b7a926c3b289";

	private static SimpleDateFormat format = new SimpleDateFormat("yy-MM");

	private static Cipher global_cipher;
	private static SecretKeySpec global_secretKey;

	static {
		try {
			global_secretKey=new SecretKeySpec(getMD5Byte(Key), KEY_ALGORITHM);
			global_cipher = Cipher.getInstance(CIPHER_ALGORITHM_ECB);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//根据token获取id
	public static Integer getSidByToken(String content){
		String str = decrypt(content);
		if(str.startsWith("ss")){
			String dateStr = str.substring(2,7);
			String nowStr = format.format(new Date());
			if(nowStr.equals(dateStr)){
				String idStr = str.substring(35);
				return Integer.parseInt(idStr);
			}else {
				return null;
			}
		}else {
			return null;
		}
	}

	//根据token获取用户id
	public static String getSopenIdByToken(String content){
		String str = decrypt(content);
		if(str.startsWith("ss")){
			String dateStr = str.substring(2,7);
			String nowStr = format.format(new Date());
			if(nowStr.equals(dateStr)){
				String idStr = str.substring(7,35);
				return idStr;
			}else {
				return null;
			}
		}else {
			return null;
		}
	}

	//oYmsa0VexWjPUPA_k1qy5JiXHWAg
	//根据token获取id
	public static Integer getUidByToken(String content){
		String str = decrypt(content);
		if(str.startsWith("uu")){
			String dateStr = str.substring(2,7);
			String nowStr = format.format(new Date());
			if(nowStr.equals(dateStr)){
				String idStr = str.substring(35);
				return Integer.parseInt(idStr);
			}else {
				return null;
			}
		}else {
			return null;
		}
	}

	//根据token获取用户id
	public static String getUopenIdByToken(String content){
		String str = decrypt(content);
		if(str.startsWith("uu")){
			String dateStr = str.substring(2,7);
			String nowStr = format.format(new Date());
			if(nowStr.equals(dateStr)){
				String idStr = str.substring(7,35);
				return idStr;
			}else {
				return null;
			}
		}else {
			return null;
		}
	}

	//获取用户标识
	public static String getUtoken(Integer uId,String openId){
		String nowStr = format.format(new Date());
		String str = "uu"+nowStr+openId+uId;
		return encrypt(str);
	}
	//获取店铺标识
	public static String getStoken(Integer uId,String openId){
		String nowStr = format.format(new Date());
		String str = "ss"+nowStr+openId+uId;
		return encrypt(str);
	}

	/**
	 * 使用AES 算法 加密
	 */
	private static synchronized  String encrypt(String content) {
		String result = null;
		if (StringTool.isBlank(content)) {
			return result;
		}
		try {
			IvParameterSpec iv = new IvParameterSpec(IV.getBytes("UTF-8"));
			global_cipher.init(Cipher.ENCRYPT_MODE, global_secretKey,iv);// 
			// 密钥
			byte[] encrypt = global_cipher.doFinal(content.getBytes("UTF-8"));
			result = Base64.encodeBase64String(encrypt);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	private static byte[] getMD5Byte(final String data) {
		try {
			final MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(data.getBytes());
			return digest.digest();
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//解密
	private static synchronized String decrypt(String content) {
		String result = null;
		if (StringTool.isBlank(content)) {
			return result;
		}
		try {
			IvParameterSpec iv = new IvParameterSpec(IV.getBytes("UTF-8"));
			global_cipher.init(Cipher.DECRYPT_MODE, global_secretKey, iv);// 
			// 密钥
			byte[] decrypt = global_cipher.doFinal(Base64.decodeBase64(content));
			result = new String(decrypt,"UTF-8");
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return result;
	}
	

}
