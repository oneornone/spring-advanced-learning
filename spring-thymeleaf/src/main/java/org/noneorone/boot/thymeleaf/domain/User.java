package org.noneorone.boot.thymeleaf.domain;

import org.springframework.util.StringUtils;

import java.io.Serializable;

public class User implements Serializable {

    private String account;
    private String pwd;

    private String sid;

    public User() {
    }

    public User(String account, String pwd) {
        super();
        this.account = account;
        this.pwd = pwd;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Boolean isGuest() {
        return !StringUtils.isEmpty(this.account) && "666666".equals(this.pwd);
    }
}
