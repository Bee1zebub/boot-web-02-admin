package com.atguigu.admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@TableName(excludeProperty = {"userName","password"})
@TableName("user_tbl")
public class User {

    //默认所有属性都应该存在在数据库中
    //使用注解@TableField或@TableName(excludeProperty = {"userName","password"})
    @TableField(exist = false)
    private String userName;
    @TableField(exist = false)
    private String password;

    //以下是数据库的字段
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
