package com.portal.entity;

import java.io.Serializable;

public class Trust implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private long id;

  private String createTime;

  private String updateTime;

  private String name;

  private String period;

  private String total;

  private String bonusPeriod;

  private String endTime;

  private String completeTime;

  private String donated;

  private String desc;

  private int tinyint;

  private long createBy;

  private String photo;

  private long bookCount;

  private int status;

  private long favCount;

  /**
   * 是否显示 0 显示 1 不显示
   * 
   * 
   */
  private int isshow;

  private double threshold;

  private String issuer;

  private int paytype;

  private int pest;

  private int ratiosize;

  private String buynumbers;

  private double collectpregress;

  private String collectdes;

  private String incomeratios;

  private String commissions;

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

  public String getCollectdes() {
    return collectdes;
  }

  public double getCollectpregress() {
    return collectpregress;
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

  public long getId() {
    return id;
  }

  public String getIncomeratios() {
    return incomeratios;
  }

  public int getIsshow() {
    return isshow;
  }

  public String getIssuer() {
    return issuer;
  }

  public String getManagename() {
    return managename;
  }

  public String getName() {
    return name;
  }

  public int getPaytype() {
    return paytype;
  }

  public String getPeriod() {
    return period;
  }

  public int getPest() {
    return pest;
  }

  public String getPhoto() {
    return photo;
  }

  public String getProintro() {
    return prointro;
  }

  public int getRatiosize() {
    return ratiosize;
  }

  public String getRelatedoc() {
    return relatedoc;
  }

  public int getStatus() {
    return status;
  }

  public double getThreshold() {
    return threshold;
  }

  public int getTinyint() {
    return tinyint;
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

  public void setCollectdes(String collectdes) {
    this.collectdes = collectdes;
  }

  public void setCollectpregress(double collectpregress) {
    this.collectpregress = collectpregress;
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

  public void setId(long id) {
    this.id = id;
  }

  public void setIncomeratios(String incomeratios) {
    this.incomeratios = incomeratios;
  }

  public void setIsshow(int isshow) {
    this.isshow = isshow;
  }

  public void setIssuer(String issuer) {
    this.issuer = issuer;
  }

  public void setManagename(String managename) {
    this.managename = managename;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPaytype(int paytype) {
    this.paytype = paytype;
  }

  public void setPeriod(String period) {
    this.period = period;
  }

  public void setPest(int pest) {
    this.pest = pest;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public void setProintro(String prointro) {
    this.prointro = prointro;
  }

  public void setRatiosize(int ratiosize) {
    this.ratiosize = ratiosize;
  }

  public void setRelatedoc(String relatedoc) {
    this.relatedoc = relatedoc;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public void setThreshold(double threshold) {
    this.threshold = threshold;
  }

  public void setTinyint(int tinyint) {
    this.tinyint = tinyint;
  }

  public void setTotal(String total) {
    this.total = total;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }

}
