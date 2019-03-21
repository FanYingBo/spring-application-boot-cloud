package com.study.selfs.aop.log.aspect;

import com.google.gson.Gson;
import com.study.selfs.aop.log.domain.RequestEntry;
import org.apache.kafka.clients.admin.NewTopic;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;

/**
 *spring boot aop+kafka+elk
 */

@Aspect
@Configuration
public class LogAspect {


    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Autowired
    private NewTopic topic;

    @Pointcut("execution(public * com.study.selfs.aop.controller..*.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void beforeCut(JoinPoint joinPoint){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //获取servletRequest
        HttpServletRequest servletRequest = (HttpServletRequest)requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        String ipAddress  = servletRequest.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0
                || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = servletRequest.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0
                || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = servletRequest.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0
                || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = servletRequest.getRemoteAddr();
        }

        RequestEntry requestEntry = new RequestEntry();
        requestEntry.setAddress(ipAddress);
        Enumeration<String> attributeNames = servletRequest.getParameterNames();
        HashMap<String,Object> valueMap = new HashMap<>();
        while(attributeNames.hasMoreElements()) {
            String str = attributeNames.nextElement();
            valueMap.put(str, servletRequest.getParameter(str));
        }
        requestEntry.setParameters(valueMap);
        Gson gson = new Gson();
        String json = gson.toJson(requestEntry);
        kafkaTemplate.send(topic.name(),json);
    }

    @After("pointCut()")
    public void afterCut(){

    }

    @AfterThrowing("pointCut()")
    public void throwing(){

    }
}
