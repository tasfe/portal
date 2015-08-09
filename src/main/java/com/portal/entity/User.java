package com.portal.entity;

import java.io.Serializable;

public class User implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -6295615441909870548L;

  private Long id;

  private String name;

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

}