package com.source.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * springboot的数据效验
 */
@Data
public class User {

    @NotNull(message = "id不能为空")
    private int id;
    @NotEmpty(message = "姓名不能为空")
    @Length(min=2,message = "姓名长度不能小于2")
    private String name;
    @Min(value = 0,message = "年龄必须大于16岁")
    private double score;



}
