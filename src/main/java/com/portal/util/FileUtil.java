package com.portal.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;

@Component
public class FileUtil {

  public static void main(String[] args) {
    try {
      new FileUtil().putObject("web2014.jpg", new FileInputStream(new File("/Users/poppet/Pictures/IMG_5363.jpg")));
      // http://web2014.oss-cn-shenzhen.aliyuncs.com/web2014.jpg?Expires=1437398873&OSSAccessKeyId=bBUjbYKGquId7AGv&Signature=46xiwt8BFRERlYbMs0y%2BtIvATXI%3D
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  private String bucketName;

  private Logger logger = LoggerFactory.getLogger(FileUtil.class);

  private String endpoint;// = "oss-cn-shenzhen.aliyuncs.com";

  private String accessKeyId;// = "bBUjbYKGquId7AGv";

  private String accessKeySecret;// = "yQPU0IAWLhvsumwg2SnCFcJdvB3VCs";

  public String getAccessKeyId() {
    return accessKeyId;
  }

  public String getAccessKeySecret() {
    return accessKeySecret;
  }

  public String getBucketName() {
    return bucketName;
  }

  public String getEndpoint() {
    return endpoint;
  }

  public void getObject(String bucketName, String key) throws IOException {

    logger.info("get object of buckName [" + bucketName + "] with key [" + key + "]");

    // 初始化OSSClient
    OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);

    // 获取Object，返回结果为OSSObject对象
    OSSObject object = client.getObject(bucketName, key);

    // 获取ObjectMeta
    ObjectMetadata meta = object.getObjectMetadata();

    // 获取Object的输入流
    InputStream objectContent = object.getObjectContent();

    // 关闭流
    objectContent.close();
  }

  public String getObjectUrl(String key) throws IOException {

    logger.info("get object of buckName [" + bucketName + "] with key [" + key + "]");

    // 初始化OSSClient
    OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);

    URL url = client.generatePresignedUrl(bucketName, key, new Date(new Date().getTime() + 3600 * 1000));

    return url.toString();
  }

  public String getUploadFileInfo(String app, String fileType, String appPath) {
    long time = System.currentTimeMillis();
    String strTime = String.valueOf(time);
    strTime = strTime.substring(1);
    String bstr = strTime.substring(0, strTime.length() - 1);
    String estr = strTime.substring(strTime.length() - 1);
    Long tmp = Long.valueOf(Long.parseLong(bstr));
    String str62 = Num62.longToN62(tmp.longValue());
    Random r = new Random();
    String rStr = String.format("%03d", new Object[] {Integer.valueOf(r.nextInt(1000))});
    StringBuilder backStr = new StringBuilder(estr).append(rStr);
    StringBuilder retBasePath = new StringBuilder(app).append("_").append(str62).append(backStr);
    StringBuilder retPath = new StringBuilder(retBasePath);
    StringBuilder savePath = new StringBuilder(appPath).append(retBasePath);
    // String[] fileNames = this.getFileNameOrSuffix(retBasePath.toString());
    // StringBuilder oriRetPath = new
    // StringBuilder(fileNames[0]).append(".ori.").append(fileNames[1]);
    StringBuilder oriRetPath = new StringBuilder(retBasePath).append(".ori");
    StringBuilder oriSavePath = new StringBuilder(appPath).append(retBasePath).append(".ori");
    if (!("".equals(fileType))) {
      fileType = fileType.toLowerCase();
      retPath.append(".").append(fileType);
      savePath.append(".").append(fileType);
      oriRetPath.append(".").append(fileType);
      oriSavePath.append(".").append(fileType);
    }
    System.out.println("retPath:==" + retPath);
    System.out.println("savePath:==" + savePath);
    System.out.println("oriRetPath:==" + oriRetPath);
    System.out.println("oriSavePath:==" + oriSavePath);
    // map.put("retPath", retPath.toString());
    // map.put("savePath", savePath.toString());
    // map.put("oriRetPath", oriRetPath.toString());
    // map.put("oriSavePath", oriSavePath.toString());
    return retPath.toString();
  }

  // 上传
  public void putObject(String key, InputStream is) throws FileNotFoundException {
    logger.info("put object of buckName [" + bucketName + "] with key [" + key + "]");
    // 初始化OSSClient
    OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);

    // 获取指定文件的输入流

    // 创建上传Object的Metadata
    ObjectMetadata meta = new ObjectMetadata();

    // 上传Object.
    PutObjectResult result = client.putObject(bucketName, key, is, meta);

    // 打印ETag
    System.out.println(result.getETag());
  }

  public void setAccessKeyId(String accessKeyId) {
    this.accessKeyId = accessKeyId;
  }

  public void setAccessKeySecret(String accessKeySecret) {
    this.accessKeySecret = accessKeySecret;
  }

  public void setBucketName(String bucketName) {
    this.bucketName = bucketName;
  }

  public void setEndpoint(String endpoint) {
    this.endpoint = endpoint;
  }

}
