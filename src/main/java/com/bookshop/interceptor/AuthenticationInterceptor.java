/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookshop.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import java.util.Map;

/**
 *
 * @author giuliano
 */
public class AuthenticationInterceptor implements Interceptor{

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        Map session = actionInvocation.getInvocationContext().getSession();
        if (session.get("username") == null) {
            return "loginAction";
        }
        else {
            return actionInvocation.invoke();
        }        
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init() {
    }
    
}
