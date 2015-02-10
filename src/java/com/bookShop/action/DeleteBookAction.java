/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookShop.action;

import com.bookShop.dao.BookDAO;
import com.bookShop.dao.BookDAOImpl;
import com.bookShop.dbConnection.DBConnection;
import com.bookShop.domain.Book;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author giuliano
 */
public class DeleteBookAction extends ActionSupport{
    private int bookNo;
    
    private BookDAO bookDAO = new BookDAOImpl();

    public int getBookNo() {
        return bookNo;
    }

    public void setBookNo(int bookNo) {
        this.bookNo = bookNo;
    }

    @Override
    public String execute() throws Exception {
        Book book = new Book();
        book.setBookNo(bookNo);
        
        bookDAO.deleteBook(book);
        
        /*
        DBConnection db = new DBConnection();
        db.getConnection();
        String SQL = "DELETE FROM Books WHERE BookNo ="+bookNo;
        db.stmt.executeUpdate(SQL);
        db.removeConnection();
        */

        return SUCCESS;
    }

    
}
