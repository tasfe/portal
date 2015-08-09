package com.portal.security.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.portal.entity.Account;
import com.portal.service.IUserService;

@Controller
@RequestMapping(value = "/")
public class IndexController {
  // @Autowired
  // private UserUtils userUtils;

  @Autowired
  IUserService userService;

  @RequestMapping(value = "/createAccount", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public String createAccount(HttpServletRequest request, @RequestBody Account account) {
    System.out.println(account.getUserName());
    return "";
  }

  /**
   * 首页跳转
   * 
   * @author qianchun @date 2015年1月23日 下午7:48:04
   * @param model
   * @param request
   * @return
   */
  @RequestMapping(value = "", method = RequestMethod.GET)
  public String index(ModelMap model, HttpServletRequest request) {

    // User currentUser = userUtils.getUser(LoginType.publicTeacher, request);
    // if (currentUser == null) {
    // currentUser = userUtils.getUser(LoginType.privateTeacher, request);
    // }
    //
    // // 未登录，跳转登录页面
    // if (currentUser == null) {
    // return "/login";
    // }
    //
    // // 判断是否设置了教材版本
    // if (currentUser.getLoginType() == LoginType.privateTeacher) {
    // PrivateTeacher privateTeacher = privateTeacherService.findById(currentUser.getId());
    // long subjectId = privateTeacher.getSubjectId();
    // if (privateTeacher.getTeachingDirectoryId() > 0) {
    // return "/teacher/user/index";
    // } else {
    // model.addAttribute("subjectId", subjectId);
    // return "/teacher/user/setDirectory";
    // }
    // } else {
    // Teacher teacher = teacherManagementService.findTeacherById(currentUser.getId());
    // long subjectId = teacher.getSubjectId();
    // if (teacher.getTeachingDirectoryId() > 0) {
    // return "/teacher/user/index";
    // } else {
    // model.addAttribute("subjectId", subjectId);
    // return "/teacher/user/setDirectory";
    // }

    // SecurityUtils.getSubject().getSession().setTimeout(-10001);
    //
    // LoginToken token = new LoginToken("123", "", "");
    // token.setRememberMe(true);
    // Subject cUser = SecurityUtils.getSubject();
    // JSONObject result = new JSONObject();
    // if (!cUser.isAuthenticated()) {
    // User loginUser;
    // try {
    // cUser.login(token);
    // } catch (UnknownAccountException e) {
    // result.put("success", false);
    // result.put("msg", "用户名或者密码错误");
    // token.clear();
    //
    // } catch (IncorrectCredentialsException ice) {
    // result.put("success", false);
    // result.put("msg", "密码错误");
    // token.clear();
    // }
    // return info to client if login success but imei don't match it's original one

    // loginUser = userService.login(user.getLoginId());

    // result.put("success", true);
    // result.put("msg", "登录成功");
    // result.put("sessionId", cUser.getSession().getId());
    // } else {
    // result.put("success", false);
    // result.put("msg", "不能重复登录");
    // result.put("sessionId", cUser.getSession().getId());
    // }
    // // return result.toString();

    return "yfc/index";
  }
}
