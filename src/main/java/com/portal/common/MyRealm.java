package com.portal.common;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.portal.entity.Account;
import com.portal.service.IAccountService;

public class MyRealm extends AuthorizingRealm {

  @Autowired
  private IAccountService accountService;

  public IAccountService getAccountService() {
    return accountService;
  }

  public void setAccountService(IAccountService accountService) {
    this.accountService = accountService;
  }

  /**
   * 认证信息
   */
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
    LoginToken token = (LoginToken) authcToken;
    String mobilePhone = token.getUsername();
    if (mobilePhone != null && !"".equals(mobilePhone)) {
      Account account = accountService.findByPhoneAndType(mobilePhone, token.getAccountType());
      if (account != null) {
        if (account.getPwd().equals(token.getPwd())) {
          return new SimpleAuthenticationInfo(account.getMobilePhone(), account.getPwd(), getName());

        } else {
          throw new IncorrectCredentialsException();
        }
        // System.out.println("user name is :" + account.getMobilePhone());
      } else {
        System.out.println("user [" + mobilePhone + "] doesn't exist");
        throw new UnknownAccountException();
      }
    } else {
      throw new UnknownAccountException();
    }

  }

  /**
   * 授权信息
   */
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    if (principals == null) {
      throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
    }
    return null;
  }

}