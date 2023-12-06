package com.tr.springboot.recursion.selection;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

/**
 * 级联选择
 * @Author: TR
 */
@Data
@Entity
public class Selection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ApiModelProperty(value = "名称")
    @Column(nullable = false)
    private String name;
    @ApiModelProperty(value = "类型")
    private String type;
    @ApiModelProperty(value = "父级 id")
    private Long parentId;

    @Transient
    @ApiModelProperty(value = "子集")
    private List<Selection> children;
    @Transient
    @ApiModelProperty(value = "总名称（xxx/xxx/xxx）")
    private String allName;

}
