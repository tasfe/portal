package com.portal.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.portal.common.StringUtils;
import com.portal.service.IAccountService;
import com.portal.service.IAssetService;
import com.portal.service.ICustomerService;
import com.portal.service.IDonationService;
import com.portal.service.IFundService;
import com.portal.service.ITrustService;
import com.portal.service.IUserService;

@Controller
@RequestMapping("/product")
public class ProductController {

  private final Logger logger = Logger.getLogger(ProductController.class);

  @Autowired
  IUserService userService;

  @Autowired
  ICustomerService customerService;

  @Autowired
  IAccountService accountService;

  @Autowired
  IDonationService donationService;
  @Autowired
  IFundService fundService;

  @Autowired
  IAssetService assetService;

  @Autowired
  ITrustService trustService;

  /**
   * 资产管理查询
   * 
   * @param request
   * @param customer
   * @return
   * @throws JSONException
   * @throws JsonProcessingException
   */
  @RequestMapping(value = "/asset/{currentPage}", method = RequestMethod.GET)
  @ResponseBody
  public String assets(HttpServletRequest request, @PathVariable("currentPage") Integer pageNo) throws JSONException,
      JsonProcessingException {
    logger.info("search donation ");
    JSONObject result = new JSONObject();

    try {
      int pageSize = 10;

      Map<String, Object> params = new HashMap<String, Object>();
      params.put("start", (pageNo - 1) * pageSize);
      params.put("rows", pageSize);
      long count = assetService.findListCount(params);
      result.put("success", true);
      result.put("totalCount", count);
      result.put("currentPage", pageNo);
      result.put("totalPage", count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
      result.put("data", assetService.findList(params));
    } catch (Exception e) {
      logger.error(e);
      result.put("success", false);
      logger.error(e.getMessage());
      e.printStackTrace();
    }

    return result.toString();
  }

  /**
   * 私募查询
   * 
   * @param request
   * @param customer
   * @return
   * @throws JSONException
   * @throws JsonProcessingException
   */
  @RequestMapping(value = "/donation/{currentPage}", method = RequestMethod.GET)
  @ResponseBody
  public String donations(HttpServletRequest request, @PathVariable("currentPage") Integer pageNo) throws JSONException,
      JsonProcessingException {
    logger.info("search donation ");

    System.out.println("donation starts..");
    JSONObject result = new JSONObject();
    Map<String, Object> params = new HashMap<String, Object>();
    int pageSize = 10;

    params.put("start", (pageNo - 1) * pageSize);
    params.put("rows", pageSize);

    long count = donationService.findListCount(params);
    result.put("success", true);
    result.put("totalCount", count);
    result.put("currentPage", pageNo);
    result.put("totalPage", count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
    result.put("data", donationService.findList(params));

    return result.toString();
  }

  /**
   * 基金查询
   * 
   * @param request
   * @param
   * @return
   * @throws JSONException
   * @throws JsonProcessingException
   */
  @RequestMapping(value = "/fund/{currentPage}", method = RequestMethod.GET)
  @ResponseBody
  public String funds(HttpServletRequest request, @PathVariable("currentPage") Integer pageNo) throws JSONException,
      JsonProcessingException {
    logger.info("search fund ");
    JSONObject result = new JSONObject();
    Map<String, Object> params = new HashMap<String, Object>();
    int pageSize = 10;

    params.put("start", (pageNo - 1) * pageSize);
    params.put("rows", pageSize);

    long count = fundService.findListCount(params);
    result.put("success", true);
    result.put("totalCount", count);
    result.put("currentPage", pageNo);
    result.put("totalPage", count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
    result.put("data", fundService.findList(params));

    return result.toString();
  }

  /**
   * 信托查询
   * 
   * @param request
   * @param customer
   * @return
   * @throws JSONException
   * @throws JsonProcessingException
   */
  @RequestMapping(value = "/trust/{currentPage}", method = RequestMethod.GET)
  @ResponseBody
  public String search(HttpServletRequest request, @PathVariable("currentPage") Integer pageNo) throws JSONException,
      JsonProcessingException {
    logger.info("search trust ");
    JSONObject result = new JSONObject();
    Map<String, Object> params = new HashMap<String, Object>();
    int pageSize = 10;

    params.put("start", (pageNo - 1) * pageSize);
    params.put("rows", pageSize);

    long count = trustService.findListCount(params);
    result.put("success", true);
    result.put("totalCount", count);
    result.put("currentPage", pageNo);
    result.put("totalPage", count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
    result.put("data", trustService.findList(params));

    return result.toString();
  }

  /**
   * 信托查询
   * 
   * @param request
   * @param customer
   * @return
   * @throws JSONException
   * @throws JsonProcessingException
   */
  @RequestMapping(method = RequestMethod.GET)
  @ResponseBody
  public String trusts(HttpServletRequest request, @RequestParam("key") String key) throws JSONException, JsonProcessingException {
    logger.info("search trust ");
    JSONObject result = new JSONObject();
    Map<String, Object> params = new HashMap<String, Object>();
    int pageSize = 10;
    int pageNo = 1;

    params.put("start", (pageNo - 1) * pageSize);
    params.put("rows", pageSize);

    if (!StringUtils.isEmpty(key)) {

      String[] word = key.split("+");
      String type = word[0];
      String k = word[1];
      params.put("key", k);
      switch (type) {
        case "1":
          result.put("data", trustService.findByKeyWord(params));
          break;
        case "2":
          result.put("data", donationService.findByKeyWord(params));
          break;
        case "3":
          result.put("data", fundService.findByKeyWord(params));
          break;
        case "4":
          result.put("data", assetService.findByKeyWord(params));
          break;
        default:
          result.put("data", new ArrayList<>());
          break;
      }
      result.put("success", true);
    } else {
      result.put("success", false);
      result.put("msg", "请输入关键字");
    }

    return result.toString();
  }
}
