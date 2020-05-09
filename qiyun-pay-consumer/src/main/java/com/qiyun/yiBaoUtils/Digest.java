/*
 * �������� 2004-12-5
 */
package com.qiyun.yiBaoUtils;

/**
 * hmac��ǩ���㷨
 * @author Ф�ٳ�	 2004-12-5
 */
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;


public class Digest
{
    public static final String ENCODE = "UTF-8";  //UTF-8
    
    /**
     * ֱ����MD5ǩ��������ǩ��������Ҫ��Կ
     * @param aValue
     * @return
     */
    public static String signMD5(String aValue,String encoding){
    	try {
			byte[] input = aValue.getBytes(encoding);
			MessageDigest md = MessageDigest.getInstance("MD5");
			return ConvertUtils.toHex(md.digest(input));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
    }
    /**
     * ֱ����MD5ǩ��������ǩ��������Ҫ��Կ
     * @param aValue
     * @return
     */
    public static String hmacSign(String aValue){
		try {
			byte[] input = aValue.getBytes();
			MessageDigest md = MessageDigest.getInstance("MD5");
			return ConvertUtils.toHex(md.digest(input));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
    }
    /**
     * �Ա��Ľ���hmacǩ�����ַ�������UTF-8����
     * @param aValue - �ַ���
     * @param aKey - ��Կ
     * @return - ǩ�������hex�ַ���
     */
    public static String hmacSign(String aValue, String aKey)
    {
    	return hmacSign(aValue,aKey,ENCODE);
    }
    
    /**
     * �Ա��Ľ��в���MD5����hmacǩ��
     * @param aValue - �ַ���
     * @param aKey - ��Կ
     * @param encoding - �ַ������뷽ʽ
     * @return - ǩ�������hex�ַ���
     */
    public static String hmacSign(String aValue, String aKey,String encoding)
    {
        byte k_ipad[] = new byte[64];
        byte k_opad[] = new byte[64];
        byte keyb[];
        byte value[];
        try
        {
            keyb = aKey.getBytes(encoding);
            value = aValue.getBytes(encoding);
        }
        catch(UnsupportedEncodingException e)
        {
            keyb = aKey.getBytes();
            value = aValue.getBytes();
        }
        Arrays.fill(k_ipad, keyb.length, 64, (byte)54);
        Arrays.fill(k_opad, keyb.length, 64, (byte)92);
        for(int i = 0; i < keyb.length; i++)
        {
            k_ipad[i] = (byte)(keyb[i] ^ 0x36);
            k_opad[i] = (byte)(keyb[i] ^ 0x5c);
        }

        MessageDigest md = null;
        try
        {
            md = MessageDigest.getInstance("MD5");
        }
        catch(NoSuchAlgorithmException e)
        {
        	e.printStackTrace();
            return null;
        }
        md.update(k_ipad);
        md.update(value);
        byte dg[] = md.digest();        
        md.reset();
        md.update(k_opad);
        md.update(dg, 0, 16);
        dg = md.digest();
        return ConvertUtils.toHex(dg);
    }
    
    /**
     * �Ա��Ľ��в���SHA����hmacǩ��
     * @param aValue - �ַ���
     * @param aKey - ��Կ
     * @param encoding - �ַ������뷽ʽ
     * @return - ǩ�������hex�ַ���
     */
   public static String hmacSHASign(String aValue, String aKey,String encoding)
    {
        byte k_ipad[] = new byte[64];
        byte k_opad[] = new byte[64];
        byte keyb[];
        byte value[];
        try
        {
            keyb = aKey.getBytes(encoding);
            value = aValue.getBytes(encoding);
        }
        catch(UnsupportedEncodingException e)
        {
            keyb = aKey.getBytes();
            value = aValue.getBytes();
        }
        Arrays.fill(k_ipad, keyb.length, 64, (byte)54);
        Arrays.fill(k_opad, keyb.length, 64, (byte)92);
        for(int i = 0; i < keyb.length; i++)
        {
            k_ipad[i] = (byte)(keyb[i] ^ 0x36);
            k_opad[i] = (byte)(keyb[i] ^ 0x5c);
        }

        MessageDigest md = null;
        try
        {
            md = MessageDigest.getInstance("SHA");
        }
        catch(NoSuchAlgorithmException e)
        {
        	e.printStackTrace();
            return null;
        }
        md.update(k_ipad);
        md.update(value);
        byte dg[] = md.digest();
        md.reset();
        md.update(k_opad);
        md.update(dg, 0, 20);
        dg = md.digest();
        return ConvertUtils.toHex(dg);
    }

   /**
    * �Ա��Ľ���SHAǩ��
    * @param aValue - ��ǩ�����ַ��������룺UTF-8��
    * @return - ǩ�������hex�ַ���
    */
    public static String digest(String aValue)
    {
    	return digest(aValue,ENCODE);
    	
    }
    
    /**
     * �Ա��Ľ���SHAǩ��
     * @param aValue - ��ǩ�����ַ���
     * @param encoding - �ַ������뷽ʽ
     * @return - ǩ�������hex�ַ���
     */
    public static String digest(String aValue,String encoding)
    {
        aValue = aValue.trim();
        byte value[];
        try
        {
            value = aValue.getBytes(encoding);
        }
        catch(UnsupportedEncodingException e)
        {
            value = aValue.getBytes();
        }
        MessageDigest md = null;
        try
        {
            md = MessageDigest.getInstance("SHA");
        }
        catch(NoSuchAlgorithmException e)
        {
        	e.printStackTrace();
            return null;
        }
        return ConvertUtils.toHex(md.digest(value));
    }
    
    /**
     * ���ַ�������ǩ��
     * @param aValue - ��ǩ���ַ���
     * @param alg - ǩ���㷨���ƣ���SHA, MD5�ȣ�
     * @param encoding - �ַ������뷽ʽ
     * @return - ǩ�������hex�ַ���
     */
    public static String digest(String aValue,String alg, String encoding)
    {
        aValue = aValue.trim();
        byte value[];
        try
        {
            value = aValue.getBytes(encoding);
        }
        catch(UnsupportedEncodingException e)
        {
            value = aValue.getBytes();
        }
        MessageDigest md = null;
        try
        {
            md = MessageDigest.getInstance(alg);
        }
        catch(NoSuchAlgorithmException e)
        {
        	e.printStackTrace();
            return null;
        }
        return ConvertUtils.toHex(md.digest(value));
    }
    
    public static String udpSign(String aValue){
		try {
			byte[] input = aValue.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("SHA1");
			return new String(Base64.encode(md.digest(input)), ENCODE);
		} catch (Exception e) {
			return null;
		}
    }

}
