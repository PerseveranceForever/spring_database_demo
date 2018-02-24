package com.example.mybayis.domain;

import java.io.Serializable;

/**
 * @Author 落叶飞翔的蜗牛
 * @Date 2018/2/24
 * @Description
 */
public class PersonVO implements Serializable {
    private static final long serialVersionUID = -5554561712056198940L;

    private Integer id;

    private String name;

    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
