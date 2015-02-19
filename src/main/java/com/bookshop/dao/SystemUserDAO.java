/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookshop.dao;

import com.bookshop.domain.SystemUser;

/**
 *
 * @author giuliano
 */
public interface SystemUserDAO {
    
    public SystemUser listSystemUserByUserNo(Integer userNo);
    public SystemUser listSystemUserByUsernameAndPassword(String username, String password);
}
