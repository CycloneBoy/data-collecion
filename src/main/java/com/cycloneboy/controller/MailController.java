package com.cycloneboy.controller;

import com.cycloneboy.utils.ResultMsg;
import com.cycloneboy.utils.ResultStatusCode;
import org.apache.catalina.webresources.FileResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafTemplateAvailabilityProvider;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by CycloneBoy on 2017/7/18.
 */
@RestController
@RequestMapping(value = "/mail")
public class MailController {

   @Autowired
   private JavaMailSender mailSender;

   //@Autowired
   //private VelocityEngine

   @RequestMapping("/send")
    public Object sendMail(){
       try {
           final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
           final MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
           message.setFrom("2368311551@qq.com");
           message.setTo("534634799@qq.com");
           message.setSubject("测试邮件主题");
           message.setText("测试邮件内容");
           this.mailSender.send(mimeMessage);

           ResultMsg resultMsg = new ResultMsg(ResultStatusCode.OK.getErrcode(),
                   ResultStatusCode.OK.getErrmsg(),"发送测试邮件成功");
           return  resultMsg;

       }catch (Exception e){
           System.out.println("发送邮件出现错误:" + e.toString());
           ResultMsg resultMsg = new ResultMsg(ResultStatusCode.SYSTEM_ERR.getErrcode(),
                   ResultStatusCode.SYSTEM_ERR.getErrmsg(),"发送测试邮件成功");
           return  resultMsg;
       }
   }

   @RequestMapping(value = "/sendatt")
    public Object sendAttachmentsMail(HttpSession session) {
       try {
           final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
           final MimeMessageHelper message = new MimeMessageHelper(mimeMessage,true); //设置有附件
           message.setFrom("2368311551@qq.com");
           message.setTo("534634799@qq.com");
           message.setSubject("测试邮件主题: 有附件");
           message.setText("有附件的邮件");

           FileSystemResource file = new FileSystemResource(new File
                   ("D:\\java\\idea\\data-collecion\\src\\main\\resources\\upload\\qrcode.jpg"));
           message.addAttachment("附件-1.jpg",file);
           message.addAttachment("附件-2.jpg",file);

           String path = session.getServletContext().getRealPath("/WEB-INF/classes/upload");
           File file1 = new File(path + File.separator + "qrcode.jpg");
           message.addInline("附件-3.jpg",file1);
           this.mailSender.send(mimeMessage);

           ResultMsg resultMsg = new ResultMsg(ResultStatusCode.OK.getErrcode(),
                   ResultStatusCode.OK.getErrmsg(),"发送带附件的邮件成功");
           return  resultMsg;

       }catch (Exception e){
           System.out.println("发送邮件出现错误:" + e.toString());
           ResultMsg resultMsg = new ResultMsg(ResultStatusCode.SYSTEM_ERR.getErrcode(),
                   ResultStatusCode.SYSTEM_ERR.getErrmsg(),"发送带附件的邮件成功");
           return  resultMsg;
       }
   }

   @RequestMapping(value = "/sendinline")
    public Object sendInlineMail(){
       try {
           final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
           final MimeMessageHelper message = new MimeMessageHelper(mimeMessage,true); //设置有附件
           message.setFrom("2368311551@qq.com");
           message.setTo("534634799@qq.com");
           message.setSubject("测试邮件主题: 嵌入静态资源");
           message.setText("<html><body><img src=\\\"cid:qrcode\\\" ></body></html>",true);

           FileSystemResource file = new FileSystemResource(new File
                   ("D:\\java\\idea\\data-collecion\\src\\main\\resources\\upload\\qrcode.jpg"));

           message.addInline("qrcode",file);

           this.mailSender.send(mimeMessage);

           ResultMsg resultMsg = new ResultMsg(ResultStatusCode.OK.getErrcode(),
                   ResultStatusCode.OK.getErrmsg(),"发送嵌入静态资源的邮件成功");
           return  resultMsg;

       }catch (Exception e){
           System.out.println("发送邮件出现错误:" + e.toString());
           ResultMsg resultMsg = new ResultMsg(ResultStatusCode.SYSTEM_ERR.getErrcode(),
                   ResultStatusCode.SYSTEM_ERR.getErrmsg(),"发送嵌入静态资源的邮件出错啦");
           return  resultMsg;
       }
   }

    /**
     * 发送Thymeleaf 模板的邮件还没调试好
     * @param session
     * @return
     */
   @RequestMapping(value = "/sendtemp")
    public Object sendTemplateMail(HttpSession session){
       try {
           final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
           final MimeMessageHelper message = new MimeMessageHelper(mimeMessage,true); //设置有附件
           message.setFrom("2368311551@qq.com");
           message.setTo("534634799@qq.com");
           message.setSubject("测试邮件主题: 模板邮件");

           Map<String,Object> model = new HashMap<>();
           model.put("username","cycloneboy");
           message.setText("有附件的邮件");

           FileSystemResource file = new FileSystemResource(new File
                   ("D:\\java\\idea\\data-collecion\\src\\main\\resources\\upload\\qrcode.jpg"));
           message.addAttachment("附件-1.jpg",file);
           message.addAttachment("附件-2.jpg",file);

           String path = session.getServletContext().getRealPath("/WEB-INF/classes/upload");
           File file1 = new File(path + File.separator + "qrcode.jpg");
           message.addInline("附件-3.jpg",file1);
           this.mailSender.send(mimeMessage);

           ResultMsg resultMsg = new ResultMsg(ResultStatusCode.OK.getErrcode(),
                   ResultStatusCode.OK.getErrmsg(),"发送带附件的邮件成功");
           return  resultMsg;

       }catch (Exception e){
           System.out.println("发送邮件出现错误:" + e.toString());
           ResultMsg resultMsg = new ResultMsg(ResultStatusCode.SYSTEM_ERR.getErrcode(),
                   ResultStatusCode.SYSTEM_ERR.getErrmsg(),"发送带附件的邮件成功");
           return  resultMsg;
       }
   }
}
