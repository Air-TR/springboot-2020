package com.tr.springboot.jpa.jpa;

import com.tr.springboot.jpa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonJpa extends JpaRepository<Person, Integer> {
}
