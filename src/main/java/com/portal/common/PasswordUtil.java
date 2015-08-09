package com.portal.common;

/**
 * 好贷宝平台迁入代码 密码生成和解析封装
 * 
 * @author zyc
 * @date 2015年3月31日
 */
public class PasswordUtil {
  public static final String HASH_ALGORITHM = "SHA-1";
  public static final int HASH_INTERATIONS = 1024;
  public static final int SALT_SIZE = 8;

  /**
   * 生成密码
   * 
   * @param plainPassword
   * @return
   */
  public static String entryptPassword(String plainPassword) {
    byte[] salt = Digests.generateSalt(SALT_SIZE);
    byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt, HASH_INTERATIONS);
    return Encodes.encodeHex(salt) + Encodes.encodeHex(hashPassword);
  }

  public static void main(String[] args) {
    System.out.println(entryptPassword("123456"));
  }

  /**
   * 验证member的pwd和tpwd
   * 
   * @param plainPassword
   * @param password
   * @return
   */
  public static boolean validateMemberPassword(String plainPassword, String pwd, String tPwd, String tSalt) {
    // Security s = new Security();
    // if (StringUtils.isBlank(pwd) && StringUtils.isBlank(tPwd)) {
    // throw new RuntimeException("data error pwd tpwd is null");
    // }
    // if (StringUtils.isNotBlank(pwd) && StringUtils.isBlank(tPwd)) {
    // if (!PasswordUtil.validatePassword(plainPassword, pwd)) {
    // return false;
    // }
    // }
    // if (StringUtils.isNotBlank(tPwd) && StringUtils.isBlank(pwd)) {
    // if (!s.validatePassword(plainPassword, tPwd, tSalt)) {
    // return false;
    // }
    // }
    // if (StringUtils.isNotBlank(tPwd) && StringUtils.isNotBlank(pwd)) {
    // if (!PasswordUtil.validatePassword(plainPassword, pwd) && !s.validatePassword(plainPassword,
    // tPwd, tSalt)) {
    // return false;
    // }
    // }
    return true;
  }

  /**
   * 验证密码
   * 
   * @param plainPassword 明文密码
   * @param password 密文密码
   * @return 验证成功返回true
   */
  public static boolean validatePassword(String plainPassword, String password) {

    if (password != null && password.length() >= 16) {
      byte[] salt = Encodes.decodeHex(password.substring(0, 16));
      byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt, HASH_INTERATIONS);
      return password.equals(Encodes.encodeHex(salt) + Encodes.encodeHex(hashPassword));
    } else {
      return false;
    }
  }
}
