package com.portal.security.interceptors;

import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 用户登录拦截器
 * 
 * @author qianchun
 */
public class LoggedInterceptor extends HandlerInterceptorAdapter {

  private List<String> whiteList;

  // @Autowired
  // private UserUtils userUtils;

  // private String qiNiuBaseUrl = PropertiesUtil.getValue("server.properties", "qiniu.baseurl");

  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    // if (handler != null && handler instanceof HandlerMethod) {
    // boolean islogined = false;
    // User currentUser = userUtils.getUser(LoginType.publicTeacher, request);
    // if (currentUser == null) {
    // currentUser = userUtils.getUser(LoginType.privateTeacher, request);
    // }
    //
    // // 设置用户状态
    // if (currentUser != null) {
    // request.setAttribute("islogin", true);
    //
    // PrivateTeacher privateTeacher = privateTeacherService.findById(currentUser.getId());
    // request.setAttribute("islogin", true);
    // request.setAttribute("username", privateTeacher.getName());
    // request.setAttribute("qiNiuBaseUrl", qiNiuBaseUrl);
    // request.setAttribute("headerImg", privateTeacher.getHeadImage());
    //
    // request.setAttribute("islogin", true);
    // islogined = true;
    // } else {
    // request.setAttribute("islogin", false);
    // islogined = false;
    // request.setAttribute("username", null);
    // request.setAttribute("headerImgUrl", null);
    // }
    //
    // String strUrl = request.getRequestURI();
    // String baseUrl = request.getContextPath();
    // strUrl = strUrl.substring(request.getContextPath().length());
    //
    // if (checkIsInWhiteList(strUrl) == true) {
    // return true;
    // }
    //
    // if (!islogined) {
    // String requestType = request.getHeader("X-Requested-With");
    // // 判断请求是否为ajax请求
    // if (requestType != null && requestType.equals("XMLHttpRequest")) {
    // response.sendError(401);
    // } else {
    // response.sendRedirect(baseUrl + "/");
    // }
    // return false;
    // }
    // }
    return true;
  }

  /**
   * 登录的页面URL 当未登录访问已登录的页面时，自动跳转到该页面
   * 
   * @param loginUrl
   */

  public void setWhiteList(List<String> whiteList) {
    this.whiteList = whiteList;
  }

  private boolean checkIsInWhiteList(String url) {
    if (url.endsWith("/") == false) {
      url = url + "/";
    }
    for (String tmp : whiteList) {
      if (tmp.endsWith("/") == false) {
        tmp = tmp + "/";
      }

      if (tmp.equals(url)) {
        return true;
      }

      if (tmp.contains("\\d") || tmp.contains("\\w")) {
        boolean flag = Pattern.compile(tmp).matcher(url).find();
        if (flag == true) {
          return true;
        }
      }
    }
    return false;
  }
}
