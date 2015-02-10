/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookShop.action;

import com.bookShop.dao.BookDAO;
import com.bookShop.dao.BookDAOImpl;
import com.bookShop.dao.SystemUserDAO;
import com.bookShop.dao.SystemUserDAOImpl;
import com.bookShop.dbConnection.DBConnection;
import com.bookShop.domain.Book;
// import com.bookShop.dbConnection.DBConnection;
import com.bookShop.domain.SystemUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.ResultSet;
import java.util.List;
// import java.sql.ResultSet;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author giuliano
 */
public class LoginAction extends ActionSupport implements SessionAware{
    private String message;
    private String username;
    private String password;
    
    private Map<String, Object> session;
    
    private ResultSet rs;

    // private SystemUserDAO systemUserDAO = new SystemUserDAOImpl();
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public Map<String, Object> getSession() {
        return session;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    @Override
    public String execute() throws Exception {

        // SystemUser systemUser = systemUserDAO.listSystemUserByUsernameAndPassword(username, password);
           
        DBConnection db = new DBConnection();
        db.getConnection();
        String SQL = "select Username, Password from SystemUsers where Username = '" +
            username + "' and Password = '" + password + "'";
        System.out.println("SQL: " + SQL);
        rs = db.stmt.executeQuery(SQL);
        
        if (rs.next())
        // if (systemUser != null)
        {
            session = ActionContext.getContext().getSession();
            // session.put("username", systemUser.getUsername());
            session.put("username", rs.getString("Username"));
            
            db.removeConnection();
            
            return SUCCESS;
        }
        else
        {
            db.removeConnection();
            message = "Invalid username or password. Please try again";
            
            return ERROR;
        }
    }
}
