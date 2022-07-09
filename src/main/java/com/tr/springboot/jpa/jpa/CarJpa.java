package com.tr.springboot.jpa.jpa;

import com.tr.springboot.jpa.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarJpa extends JpaRepository<Car, String> {

    Car findByName(String name);

    List<Car> findAllByBrand(String brand);

    /** 重点：findAll 后面的 By 不能丢。（findAllOrderByPriceDesc 这个写法错误）*/
    List<Car> findAllByOrderByPriceDesc();

}
