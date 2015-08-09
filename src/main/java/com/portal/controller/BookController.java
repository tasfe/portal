package com.portal.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.portal.common.DateUtil;
import com.portal.constant.Constant.BookStatus;
import com.portal.constant.Constant.ObjectType;
import com.portal.entity.Asset;
import com.portal.entity.Book;
import com.portal.entity.Donation;
import com.portal.entity.Fund;
import com.portal.entity.Manager;
import com.portal.entity.Trust;
import com.portal.service.IAccountService;
import com.portal.service.IAssetService;
import com.portal.service.IBookService;
import com.portal.service.ICustomerService;
import com.portal.service.IDonationService;
import com.portal.service.IFundService;
import com.portal.service.IManagerService;
import com.portal.service.ITrustService;
import com.portal.service.IUserService;

@Controller
@RequestMapping("/book")
public class BookController {

  private final Logger logger = Logger.getLogger(BookController.class);

  @Autowired
  IUserService userService;

  @Autowired
  ICustomerService customerService;

  @Autowired
  IAccountService accountService;

  @Autowired
  IAssetService assetService;

  @Autowired
  IFundService fundService;

  @Autowired
  IDonationService donationService;

  @Autowired
  ITrustService trustService;

  @Autowired
  IBookService bookService;

  @Autowired
  IManagerService managerService;

  /**
   * 收藏某个产品
   * 
   * @param request
   * @param customer
   * @return
   * @throws JSONException
   * @throws JsonProcessingException
   */
  @RequestMapping(value = "/bookOne", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public String asset(HttpServletRequest request, @RequestBody Book book) throws JSONException, JsonProcessingException {
    logger.info("search donation ");
    JSONObject result = new JSONObject();
    try {
      Subject cUser = SecurityUtils.getSubject();

      String date = DateUtil.format(new Date(), null);
      book.setCreateTime(date);
      book.setStatus(BookStatus.SUCCESS);
      book.setUpdateTime(date);
      Manager manager = managerService.findByPhone(String.valueOf(cUser.getPrincipal()));

      if (manager != null) {

        book.setUserId(manager.getId());
      }

      int type = book.getType();
      switch (type) {
        case ObjectType.MANAGER:
          // Manager manager = managerService.findOne(book.getObjectId());
          if (manager != null) {
            bookService.create(book);
          }
          break;

        case ObjectType.DONATION:
          Donation donation = donationService.findOne(book.getObjectId());
          if (donation != null) {
            bookService.create(book);
          }
          break;

        case ObjectType.ASSET:
          Asset asset = assetService.findOne(book.getObjectId());
          if (asset != null) {
            bookService.create(book);
          }
          break;

        case ObjectType.FUND:
          Fund fund = fundService.findOne(book.getObjectId());
          if (fund != null) {
            bookService.create(book);
          }
          break;
        case ObjectType.TRUST:
          Trust trust = trustService.findOne(book.getObjectId());
          if (trust != null) {
            bookService.create(book);
          }
          break;

      }

      result.put("success", true);
      result.put("msg", "预定成功");

    } catch (Exception e) {
      result.put("success", false);
      result.put("msg", "发生错误");
    }

    return result.toString();
  }
}
