package com.edison.restful.util;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Map;

/**
 * SignUtils class
 *
 */
public class SignUtils
{

    public static String sign(String appSecret, Map<String, String> form) throws Exception {
        return SignUtils.getSign(appSecret, form, form.get("signMethod"));
    }

    /**
     * 签名算法
     * @param appSecret  签名密钥
     * @param signMethod 签名方法
     * @return 签名
     */
    public static String getSign(String appSecret, Map<String, String> params, String signMethod) throws Exception { // 第一步：检查参数是否已经排序
        String[] keys = params.keySet().toArray(new String[0]);
        Arrays.sort(keys);
        // 第二步：把所有参数名和参数值串在一起
        StringBuilder signStr = new StringBuilder();
        for (String key : keys)
        {
            String value = params.get(key);
            if (value != null && !"".equals(value))
            {
                signStr.append(key).append("=").append(value).append("&");
            }
        }
        // 第三步：拼接签名密钥
        signStr.append("key=").append(appSecret);
        //GooagooLog.info("服务端的签名之前的字符串:" + signStr.toString());
        // 第四步：签名
        if ("MD5".equals(signMethod))
        {
            return getMD5(signStr.toString());
        }
        else
        {
            return getSHA(signStr.toString());
        }
    }

    /**
     * 签名算法
     * @return 签名
     */
    public static String getParamsStr(Map<String, String> params) throws Exception { // 第一步：检查参数是否已经排序
        String[] keys = params.keySet().toArray(new String[0]);
        Arrays.sort(keys);
        // 第二步：把所有参数名和参数值串在一起
        StringBuilder signStr = new StringBuilder();
        for (String key : keys)
        {
            String value = params.get(key);
            if (value != null && !"".equals(value))
            {
                signStr.append(key).append("=").append(value).append("&");
            }
        }
        return signStr.substring(0,signStr.lastIndexOf("&"));

    }

    /**
     * SHA加密
     * @param str 待加密数据
     * @return 加密后数据
     */
    public static String getSHA(String str) throws Exception {
        return encrypt(str, "SHA");
    }

    /**
     * MD5加密
     * @param str 待加密数据
     * @return 加密后数据
     */
    public static String getMD5(String str) throws Exception {
        return encrypt(str, "MD5");
    }

    /**
     * 加密方法
     * @param str 待加密数据
     * @param algorithm 加密类型 MD5，SHA
     * @return 加密后数据
     */
    private static String encrypt(String str, String algorithm) throws Exception {
        try
        {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(str.getBytes("UTF-8"));
            byte[] digest = md.digest();
            StringBuffer hexstr = new StringBuffer();
            String shaHex = "";
            for (int i = 0; i < digest.length; i++)
            {
                shaHex = Integer.toHexString(digest[i] & 0xFF);
                if (shaHex.length() < 2)
                {
                    hexstr.append(0);
                }
                hexstr.append(shaHex);
            }
            return hexstr.toString().toUpperCase();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new Exception(e);
        }
    }
}
