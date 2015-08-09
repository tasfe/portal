package com.portal.util;

import com.alibaba.fastjson.JSONObject;

public class FormBuilder {

  public static String getFormHtml(String jsonData) {
    StringBuffer sbHtml = new StringBuffer("");
    JSONObject jsonObject = JSONObject.parseObject(jsonData);
    System.out.println(jsonObject.get(""));
    String charset = jsonObject.getString("charset");
    if (charset == null || ("").equals(charset)) {
      charset = "UTF-8";
    }
    String inputs = jsonObject.getString("formInputs");
    if (inputs == null || ("").equals(inputs)) {
      return "";
    }
    String method = jsonObject.getString("submitMethod");
    if (method == null || ("").equals(method)) {
      return "";
    }
    String action = jsonObject.getString("submitUrl");
    if (action == null || ("").equals(action)) {
      return "";
    }
    JSONObject inputJson = JSONObject.parseObject(inputs);
    sbHtml.append("<!DOCTYPE HTML><html><head><meta charset=\"" + charset + "\" /> <title>qianbao</title></head>");
    sbHtml.append("<form id=\"payForm\" name=\"payForm\" action=\"" + action + "\" method=\"" + method + "\">");
    sbHtml.append("<input type=\"hidden\" id=\"token\" name=\"token\" value=\"" + inputJson.getString("token") + "\"/>");
    sbHtml.append("<input type=\"hidden\" id=\"userNo\" name=\"userNo\" value=\"" + inputJson.getString("userNo") + "\"/>");
    sbHtml.append("<input type=\"hidden\" id=\"customerNo\" name=\"customerNo\" value=\"" + inputJson.getString("customerNo") + "\"/>");
    sbHtml.append("<input type=\"hidden\" id=\"outTradeNo\" name=\"outTradeNo\" value=\"" + inputJson.getString("outTradeNo") + "\"/>");
    sbHtml.append("<input type=\"hidden\" id=\"tradeAmount\" name=\"tradeAmount\" value=\"" + inputJson.getString("tradeAmount") + "\"/>");
    sbHtml.append("<input type=\"hidden\" id=\"tradeCurrency\" name=\"tradeCurrency\" value=\"" + inputJson.getString("tradeCurrency")
        + "\"/>");
    // submit按钮控件请不要含有name属性
    sbHtml.append("<input type=\"submit\" value=\"提交\" style=\"display:none;\"></form>");
    sbHtml.append("<script>document.forms['payForm'].submit();</script>");
    sbHtml.append("</html>");
    return sbHtml.toString();
  }

}
