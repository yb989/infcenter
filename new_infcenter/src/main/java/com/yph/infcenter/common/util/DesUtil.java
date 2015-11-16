package com.yph.infcenter.common.util;

import java.io.IOException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class DesUtil {
	private final static String DES = "DES";
	 
    public static void main(String[] args) throws Exception {
    	//192.168.0.104:8080/infcenter_foreground1/exhibition/1/0jOKfPQJzsPqcDdMb/VmmgEK7MG0C01EPazTSMpRbaJyYw7I8PhNVhOzUFBMj0XEayaSQDkpIApFMo1opahR1E0AL1ci17fi/2//NBWGo+U/l8Tb3gJfy4znt2LzK+NES3Vrd4EewuDBWiViaaphApwNeUge9jZrZKb
    	
        String data = "G:/tomcat7/webapps/infcenter_foreground/offwebsite/news/dongtai/3";
        
//        String data = "http://192.168.0.141:8080/infcenter_foreground1/exhibition/page?phyAddress=G:/tomcat/tomcat6/tomcat(6.0.37)/webapps/infcenter/intro/30.html&netAddress=/intro/30.html";
        String key = "eph!@#$%infcenter123,./";
        
        System.err.println(filter(encrypt(data, key)));
        
        System.out.println(decrypt(filter(encrypt(data, key)),key));
////        System.err.println(decrypt(encrypt(data, key), key));
//        System.out.println(decrypt(encrypt(data, key), key));
//        
////        System.err.println(URLEncoder.encode(data, "utf-8"));
////        System.err.println(URLDecoder.decode(URLEncoder.encode(data, "utf-8"), "utf-8"));
//        
//        String data2 = "http://localhost:8080/infcenter/intro/30.html";
//        String key2 = "eph!@#$%infcenter123,./";
//        
//        System.err.println(encrypt(data2, key2));
//        System.err.println(decrypt("wBjt-dn9x0g-wTVR005Tr5bWwJI476HbNIVm3O1sGCuvJ6HGkgTpJQhStLh2sypDHLwRTJ5sIzoSbzfDuAtVcdDacgXVb1TJ", key2));
        
//        System.err.println(URLEncoder.encode(data2, "utf-8"));
//        System.err.println(URLDecoder.decode(URLEncoder.encode(data2, "utf-8"), "utf-8"));
 
    }
     
    /**
     * Description 根据键值进行加密
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    public static String encrypt(String data, String key) throws Exception {
        byte[] bt = encrypt(data.getBytes("utf-8"), key.getBytes("utf-8"));
        String strs = new BASE64Encoder().encode(bt);
        strs = strs.replaceAll("\\+", "-").replaceAll("\\/", "!");
        return filter(strs);
    }
 
    /**
     * Description 根据键值进行解密
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws IOException
     * @throws Exception
     */
    public static String decrypt(String data, String key) throws IOException,
            Exception {
        if (data == null)
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        data = data.replaceAll("-","\\+").replaceAll("!","\\/");
        byte[] buf = decoder.decodeBuffer(data);
        byte[] bt = decrypt(buf,key.getBytes("utf-8"));
        return new String(bt);
    }
 
    /**
     * Description 根据键值进行加密
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
 
        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
 
        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
 
        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(DES);
 
        // 用密钥初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
 
        return cipher.doFinal(data);
    }
     
     
    /**
     * Description 根据键值进行解密
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
 
        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
 
        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
 
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(DES);
 
        // 用密钥初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
 
        return cipher.doFinal(data);
    }
    
    /** 
     * 去掉字符串的换行符号 
     * base64编码3-DES的数据时，得到的字符串有换行符号 
     * ，一定要去掉，否则uni-wise平台解析票根不会成功，  
     * 提示“sp验证失败”。在开发的过程中，因为这个问题让我束手无策， 
     * 一个朋友告诉我可以问联通要一段加密后 的文字，然后去和自己生成的字符串比较， 
     * 这是个不错的调试方法。我最后比较发现我生成的字符串唯一不同的 是多了换行。 
     * 我用c#语言也写了票根请求程序，没有发现这个问题。  
     *  
         */  
      
	private static String filter(String str) {
		String output = null;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			int asc = str.charAt(i);
			if (asc != 10 && asc != 13)
				sb.append(str.subSequence(i, i + 1));
		}
		output = new String(sb).replaceAll(" ", "");
		return output;
	}
}
