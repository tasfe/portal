package com.portal.controller;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.portal.common.DateUtil;
import com.portal.common.PwdUtil;
import com.portal.common.StringUtils;
import com.portal.constant.Constant.AccountType;
import com.portal.entity.Account;
import com.portal.entity.Manager;
import com.portal.service.IAccountService;
import com.portal.service.IManagerService;
import com.portal.service.IUserService;
import com.portal.util.FileUtil;

@Controller
@RequestMapping("/manager")
public class ManagerController {

  private final Logger logger = Logger.getLogger(ManagerController.class);

  @Autowired
  IUserService userService;

  @Autowired
  IAccountService accountService;

  @Autowired
  IManagerService managerService;

  @Resource
  FileUtil fileUtil;

  /**
   * 基金经理注册
   * 
   * @param request
   * @param manager
   * @return
   * @throws JSONException
   * @throws JsonProcessingException
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public String login(HttpServletRequest request, @RequestBody Manager manager) throws JSONException, JsonProcessingException {
    logger.info("new manager ");
    JSONObject result = new JSONObject();
    if (!StringUtils.isEmpty(manager.getMobilePhone())) {
      Manager man = managerService.findByPhone(manager.getMobilePhone());
      if (man != null) {
        result.put("success", false);
        result.put("msg", "手机号已存在");
      } else {
        // 注册新用户和新帐户
        try {
          manager.setCreateTime(DateUtil.format(new Date(), null));
          manager.setUpdateTime(manager.getCreateTime());
          Manager m = managerService.create(manager);

          if (m != null) {

            Account account = new Account();
            account.setCreateTime(manager.getCreateTime());
            account.setMobilePhone(manager.getMobilePhone());
            account.setPwd(PwdUtil.encypt(manager.getPwd()));
            account.setUpdateTime(account.getCreateTime());
            account.setUserName(manager.getName());
            account.setUserId(m.getId());
            account.setUserType(AccountType.MANAGER);
            accountService.create(account);
            result.put("success", true);
            result.put("msg", "注册成功");
          } else {
            result.put("success", false);
            result.put("msg", "发生错误");
          }

        } catch (Exception e) {
          logger.info("error occurred while register new manager : " + e.getMessage());
          result.put("success", false);
          result.put("msg", "系统异常");
        }

      }
    } else {
      result.put("success", false);
      result.put("msg", "手机号不正确");
    }

    return result.toString();
  }

  @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public String uploadFile(HttpServletRequest request, @RequestPart MultipartFile file) {
    logger.info("enter upload file ");

    JSONObject result = new JSONObject();
    try {

      if (file != null && file.getSize() > 0) {

        String suffix = UUID.randomUUID() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

        fileUtil.putObject(suffix, file.getInputStream());

        result.put("md5", suffix);
        result.put("success", true);
      } else {
        result.put("md5", "");
        result.put("success", false);
        result.put("msg", "文件不正确");
      }
    } catch (Exception e) {
      result.put("success", false);
      result.put("msg", "发生错误");
      e.printStackTrace();
    }

    return result.toString();

  }

}
