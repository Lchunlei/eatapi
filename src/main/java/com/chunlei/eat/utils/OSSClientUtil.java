package com.chunlei.eat.utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URL;
import java.util.Date;
import java.util.Random;

/**
 * 阿里云 OSS文件类
 *
 * @author YuanDuDu
 */
public class OSSClientUtil {

  Log log = LogFactory.getLog(OSSClientUtil.class);
  // endpoint以杭州为例，其它region请按实际情况填写
  private static String endpoint = "https://oss-cn-qingdao.aliyuncs.com";
  // accessKey
  private static String accessKeyId = "lIfVyG533quM9N7S";
  private static String accessKeySecret = "Jg2s75fIb4BbQko8s5JKvlDbXR3tJE";
  //空间
  private static String bucketName = "yuxian";
  //文件存储目录
  private static String filedir = "yuxian/";

  private static OSSClient ossClient;

  static {
    ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
  }

  /**
   * 初始化
   */
//	  public void init() {
//	    ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
//	  }
//
  /**
   * 销毁
   */
  public void destory() {
    ossClient.shutdown();
  }

  /**
   * 上传图片
   *
   * @param url
   */
  public void uploadImg2Oss(String url) {
    File fileOnServer = new File(url);
    FileInputStream fin;
    try {
      fin = new FileInputStream(fileOnServer);
      String[] split = url.split("/");
      this.uploadFile2OSS(fin, split[split.length - 1]);
    } catch (FileNotFoundException e) {

    }
  }


  public String uploadImg2Oss(MultipartFile file) {
    String originalFilename = file.getOriginalFilename();
    String substring = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
    Random random = new Random();
    String name = random.nextInt(10000) + System.currentTimeMillis() + substring;
    try {
      InputStream inputStream = file.getInputStream();
      this.uploadFile2OSS(inputStream, name);
      return name;
    } catch (Exception e) {

    }finally {

    }
    return name;
  }

  /**
   * 获得图片路径
   *
   * @param fileUrl
   * @return
   */
  public String getImgUrl(String fileUrl) {
    if (!StringUtils.isEmpty(fileUrl)) {
      String[] split = fileUrl.split("/");
      String url = this.getUrl(this.filedir + split[split.length - 1]);
    url = url.replace("https://yuxian.oss-cn-qingdao.aliyuncs.com","http://file.51yuxian.com");

        return url;
    }
    return null;
  }

  /**
   * 上传到OSS服务器  如果同名文件会覆盖服务器上的
   *
   * @param instream 文件流
   * @param fileName 文件名称 包括后缀名
   * @return 出错返回"" ,唯一MD5数字签名
   */
  public String uploadFile2OSS(InputStream instream, String fileName) {
    String ret = "";
    try {
      //创建上传Object的Metadata
      ObjectMetadata objectMetadata = new ObjectMetadata();
      objectMetadata.setContentLength(instream.available());
      objectMetadata.setCacheControl("no-cache");
      objectMetadata.setHeader("Pragma", "no-cache");
      objectMetadata.setContentType(getcontentType(fileName.substring(fileName.lastIndexOf("."))));
      objectMetadata.setContentDisposition("inline;filename=" + fileName);
      //上传文件
      PutObjectResult putResult = ossClient.putObject(bucketName, filedir + fileName, instream, objectMetadata);
      ret = putResult.getETag();
    } catch (IOException e) {
      log.error(e.getMessage(), e);
    } finally {
      try {
        if (instream != null) {
          instream.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }

    }
    return ret;
  }

    /**
     * 上传数组
     * @param data
     * @param fileName
     * @return
     */
  public String uploadByte(byte[] data, String fileName) {
    String ret = "";
    try {
      //上传文件
      PutObjectResult putResult =ossClient.putObject(bucketName, fileName, new ByteArrayInputStream(data));;
      ret = putResult.getETag();
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    }finally {

    }
    return ret;
  }



    /**
     * 上传到OSS服务器  如果同名文件会覆盖服务器上的
     *
     * @param fileName 文件名称 包括后缀名
     * @return 出错返回"" ,唯一MD5数字签名
     */
    public String uploadFileTurnUrl(InputStream file,String fileName) {
        String ret = "";
        try {
            //创建上传Object的Metadata
            ObjectMetadata objectMetadata = new ObjectMetadata();
//				objectMetadata.setContentLength((file.available()*13));
            objectMetadata.setCacheControl("no-cache");
            objectMetadata.setHeader("Pragma", "no-cache");
            objectMetadata.setContentType(getcontentType(fileName.substring(fileName.lastIndexOf("."))));
            objectMetadata.setContentDisposition("inline;filename=" + fileName);
            //上传文件
            PutObjectResult putResult = ossClient.putObject(bucketName, filedir + fileName, file, objectMetadata);
            ret = putResult.getETag();
            if(ret==null||"".equals(ret)){
                return null;
            }else {
                ret=getImgUrl(fileName);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {

        }
        return ret;
    }

  /**
   * Description: 判断OSS服务文件上传时文件的contentType
   *
   * @param FilenameExtension 文件后缀
   * @return String
   */
  public static String getcontentType(String FilenameExtension) {
    if (FilenameExtension.equalsIgnoreCase(".bmp")) {
      return "image/bmp";
    }
    if (FilenameExtension.equalsIgnoreCase(".gif")) {
      return "image/gif";
    }
    if (FilenameExtension.equalsIgnoreCase(".jpeg") ||
        FilenameExtension.equalsIgnoreCase(".jpg") ||
        FilenameExtension.equalsIgnoreCase(".png")) {
      return "image/jpeg";
    }
    if (FilenameExtension.equalsIgnoreCase(".html")) {
      return "text/html";
    }
    if (FilenameExtension.equalsIgnoreCase(".txt")) {
      return "text/plain";
    }
    if (FilenameExtension.equalsIgnoreCase(".vsd")) {
      return "application/vnd.visio";
    }
    if (FilenameExtension.equalsIgnoreCase(".pptx") ||
        FilenameExtension.equalsIgnoreCase(".ppt")) {
      return "application/vnd.ms-powerpoint";
    }
    if (FilenameExtension.equalsIgnoreCase(".docx") ||
        FilenameExtension.equalsIgnoreCase(".doc")) {
      return "application/msword";
    }
    if (FilenameExtension.equalsIgnoreCase(".xml")) {
      return "text/xml";
    }
    return "image/jpeg";
  }

  /**
   * 获得url链接
   *
   * @param key
   * @return
   */
  public static String getUrl(String key) {
    // 设置URL过期时间为10年  3600l* 1000*24*365*10
    Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
    // 生成URL
    URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
    if (url != null) {
      return url.toString();
    }
    return null;
  }

}
