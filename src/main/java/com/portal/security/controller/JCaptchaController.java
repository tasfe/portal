/**
 * Copyright 2006 Bosco Curtu Licensed under the Apache License, Version 2.0 (the "License"); you
 * may not use this file except in compliance with the License.
 * 
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 Unless
 * required by applicable law or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 * 
 * See the License for the specific language governing permissions and limitations under the
 * License.
 */
package com.portal.security.controller;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.octo.captcha.service.image.ImageCaptchaService;

public class JCaptchaController implements Controller, InitializingBean {

  @Autowired
  private ImageCaptchaService captchaService;

  public void afterPropertiesSet() throws Exception {
    if (captchaService == null) {
      throw new RuntimeException("Image captcha service wasn`t set!");
    }
  }

  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    String captchaId = request.getSession().getId();
    BufferedImage challenge = captchaService.getImageChallengeForID(captchaId, request.getLocale());

    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    response.setContentType("image/jpeg");

    ImageIO.write(challenge, "jpeg", response.getOutputStream());

    /*
     * byte[] captchaChallengeAsJpeg = null; ByteArrayOutputStream jpegOutputStream = new
     * ByteArrayOutputStream();
     * 
     * JPEGImageEncoder jpegEncoder = JPEGCodec.createJPEGEncoder(jpegOutputStream);
     * jpegEncoder.encode(challenge);
     * 
     * captchaChallengeAsJpeg = jpegOutputStream.toByteArray(); ServletOutputStream
     * responseOutputStream = response.getOutputStream();
     * 
     * responseOutputStream.write(captchaChallengeAsJpeg); responseOutputStream.flush();
     * responseOutputStream.close();
     */
    return null;
  }

  public void setCaptchaService(ImageCaptchaService captchaService) {
    this.captchaService = captchaService;
  }
}
