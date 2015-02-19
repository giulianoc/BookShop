/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookshop.dao;

import com.bookshop.domain.Book;
import java.util.List;

/**
 *
 * @author giuliano
 */
public interface BookDAO {
    public void saveBook(Book book);
    public void deleteBook(Book book);
    public List<Book> listBooks();
    public List<Book> listBooks(String bookNameCriteria, String isbnCriteria);
    public List<Book> listBooks(String searchCriteria);
    public Book listBookByBookNo(Integer bookNo);
}
