package com.portal.util;

import java.math.BigDecimal;

public class MathUtils {

  /**
   * 将strDecimal和n相除
   * 
   * @param strDecimal
   * @param n
   * @param scale
   * @param roundMethod 四舍五入模式
   * @return
   */
  public static float divide(long strDecimal, String n, int scale) {
    if (strDecimal == 0) {
      return 0l;
    }
    if (n == null || n.equals("")) {
      return 0l;
    }

    BigDecimal decimal1 = new BigDecimal(strDecimal);
    BigDecimal decimal2 = new BigDecimal(n);
    return decimal1.divide(decimal2, scale, BigDecimal.ROUND_HALF_UP).floatValue();
  }

  /**
   * 将strDecimal和n相除
   * 
   * @param strDecimal
   * @param n
   * @param scale 精度，保留scale位小数
   * @return strDecimal / n
   */
  public static float divide(String strDecimal, String n, int scale) {
    return divide(strDecimal, n, scale, BigDecimal.ROUND_HALF_UP);
  }

  /**
   * 将strDecimal和n相除
   * 
   * @param strDecimal
   * @param n
   * @param scale
   * @param roundMethod 四舍五入模式
   * @return
   */
  public static float divide(String strDecimal, String n, int scale, int roundMethod) {
    if (strDecimal == null || strDecimal.length() == 0) {
      return 0l;
    }

    BigDecimal decimal1 = new BigDecimal(strDecimal);
    BigDecimal decimal2 = new BigDecimal(n);
    return decimal1.divide(decimal2, scale, roundMethod).floatValue();
  }

  /**
   * 将strDecimal和n相除
   * 
   * @param strDecimal
   * @param n
   * @param scale
   * @param roundMethod 四舍五入模式
   * @return
   */
  public static String divideRetStr(long strDecimal, String n, int scale) {
    if (strDecimal == 0) {
      return "0.00";
    }
    if (n == null || n.equals("")) {
      return "0.00";
    }

    BigDecimal decimal1 = new BigDecimal(strDecimal);
    BigDecimal decimal2 = new BigDecimal(n);
    return decimal1.divide(decimal2, scale, BigDecimal.ROUND_HALF_UP).toString();
  }

  public static void main(String args[]) {
    boolean flag = MathUtils.validateCardNo("6225888822222222");
    System.out.println("flag =" + flag);
  }

  /**
   * 将strDecimal和n相乘
   * 
   * @param strDecimal
   * @param n
   * @return strDecimal * n
   */
  public static long multiply(String strDecimal, String n) {
    if (strDecimal == null || strDecimal.length() == 0) {
      return 0l;
    }

    BigDecimal decimal1 = new BigDecimal(strDecimal);
    BigDecimal decimal2 = new BigDecimal(n);
    return decimal1.multiply(decimal2).longValue();
  }

  public static boolean validateCardNo(String bankCode) {
    return bankCode.matches("^\\d{15,19}$");
  }

}
