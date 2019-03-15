package com.study.selfs.gupao.springcloud.config.client.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RefreshScope//
public class VerifyServerConfigController {


    @GetMapping("/verify")
    public String getConfig(@Value("${sign}") String sign){
            //客户端通过restful api 获取Environment
//        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
//        RestTemplate restTemplate = new RestTemplate(requestFactory);
//        HttpHeaders headers = new HttpHeaders();
//        Object[] args = new String[] { name, profile };
//        HttpEntity<Void> entity = new HttpEntity<>((Void) null, headers);
//        ResponseEntity<Environment> exchange = restTemplate.exchange("http://127.0.0.1:8888/" + name+"/"+profile+"/master", HttpMethod.GET, entity,
//                Environment.class, args);
//        Environment environment = exchange.getBody();
//        return environment.getName()+"/"+environment.getPropertySources()+"/"+environment.getLabel();
        return sign;
    }
}
