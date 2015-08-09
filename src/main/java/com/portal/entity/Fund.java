package com.portal.entity;

import java.io.Serializable;

public class Fund implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private long id;

  private String name;

  private long createBy;

  private String photo;

  private long bookCount;

  private long favCount;

  private double threshold;

  private String createTime;

  private String updateTime;

  private String endTime;

  private String completeTime;

  private String donated;

  private String desc;

  private String total;

  private String period;

  private String bonusPeriod;

  private int status;

  /**
   * 是否显示 0 显示 1 不显示
   */
  private int isshow;

  private String foundedTime;

  private String fundcompany;

  private int protype;

  private int strategy;

  private String buynumbers;

  private String incomeratios;

  private String commissions;

  private String openday;

  private String comment;

  private String relatedoc;

  private String managename;

  private String prointro;

  public String getBonusPeriod() {
    return bonusPeriod;
  }

  public long getBookCount() {
    return bookCount;
  }

  public String getBuynumbers() {
    return buynumbers;
  }

  public String getComment() {
    return comment;
  }

  public String getCommissions() {
    return commissions;
  }

  public String getCompleteTime() {
    return completeTime;
  }

  public long getCreateBy() {
    return createBy;
  }

  public String getCreateTime() {
    return createTime;
  }

  public String getDesc() {
    return desc;
  }

  public String getDonated() {
    return donated;
  }

  public String getEndTime() {
    return endTime;
  }

  public long getFavCount() {
    return favCount;
  }

  public String getFoundedTime() {
    return foundedTime;
  }

  public String getFundcompany() {
    return fundcompany;
  }

  public long getId() {
    return id;
  }

  public String getIncomeratios() {
    return incomeratios;
  }

  public int getIsshow() {
    return isshow;
  }

  public String getManagename() {
    return managename;
  }

  public String getName() {
    return name;
  }

  public String getOpenday() {
    return openday;
  }

  public String getPeriod() {
    return period;
  }

  public String getPhoto() {
    return photo;
  }

  public String getProintro() {
    return prointro;
  }

  public int getProtype() {
    return protype;
  }

  public String getRelatedoc() {
    return relatedoc;
  }

  public int getStatus() {
    return status;
  }

  public int getStrategy() {
    return strategy;
  }

  public double getThreshold() {
    return threshold;
  }

  public String getTotal() {
    return total;
  }

  public String getUpdateTime() {
    return updateTime;
  }

  public void setBonusPeriod(String bonusPeriod) {
    this.bonusPeriod = bonusPeriod;
  }

  public void setBookCount(long bookCount) {
    this.bookCount = bookCount;
  }

  public void setBuynumbers(String buynumbers) {
    this.buynumbers = buynumbers;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public void setCommissions(String commissions) {
    this.commissions = commissions;
  }

  public void setCompleteTime(String completeTime) {
    this.completeTime = completeTime;
  }

  public void setCreateBy(long createBy) {
    this.createBy = createBy;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public void setDonated(String donated) {
    this.donated = donated;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public void setFavCount(long favCount) {
    this.favCount = favCount;
  }

  public void setFoundedTime(String foundedTime) {
    this.foundedTime = foundedTime;
  }

  public void setFundcompany(String fundcompany) {
    this.fundcompany = fundcompany;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setIncomeratios(String incomeratios) {
    this.incomeratios = incomeratios;
  }

  public void setIsshow(int isshow) {
    this.isshow = isshow;
  }

  public void setManagename(String managename) {
    this.managename = managename;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setOpenday(String openday) {
    this.openday = openday;
  }

  public void setPeriod(String period) {
    this.period = period;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public void setProintro(String prointro) {
    this.prointro = prointro;
  }

  public void setProtype(int protype) {
    this.protype = protype;
  }

  public void setRelatedoc(String relatedoc) {
    this.relatedoc = relatedoc;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public void setStrategy(int strategy) {
    this.strategy = strategy;
  }

  public void setThreshold(double threshold) {
    this.threshold = threshold;
  }

  public void setTotal(String total) {
    this.total = total;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }

}
