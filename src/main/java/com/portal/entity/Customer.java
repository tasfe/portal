package com.portal.entity;

import java.io.Serializable;

public class Customer implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private String idCardNumber;

  private long id;

  private String name;

  private String mobilePhone;

  private String email;

  private int gender;

  private String createTime;

  private String updateTime;

  /**
   * transient field
   * 
   */
  private String pwd;

  public String getCreateTime() {
    return createTime;
  }

  public String getEmail() {
    return email;
  }

  public int getGender() {
    return gender;
  }

  public long getId() {
    return id;
  }

  public String getIdCardNumber() {
    return idCardNumber;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getName() {
    return name;
  }

  public String getPwd() {
    return pwd;
  }

  public String getUpdateTime() {
    return updateTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setGender(int gender) {
    this.gender = gender;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setIdCardNumber(String idCardNumber) {
    this.idCardNumber = idCardNumber;
  }

  public void setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }

}
