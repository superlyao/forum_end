package com.yliao.service.impl;

import com.yliao.bean.UserInfo;
import com.yliao.common.Log;
import com.yliao.exception.BusinessException;
import com.yliao.service.IEmailService;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liaoyao
 * @Date 2018/1/3.
 */
@Service
public class EmailServiceImpl implements IEmailService {

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;
    @Autowired
    private JavaMailSender mailSender;
    @Override
    public void activateUser(UserInfo userInfo) throws BusinessException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {

            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            // 发送人
            helper.setFrom("2238224938@qq.com");
            // 收件人
            helper.setTo(userInfo.getEmail());
            helper.setSubject("主题: 激活账号");
            Map<String, Object> model = new HashMap<String, Object>(16);
            model.put("userName", userInfo.getUserName());
            model.put("userId", userInfo.getId());

            Template template = freeMarkerConfigurer.getConfiguration().getTemplate("mailTemplate.html");
            String html =FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

            helper.setText(html, true);
            mailSender.send(mimeMessage);
        } catch (Exception e) {
            Log.error(e.getClass(), e.getMessage());
            throw new BusinessException("内部服务错误");
        }
    }
}
