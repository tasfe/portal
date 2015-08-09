package com.portal.util;

import java.io.UnsupportedEncodingException;

import org.springframework.util.DigestUtils;

/**
 * 
 * @author chenhao 加密工具类
 * 
 */
public class Digests {

  /**
   * 对字符串进行MD5加密
   * 
   * @throws UnsupportedEncodingException
   */
  public static String md5(String source) throws UnsupportedEncodingException {
    return DigestUtils.md5DigestAsHex((source.getBytes("UTF-8")));
  }
}
