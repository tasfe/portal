package com.portal.filter;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.portal.common.StringUtils;

//

/**
 * 重写HttpServletRequestWrapper，用于拦截xxs
 * 
 * @author guoxc
 * 
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {
  /**
   * 获取最原始的request的静态方法
   * 
   * @return
   */
  public static HttpServletRequest getOrgRequest(HttpServletRequest req) {
    if (req instanceof XssHttpServletRequestWrapper) {
      return ((XssHttpServletRequestWrapper) req).getOrgRequest();
    }

    return req;
  }

  /**
   * 将容易引起xss漏洞的半角字符直接替换成全角字符
   * 
   * @param s
   * @return
   */
  private static String xssEncode(String s) {
    if (s == null || "".equals(s)) {
      return s;
    }
    return StringUtils.escapeHtml(s);
    // return "";
  }

  /**
   * 将容易引起xss漏洞的半角字符直接替换成全角字符
   * 
   * @param s
   * @return
   */
  private static String[] xssEncode(String[] strs) {
    if (strs == null || strs.length == 0) {
      return strs;
    }
    int len = strs.length;
    String retStrs[] = new String[len];
    for (int i = 0; i < len; i++) {
      // retStrs[i] = StringUtils.escapeHtml(strs[i]);
    }
    return retStrs;
  }

  HttpServletRequest orgRequest = null;

  public XssHttpServletRequestWrapper(HttpServletRequest request) {
    super(request);
    orgRequest = request;
  }

  /**
   * 覆盖getHeader方法，将参数名和参数值都做xss过滤。<br/>
   * 如果需要获得原始的值，则通过super.getHeaders(name)来获取<br/>
   * getHeaderNames 也可能需要覆盖
   */
  @Override
  public String getHeader(String name) {

    String value = super.getHeader(xssEncode(name));
    if (value != null) {
      value = xssEncode(value);
    }
    return value;
  }

  /**
   * 获取最原始的request
   * 
   * @return
   */
  public HttpServletRequest getOrgRequest() {
    return orgRequest;
  }

  /**
   * 覆盖getParameter方法，将参数名和参数值都做xss过滤。<br/>
   * 如果需要获得原始的值，则通过super.getParameterValues(name)来获取<br/>
   * getParameterNames,getParameterValues和getParameterMap也可能需要覆盖
   */
  @Override
  public String getParameter(String name) {
    String value = super.getParameter(xssEncode(name));
    if (value != null) {
      value = xssEncode(value);
    }
    return value;
  }

  @Override
  public Map<String, String[]> getParameterMap() {
    Map<String, String[]> map = super.getParameterMap();
    Map<String, String[]> retMap = new HashMap<String, String[]>();
    for (String key : map.keySet()) {
      String[] values = xssEncode(map.get(key));
      retMap.put(key, values);
    }
    return retMap;
  }

  @Override
  public String[] getParameterValues(String name) {
    String[] strs = super.getParameterValues(name);
    if (strs != null) {
      strs = xssEncode(strs);
    }
    return strs;
  }

}
