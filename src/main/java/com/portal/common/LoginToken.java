package com.portal.common;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;

public class LoginToken extends UsernamePasswordToken implements AuthenticationToken {

  /**
   * 
   */
  private static final long serialVersionUID = 638125069613255274L;

  private String username;

  private String pwd;

  private String sessionId;

  private int accountType;

  public LoginToken(String username, String password, String sessionId, int accountType) {
    super();
    this.username = username;
    this.pwd = password;
    this.sessionId = sessionId;
    this.accountType = accountType;
  }

  public int getAccountType() {
    return accountType;
  }

  @Override
  public Object getCredentials() {
    // TODO Auto-generated method stub
    return getPwd();
  }

  @Override
  public Object getPrincipal() {
    // TODO Auto-generated method stub
    return getUsername();
  }

  public String getPwd() {
    return pwd;
  }

  public String getSessionId() {
    return sessionId;
  }

  public String getUsername() {
    return username;
  }

  public void setAccountType(int accountType) {
    this.accountType = accountType;
  }

  public void setPassword(String password) {
    this.pwd = password;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }

  public void setUsername(String username) {
    this.username = username;
  }

}
