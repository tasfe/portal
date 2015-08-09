package com.portal.controller;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.portal.common.LoginToken;
import com.portal.common.PwdUtil;
import com.portal.constant.Constant.AccountType;
import com.portal.entity.Account;
import com.portal.entity.User;
import com.portal.service.IUserService;

@Controller
@RequestMapping("/login")
public class LoginController {

  private final Logger logger = Logger.getLogger(LoginController.class);

  @Autowired
  IUserService userService;

  @RequestMapping(value = "/customer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public String customer(HttpServletRequest request, @RequestBody Account account) throws JSONException, JsonProcessingException {

    LoginToken token = new LoginToken(account.getMobilePhone(), PwdUtil.encypt(account.getPwd()), "", AccountType.CUSTOMER);
    token.setRememberMe(true);
    Subject cUser = SecurityUtils.getSubject();
    JSONObject result = new JSONObject();
    if (!cUser.isAuthenticated()) {
      User loginUser;
      try {
        cUser.login(token);
      } catch (UnknownAccountException e) {
        result.put("success", false);
        result.put("msg", "用户名或者密码错误");
        token.clear();
        return result.toString();

      } catch (IncorrectCredentialsException ice) {
        result.put("success", false);
        result.put("msg", "密码错误");
        token.clear();
        return result.toString();
      }
      // return info to client if login success but imei don't match it's original one
    }
    result.put("success", true);
    result.put("msg", "登录成功");
    return result.toString();
  }

  @RequestMapping(value = "/manager", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public String manager(HttpServletRequest request, @RequestBody Account account) throws JSONException, JsonProcessingException {

    LoginToken token = new LoginToken(account.getMobilePhone(), PwdUtil.encypt(account.getPwd()), "", AccountType.MANAGER);
    token.setRememberMe(true);
    Subject cUser = SecurityUtils.getSubject();
    JSONObject result = new JSONObject();
    if (!cUser.isAuthenticated()) {
      User loginUser;
      try {
        cUser.login(token);
      } catch (UnknownAccountException e) {
        result.put("success", false);
        result.put("msg", "用户名或者密码错误");
        token.clear();
        return result.toString();

      } catch (IncorrectCredentialsException ice) {
        result.put("success", false);
        result.put("msg", "密码错误");
        token.clear();
        return result.toString();
      }
      // return info to client if login success but imei don't match it's original one
    }

    result.put("success", true);
    result.put("msg", "登录成功");
    return result.toString();
  }

  @RequestMapping(value = "/test", method = RequestMethod.GET)
  @ResponseBody
  public String test(HttpServletRequest request) throws JSONException, JsonProcessingException {

    JSONObject result = new JSONObject();

    result.put("success", true);
    result.put("msg", "登录成功");
    return result.toString();
  }

}
