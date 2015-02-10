/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookShop.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author giuliano
 */
@Entity
@Table(name = "SystemUsers", uniqueConstraints = {@UniqueConstraint(columnNames={"Username"})})
public class SystemUser implements java.io.Serializable {
    @Id
    @GeneratedValue
    @Column(name = "UserNo")
    private int userNo;
    @Column(name = "Username")
    private String username;
    @Column(name = "Password")
    private String password;

    public SystemUser()
    {
        
    }
    
    public SystemUser(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
    
    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }    
}
