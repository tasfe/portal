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
import com.portal.entity.Manager;
import com.portal.service.IAccountService;
import com.portal.service.IAssetService;
import com.portal.service.ICustomerService;
import com.portal.service.IManagerService;
import com.portal.service.IUserService;

@Controller
@RequestMapping("/asset")
public class AssetController {

  private final Logger logger = Logger.getLogger(AssetController.class);

  @Autowired
  IUserService userService;

  @Autowired
  ICustomerService customerService;

  @Autowired
  IAccountService accountService;

  @Autowired
  IAssetService assetService;

  @Autowired
  IManagerService managerService;

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
  public String asset(HttpServletRequest request, @PathVariable("id") Long id) throws JSONException, JsonProcessingException {
    logger.info("search donation ");
    JSONObject result = new JSONObject();
    try {
      if (id != null && id.longValue() > 0) {
        result.put("success", true);
        result.put("data", assetService.findOne(id));
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
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  @ResponseBody
  public String create(HttpServletRequest request, @RequestBody Asset asset) throws JSONException, JsonProcessingException {
    logger.info("create asset  ");
    JSONObject result = new JSONObject();
    try {
      Subject cUser = SecurityUtils.getSubject();
      if (cUser.isAuthenticated()) {

        Manager manager = managerService.findByPhone(String.valueOf(cUser.getPrincipal()));

        if (manager != null) {
          String date = DateUtil.format(new Date(), null);
          asset.setBookCount(0);
          asset.setCreateBy(manager.getId());
          asset.setCreateTime(date);
          asset.setDonated("0");
          asset.setFavCount(0);
          asset.setUpdateTime(date);
          asset.setStatus(ProductStatus.ING);
          assetService.create(asset);
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
   * 删除私募
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
          assetService.delete(id);

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
  @RequestMapping(value = "/update", method = RequestMethod.POST)
  @ResponseBody
  public String update(HttpServletRequest request, @RequestBody Asset asset) throws JSONException, JsonProcessingException {
    logger.info("update asset  ");
    JSONObject result = new JSONObject();
    try {
      Subject cUser = SecurityUtils.getSubject();
      if (cUser.isAuthenticated()) {

        Manager manager = managerService.findByPhone(String.valueOf(cUser.getPrincipal()));

        if (manager != null) {
          Asset a = assetService.findOne(asset.getId());
          if (a != null) {
            a.setBonusPeriod(asset.getBonusPeriod());
            a.setBookCount(asset.getBookCount());
            a.setBuynumbers(asset.getBuynumbers());
            a.setCollectdes(asset.getCollectdes());
            a.setCollectpregress(asset.getCollectpregress());
            a.setCommissions(asset.getCommissions());
            a.setCompleteTime(asset.getCompleteTime());
            a.setDesc(asset.getDesc());
            a.setDonated(asset.getDonated());
            a.setEndTime(asset.getEndTime());
            a.setFavCount(asset.getFavCount());
            a.setIncomeratios(asset.getIncomeratios());
            a.setIsshow(asset.getIsshow());
            a.setIssuer(asset.getIssuer());
            a.setManagename(asset.getManagename());
            a.setName(asset.getName());
            a.setPaytype(asset.getPaytype());
            a.setPeriod(asset.getPeriod());
            a.setPest(asset.getPest());
            a.setPhoto(asset.getPhoto());
            a.setProintro(asset.getProintro());
            a.setRatiosize(asset.getRatiosize());
            a.setRelatedoc(asset.getRelatedoc());
            a.setStatus(asset.getStatus());
            a.setThreshold(asset.getThreshold());
            a.setTotal(asset.getTotal());
            a.setUpdateTime(DateUtil.format(new Date(), null));

            assetService.update(a);
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
