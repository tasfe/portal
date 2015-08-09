package com.portal.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.portal.common.DateUtil;
import com.portal.constant.Constant.ProductStatus;
import com.portal.entity.Fund;
import com.portal.entity.Manager;
import com.portal.service.IAccountService;
import com.portal.service.ICustomerService;
import com.portal.service.IFundService;
import com.portal.service.IManagerService;
import com.portal.service.IUserService;

@Controller
@RequestMapping("/fund")
public class FundController {

  private final Logger logger = Logger.getLogger(FundController.class);

  @Autowired
  IUserService userService;

  @Autowired
  ICustomerService customerService;

  @Autowired
  IAccountService accountService;

  @Autowired
  IFundService fundService;

  @Autowired
  IManagerService managerService;

  /**
   * 新建基金
   * 
   * @param request
   * @param customer
   * @return
   * @throws JSONException
   * @throws JsonProcessingException
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  @ResponseBody
  public String create(HttpServletRequest request, @RequestBody Fund fund) throws JSONException, JsonProcessingException {
    logger.info("create asset  ");
    JSONObject result = new JSONObject();
    try {
      Subject cUser = SecurityUtils.getSubject();
      if (cUser.isAuthenticated()) {

        Manager manager = managerService.findByPhone(String.valueOf(cUser.getPrincipal()));

        if (manager != null) {
          String date = DateUtil.format(new Date(), null);
          fund.setBookCount(0);
          fund.setCreateBy(manager.getId());
          fund.setCreateTime(date);
          fund.setDonated("0");
          fund.setFavCount(0);
          fund.setStatus(ProductStatus.ING);
          fund.setUpdateTime(date);
          fundService.create(fund);

          result.put("success", true);
          result.put("msg", "创建成功");
        } else {
          result.put("success", false);
          result.put("msg", "用户信息错误");
        }

      } else {
        result.put("success", false);
        result.put("msg", "请您先登录");
      }

    } catch (Exception e) {
      e.printStackTrace();
      result.put("success", false);
      result.put("msg", "发生错误");
    }

    return result.toString();
  }

  /**
   * 新建私募
   * 
   * @param request
   * @param customer
   * @return
   * @throws JSONException
   * @throws JsonProcessingException
   */
  @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
  @ResponseBody
  public String delete(HttpServletRequest request, @PathVariable("id") String id) throws JSONException, JsonProcessingException {
    logger.info("create asset  ");
    JSONObject result = new JSONObject();
    try {
      Subject cUser = SecurityUtils.getSubject();
      if (cUser.isAuthenticated()) {

        Manager manager = managerService.findByPhone(String.valueOf(cUser.getPrincipal()));

        if (manager != null) {
          fundService.delete(id);

          result.put("success", true);
          result.put("msg", "操作成功");
        } else {
          result.put("success", false);
          result.put("msg", "用户信息错误");
        }

      } else {
        result.put("success", false);
        result.put("msg", "请您先登录");
      }

    } catch (Exception e) {
      e.printStackTrace();
      result.put("success", false);
      result.put("msg", "发生错误");
    }

    return result.toString();
  }

  /**
   * 资产管理查询
   * 
   * @param request
   * @param customer
   * @return
   * @throws JSONException
   * @throws JsonProcessingException
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  @ResponseBody
  public String fund(HttpServletRequest request, @PathVariable("id") Long id) throws JSONException, JsonProcessingException {
    logger.info("search donation ");
    JSONObject result = new JSONObject();
    try {
      if (id != null && id.longValue() > 0) {
        result.put("success", true);
        result.put("fund", fundService.findOne(id));
      } else {
        result.put("success", false);
        result.put("msg", "产品信息不正确");
      }
    } catch (Exception e) {
      result.put("success", false);
      result.put("msg", "发生错误");
    }

    return result.toString();
  }

}
