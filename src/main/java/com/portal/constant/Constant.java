package com.portal.constant;

public class Constant {

  public class AccountType {
    public static final int MANAGER = 0;
    public static final int CUSTOMER = 1;
  }

  /**
   * 预约状态
   */
  public class BookStatus {
    public static final int SUCCESS = 0;
    public static final int FAILURE = 1;
  }

  /**
   * 收藏对象
   * 
   * @author poppet
   * 
   */
  public class ObjectType {
    public static final int MANAGER = 0;
    public static final int DONATION = 1;
    public static final int ASSET = 2;
    public static final int TRUST = 3;
    public static final int FUND = 4;
  }

  /**
   * 产品状态 0未开始1进行中2已完成
   */
  public class ProductStatus {
    public static final int INIT = 0;
    public static final int ING = 1;
    public static final int COMPLETED = 2;
  }
}
