package com.tr.springboot.jpa.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Entity、@Table 区别：
 *  @Entity 说明这个 class 是实体类，并且使用默认的 ORM 规则，即 class 名即数据库表中表名，class 属性名即表中的字段名；
 *  如果想改变这种默认的 ORM 规则，就要使用 @Table 来改变 class 名与表名的映射规则，@Column 来改变 class 属性名与字段名的映射规则
 *
 * @Author TR
 * @date 2022/7/9 上午10:17
 */
@Entity
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Car implements Serializable,Cloneable{

    /** 车辆ID */
    @Id
    @GeneratedValue(generator = "jpa-uuid") // Jpa 自动生成的 uuid 是 32 位
    private String carId ;
    /** 名称 */
    private String name ;
    /** 品牌 */
    private String brand ;
    /** 价格 */
    private Double price ;

    /** 车辆ID */
    public String getCarId(){
        return this.carId;
    }
    /** 车辆ID */
    public void setCarId(String carId){
        this.carId = carId;
    }
    /** 名称 */
    public String getName(){
        return this.name;
    }
    /** 名称 */
    public void setName(String name){
        this.name = name;
    }
    /** 品牌 */
    public String getBrand(){
        return this.brand;
    }
    /** 品牌 */
    public void setBrand(String brand){
        this.brand = brand;
    }
    /** 价格 */
    public Double getPrice(){
        return this.price;
    }
    /** 价格 */
    public void setPrice(Double price){
        this.price = price;
    }

}
