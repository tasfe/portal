package com.portal.entity;

import java.io.Serializable;

public class Manager implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private long id;

  private String name;

  private String video;

  private String mobilePhone;

  private String email;

  private String intro;

  private String createTime;

  private String updateTime;

  private String nameCard;

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

  public long getId() {
    return id;
  }

  public String getIntro() {
    return intro;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getName() {
    return name;
  }

  public String getNameCard() {
    return nameCard;
  }

  public String getPwd() {
    return pwd;
  }

  public String getUpdateTime() {
    return updateTime;
  }

  public String getVideo() {
    return video;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setIntro(String intro) {
    this.intro = intro;
  }

  public void setMobilePHone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setNameCard(String nameCard) {
    this.nameCard = nameCard;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }

  public void setVideo(String video) {
    this.video = video;
  }

}
