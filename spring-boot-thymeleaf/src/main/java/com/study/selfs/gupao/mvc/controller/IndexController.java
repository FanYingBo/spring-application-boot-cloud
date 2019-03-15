package com.study.selfs.gupao.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class IndexController {
    /**
     * @param model
     * @return
     */
    @GetMapping({"/",""})
    public String index(Model model){
        model.addAttribute("string",new StringUtil());
        return "index";
    }
    private static class StringUtil{
        public StringUtil(){

        }
        public boolean isNotBlank(String value){
            return StringUtils.hasText(value);
        }
    }
    @ModelAttribute(name="message")
    public String getMessage(){
        String  message = "hello thymeleaf";
        return message;
    }



}


