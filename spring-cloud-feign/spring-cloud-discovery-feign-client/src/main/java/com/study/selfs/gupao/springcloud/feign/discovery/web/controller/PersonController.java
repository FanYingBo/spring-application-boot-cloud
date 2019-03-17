package com.study.selfs.gupao.springcloud.feign.discovery.web.controller;

import com.study.selfs.gupao.springcloud.feign.domain.Person;
import com.study.selfs.gupao.springcloud.feign.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class PersonController implements IPersonService {


    private final IPersonService personService;
    @Autowired
    public PersonController(IPersonService personService) {
        this.personService = personService;
    }


    @Override
    public String sayHello() {
        return personService.sayHello();
    }

    @Override
    public boolean save(@RequestBody Person person) {
        return personService.save(person);
    }

    @Override
    public Collection<Person> findAll() {
        return personService.findAll();
    }
}
