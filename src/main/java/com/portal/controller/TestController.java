package com.portal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.portal.entity.Account;
import com.portal.service.IAccountService;

@Controller
@RequestMapping("/test")
public class TestController {

  @Autowired
  IAccountService accountService;

  @RequestMapping(value = "/createAccount", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public String createAccount(HttpServletRequest request, @RequestBody Account account) {
    accountService.create(account);
    System.out.println(account.getUserName());
    return "";
  }

}