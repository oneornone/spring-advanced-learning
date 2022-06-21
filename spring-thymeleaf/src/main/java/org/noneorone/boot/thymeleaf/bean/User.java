package org.noneorone.boot.thymeleaf.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {
    /**
     * 主键
     */
    @Id // 指定主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键生成策略默认自增长
    private int id;

    /**
     * 姓名
     */
    private String username;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 性别
     */
    private char sex;

    /**
     * 年龄
     */
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
