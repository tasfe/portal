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
import com.portal.entity.Manager;
import com.portal.entity.Trust;
import com.portal.service.IAccountService;
import com.portal.service.ICustomerService;
import com.portal.service.IManagerService;
import com.portal.service.ITrustService;
import com.portal.service.IUserService;

@Controller
@RequestMapping("/trust")
public class TrustController {

  private final Logger logger = Logger.getLogger(TrustController.class);

  @Autowired
  IUserService userService;

  @Autowired
  ICustomerService customerService;

  @Autowired
  IAccountService accountService;

  @Autowired
  ITrustService trustService;

  @Autowired
  IManagerService managerService;

  /**
   * 新建信托
   * 
   * @param request
   * @param customer
   * @return
   * @throws JSONException
   * @throws JsonProcessingException
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  @ResponseBody
  public String create(HttpServletRequest request, @RequestBody Trust trust) throws JSONException, JsonProcessingException {
    logger.info("create asset  ");
    JSONObject result = new JSONObject();
    try {
      Subject cUser = SecurityUtils.getSubject();
      if (cUser.isAuthenticated()) {

        Manager manager = managerService.findByPhone(String.valueOf(cUser.getPrincipal()));

        if (manager != null) {
          String date = DateUtil.format(new Date(), null);
          trust.setBookCount(0);
          trust.setCreateBy(manager.getId());
          trust.setCreateTime(date);
          trust.setDonated("0");
          trust.setFavCount(0);
          trust.setStatus(ProductStatus.ING);
          trust.setUpdateTime(date);
          trustService.create(trust);

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
          trustService.delete(id);

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
  public String trust(HttpServletRequest request, @PathVariable("id") Long id) throws JSONException, JsonProcessingException {
    logger.info("search donation ");
    JSONObject result = new JSONObject();
    try {
      if (id != null && id.longValue() > 0) {
        result.put("success", true);
        result.put("data", trustService.findOne(id));
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

  /**
   * 资产管理查询
   * 
   * @param request
   * @param customer
   * @return
   * @throws JSONException
   * @throws JsonProcessingException
   */
  @RequestMapping(value = "/update", method = RequestMethod.POST)
  @ResponseBody
  public String update(HttpServletRequest request, @RequestBody Trust trust) throws JSONException, JsonProcessingException {
    logger.info("update asset  ");
    JSONObject result = new JSONObject();
    try {
      Subject cUser = SecurityUtils.getSubject();
      if (cUser.isAuthenticated()) {

        Manager manager = managerService.findByPhone(String.valueOf(cUser.getPrincipal()));

        if (manager != null) {
          Trust t = trustService.findOne(trust.getId());
          if (t != null) {
            t.setBonusPeriod(trust.getBonusPeriod());
            t.setBookCount(trust.getBookCount());
            t.setBuynumbers(trust.getBuynumbers());
            t.setCollectdes(trust.getCollectdes());
            t.setCollectpregress(trust.getCollectpregress());
            t.setCommissions(trust.getCommissions());
            t.setDesc(trust.getDesc());
            t.setDonated(trust.getDonated());
            t.setEndTime(trust.getEndTime());
            t.setIncomeratios(trust.getIncomeratios());
            t.setIsshow(trust.getIsshow());
            t.setIssuer(trust.getIssuer());
            t.setManagename(trust.getManagename());
            t.setName(trust.getName());
            t.setPaytype(trust.getPaytype());
            t.setPeriod(trust.getPeriod());
            t.setPest(trust.getPest());
            t.setPhoto(trust.getPhoto());
            t.setProintro(trust.getProintro());
            t.setRatiosize(trust.getRatiosize());
            t.setRelatedoc(trust.getRelatedoc());
            t.setStatus(trust.getStatus());
            t.setThreshold(trust.getThreshold());
            t.setTinyint(trust.getTinyint());
            t.setTotal(trust.getTotal());

            t.setUpdateTime(DateUtil.format(new Date(), null));
            trustService.update(t);
            result.put("success", true);
            result.put("msg", "操作成功");
          } else {
            result.put("success", false);
            result.put("msg", "数据不正确");
          }

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

}
