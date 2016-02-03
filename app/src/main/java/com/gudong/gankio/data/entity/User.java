package com.gudong.gankio.data.entity;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by rmtic on 2016/1/21.
 * 用户模型
 */
@Table(name = "user")
public class User extends Soul{

    public User(String cellphone, String password) {
        this.cellphone = cellphone;
        this.password = password;
    }

    @Column(name = "name")
    public String name;
    @Column(name = "cellphone")
    public String cellphone;
    @Column(name = "password")
    public String password;
    @Column(name = "sex")
    public int sex;
    @Column(name = "phoneType")
    public int phoneType;
    @Column(name = "storeStatus")
    public int storeStatus;
    @Column(name = "datetime")
    public String datetime;
    @Column(name = "picture")
    public String picture;

}
