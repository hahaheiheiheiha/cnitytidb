package cn.project.springbootcurrency.vo;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.util.Random;

public class MyMD5Util {
    /**
     * 普通MD5
     *
     * @param password
     * @return
     *
     */
    public static String MD5(String password){
        MessageDigest md5 =null;
        try{
            md5=MessageDigest.getInstance("MD5");

        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
        char[] charArray =password.toCharArray();
        byte[] byteArray = new byte[charArray.length];
        for(int i=0;i<charArray.length;i++){
            byteArray[i]=(byte)charArray[i];
        }
        byte[] md5Bytes =md5.digest(byteArray);
        StringBuffer haxValue = new StringBuffer();
        for(int i =0;i<md5Bytes.length;i++){
            int val= ((int)md5Bytes[i]) & 0xff;
            if(val<16){
                haxValue.append("0");
            }
            haxValue.append(Integer.toHexString(val));
        }
        return haxValue.toString();
    }
    /**
     * 加盐MD5
     *
     * @param password
     * @return
     * @author
     */
    public static String MD5Salt(String password) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder(16);
        sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));
        int len = sb.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sb.append("0");
            }
        }
        String salt = sb.toString();
        password = md5Hex(password + salt);
        char[] cs = new char[48];
        for (int i = 0; i < 48; i += 3) {
            cs[i] = password.charAt(i / 3 * 2);
            char c = salt.charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = password.charAt(i / 3 * 2 + 1);
        }
        return new String(cs);
    }
    /**
     * 校验加盐后是否和原文一致
     *
     * @param password
     * @param md5
     * @return
     * @author
     */
    public static boolean verify(String password, String md5) {
        char[] cs1 = new char[32];
        char[] cs2 = new char[16];
        for (int i = 0; i < 32; i += 3) {
            cs1[i / 3 * 2] = md5.charAt(i);
            cs1[i / 3 * 2 + 1] = md5.charAt(i + 2);
            cs2[i / 3] = md5.charAt(i + 1);
        }
        String salt = new String(cs2);
        return md5Hex(password + salt).equals(new String(cs1));
    }
    /**
     * 获取十六进制字符串形式的MD5摘要
     */
    private static String md5Hex(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(src.getBytes());
            return new String(new Hex().encode(bs));
        } catch (Exception e) {
            return null;
        }
    }
}
