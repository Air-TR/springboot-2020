package com.tr.springboot.jpa.controller;

import com.tr.springboot.jpa.entity.Car;
import com.tr.springboot.jpa.jpa.CarJpa;
import com.tr.springboot.web.common.exception.MyException;
import io.swagger.annotations.Api;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * 该类的返回结果会被自动封装成 Result 类型，因为在 ControllerResponseAdvice 中配置
 *
 * @Author TR
 * @date 2022/7/9 上午10:35
 */
@Api(tags = "Car")
@RestController
public class CarController {

    @Resource
    CarJpa carJpa;

    @PostMapping("/car/save")
    public Car save(@RequestBody Car car) {
        return carJpa.save(car); // 若是新增，Jpa 会自动为 Car 创建 uuid 主键
    }

    /** Jpa 分页查询 */
    @GetMapping("/cars/page/{page}/{size}")
    public Page<Car> findAllByPage(@PathVariable Integer page, @PathVariable Integer size) {
        if (page < 1) {
            throw new MyException("page 不能小于 1");
        }
        return carJpa.findAll(PageRequest.of(page - 1, size)); // Page 查询中 0 代表第一页，所以要拿实际 page 减 1
    }

    /** Jpa 排序查询（通过 sort） */
    @GetMapping("/cars/sort/price/desc")
    public List<Car> findAllSortByPriceDesc() {
        return carJpa.findAll(Sort.by(Sort.Direction.DESC, "price"));
    }

    /** Jpa 排序查询（通过自定义方法） */
    @GetMapping("/cars/order-by/price/desc")
    public List<Car> findAllByOrderByPriceDesc() {
        return carJpa.findAllByOrderByPriceDesc();
    }

    @GetMapping("/car/{carId}")
    public Car findById(@PathVariable String carId) {
        Optional<Car> optional = carJpa.findById(carId);
        return optional.isPresent() ? optional.get(): null;
    }

    @GetMapping("/car/name/{name}")
    public Car findByName(@PathVariable String name) {
        return carJpa.findByName(name);
    }

    @GetMapping("/cars/brand/{brand}")
    public List<Car> findAllByBrand(@PathVariable String brand) {
        return carJpa.findAllByBrand(brand);
    }

    @GetMapping("/cars/all")
    public List<Car> findAll() {
        return carJpa.findAll();
    }

}
