package com.portal.entity;

import java.io.Serializable;

public class Book implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private long id;

  private int type;

  private long userId;

  private long objectId;

  private int status;

  private String createTime;

  private String updateTime;

  public String getCreateTime() {
    return createTime;
  }

  public long getId() {
    return id;
  }

  public long getObjectId() {
    return objectId;
  }

  public int getStatus() {
    return status;
  }

  public int getType() {
    return type;
  }

  public String getUpdateTime() {
    return updateTime;
  }

  public long getUserId() {
    return userId;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setObjectId(long objectId) {
    this.objectId = objectId;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public void setType(int type) {
    this.type = type;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

}
