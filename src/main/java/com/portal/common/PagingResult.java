package com.portal.common;

import java.util.ArrayList;
import java.util.List;

public class PagingResult<T> {
  // 当前页
  private int currentPage;
  // 页面大小
  private int pageSize;
  // 总共记录条数
  private long totalSize;
  // 结果集
  private List<T> resultList = new ArrayList<T>();

  public int getCurrentPage() {
    return currentPage;
  }

  public int getPageSize() {
    return pageSize;
  }

  public List<T> getResultList() {
    return resultList;
  }

  public long getTotalSize() {
    return totalSize;
  }

  public void setCurrentPage(int currentPage) {
    this.currentPage = currentPage;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public void setResultList(List<T> resultList) {
    this.resultList = resultList;
  }

  public void setTotalSize(long totalSize) {
    this.totalSize = totalSize;
  }

}
