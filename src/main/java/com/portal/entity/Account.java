package com.portal.entity;

import java.io.Serializable;

public class Account implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private long id;

  private String userName;

  private long userId;

  private int userType;

  private String pwd;

  private String createTime;

  private String updateTime;

  private String mobilePhone;

  public String getCreateTime() {
    return createTime;
  }

  public long getId() {
    return id;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getPwd() {
    return pwd;
  }

  public String getUpdateTime() {
    return updateTime;
  }

  public long getUserId() {
    return userId;
  }

  public String getUserName() {
    return userName;
  }

  public int getUserType() {
    return userType;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setUserType(int userType) {
    this.userType = userType;
  }

}
