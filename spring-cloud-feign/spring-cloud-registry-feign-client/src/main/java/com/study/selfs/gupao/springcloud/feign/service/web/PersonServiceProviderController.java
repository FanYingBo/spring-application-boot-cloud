package com.study.selfs.gupao.springcloud.feign.service.web;

import com.study.selfs.gupao.springcloud.feign.domain.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class PersonServiceProviderController{

    private ConcurrentHashMap<Integer,Person> persons = new ConcurrentHashMap<>();

    private AtomicInteger idGenerator = new AtomicInteger(1);

    @GetMapping("/say")
    public String sayHello() {
        return "hello";
    }

    @PostMapping("/person/save")
    public boolean save(@RequestBody Person person){
        int index = idGenerator.getAndIncrement();
        person.setId(index);
        return persons.put(index,person) == null;
    }

    @GetMapping("/person/get")
    public Collection<Person> findAll(){
        return persons.values();
    }

}
