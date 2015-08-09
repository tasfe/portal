package com.portal.common;

import java.util.Map;

public class PageEntity {
  private Integer page; // 目前是第几页
  private Integer size; // 每页大小
  private Map<String, Object> params; // 传入的参数
  private String orderStr; // 排序语句 column1 asc, column2 desc;

  public String getOrderStr() {
    return orderStr;
  }

  public Integer getPage() {
    return page;
  }

  public Map<String, Object> getParams() {
    return params;
  }

  public Integer getSize() {
    return size;
  }

  public void setOrderStr(String orderStr) {
    this.orderStr = orderStr;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public void setParams(Map<String, Object> params) {
    this.params = params;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

}
