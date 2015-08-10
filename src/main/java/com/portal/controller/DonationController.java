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
import com.portal.entity.Asset;
import com.portal.entity.Donation;
import com.portal.entity.Manager;
import com.portal.service.IAccountService;
import com.portal.service.ICustomerService;
import com.portal.service.IDonationService;
import com.portal.service.IManagerService;
import com.portal.service.IUserService;

@Controller
@RequestMapping("/donation")
public class DonationController {

  private final Logger logger = Logger.getLogger(DonationController.class);

  @Autowired
  IUserService userService;

  @Autowired
  ICustomerService customerService;

  @Autowired
  IAccountService accountService;

  @Autowired
  IDonationService donationService;

  @Autowired
  IManagerService managerService;

  /**
   * 新建私募
   * 
   * @param request
   * @param customer
   * @return
   * @throws JSONException
   * @throws JsonProcessingException
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  @ResponseBody
  public String create(HttpServletRequest request, @RequestBody Donation donation) throws JSONException, JsonProcessingException {
    logger.info("create asset  ");
    JSONObject result = new JSONObject();
    try {
      Subject cUser = SecurityUtils.getSubject();
      if (cUser.isAuthenticated()) {

        Manager manager = managerService.findByPhone(String.valueOf(cUser.getPrincipal()));

        if (manager != null) {
          String date = DateUtil.format(new Date(), null);
          donation.setBookCount(0);
          donation.setCreateBy(manager.getId());
          donation.setCreateTime(date);
          donation.setDonated("0");
          donation.setFavCount(0);
          donation.setStatus(ProductStatus.ING);
          donation.setUpdateTime(date);
          donationService.create(donation);

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
          donationService.delete(id);

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
   * @param request·
   * @param customer
   * @return
   * @throws JSONException
   * @throws JsonProcessingException
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  @ResponseBody
  public String donation(HttpServletRequest request, @PathVariable("id") Long id) throws JSONException, JsonProcessingException {
    logger.info("search donation ");
    JSONObject result = new JSONObject();
    try {
      if (id != null && id.longValue() > 0) {
        result.put("success", true);
        result.put("data", donationService.findOne(id));
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
  public String update(HttpServletRequest request, @RequestBody Donation donation) throws JSONException, JsonProcessingException {
    logger.info("update asset  ");
    JSONObject result = new JSONObject();
    try {
      Subject cUser = SecurityUtils.getSubject();
      if (cUser.isAuthenticated()) {

        Manager manager = managerService.findByPhone(String.valueOf(cUser.getPrincipal()));

        if (manager != null) {
          Donation d = donationService.findOne(donation.getId());
          if (d != null) {
            d.setBonusPeriod(donation.getBonusPeriod());
            d.setBookCount(donation.getBookCount());
            d.setBuynumbers(donation.getBuynumbers());
            d.setComment(donation.getComment());
            d.setCommissions(donation.getCommissions());
            d.setDesc(donation.getDesc());
            d.setDonated(donation.getDonated());
            d.setEndTime(donation.getEndTime());
            d.setFoundedTime(donation.getFoundedTime());
            d.setFundcompany(donation.getFundcompany());
            d.setIncomeratios(donation.getIncomeratios());
            d.setIsshow(donation.getIsshow());
            d.setManagename(donation.getManagename());
            d.setName(donation.getName());
            d.setOpenday(donation.getOpenday());
            d.setPeriod(donation.getPeriod());
            d.setPhoto(donation.getPhoto());
            d.setProintro(donation.getProintro());
            d.setProtype(donation.getProtype());
            d.setRelatedoc(donation.getRelatedoc());
            d.setStatus(donation.getStatus());
            d.setStrategy(donation.getStrategy());
            d.setThreshold(donation.getThreshold());
            d.setTotal(donation.getTotal());
            d.setUpdateTime(DateUtil.format(new Date(), null));
            donationService.update(d);
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
