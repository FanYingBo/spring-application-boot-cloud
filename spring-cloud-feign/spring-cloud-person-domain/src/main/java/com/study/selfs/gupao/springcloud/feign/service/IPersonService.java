package com.study.selfs.gupao.springcloud.feign.service;

import com.study.selfs.gupao.springcloud.feign.domain.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * {@link Person}
 */
@FeignClient(value = "${service.provider.name}")
public interface IPersonService {

    @RequestMapping(value = "/say",method = RequestMethod.GET)
    String sayHello();

    @RequestMapping(value = "/person/save", method = RequestMethod.GET,consumes = "application/json")
    boolean save(@RequestBody  Person person);

    @RequestMapping(value = "/person/get",method = RequestMethod.GET)
    Collection<Person> findAll();

}
