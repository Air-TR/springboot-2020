package com.tr.springboot.jpa.controller;

import com.tr.springboot.jpa.entity.Person;
import com.tr.springboot.jpa.jpa.PersonJpa;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PersonController {

    @Resource
    PersonJpa personJpa;

    @GetMapping("/person/save")
    public Person save() {
        Person person = new Person();
        return personJpa.save(person);
    }

    @GetMapping("/person/update/{id}")
    public Person update(@PathVariable int id) {
        Person person = personJpa.findById(id).get();
        person.setAge(2);
        return personJpa.save(person);
    }

    @GetMapping("/person/{id}")
    public Person getById(@PathVariable int id) {
//        Optional<Person> optional = personJpa.findById(id);
//        return optional.isPresent() ? optional.get(): null;
        return personJpa.findById(id).get();
    }

}
