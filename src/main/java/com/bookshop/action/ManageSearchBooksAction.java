/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookshop.action;

// import com.bookshop.dbConnection.DBConnection;
import com.bookshop.domain.Book;
import com.bookshop.dao.BookDAO;
import com.bookshop.dao.BookDAOImpl;
import com.opensymphony.xwork2.ActionSupport;
// import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author giuliano
 */
public class ManageSearchBooksAction extends ActionSupport{
    private String searchISBN;
    private String searchBookName;
    private ArrayList<Book> books = new ArrayList<Book>();
    
    private BookDAO bookDAO = new BookDAOImpl();

    
    public String getSearchISBN() {
        return searchISBN;
    }

    public void setSearchISBN(String searchISBN) {
        this.searchISBN = searchISBN;
    }

    public String getSearchBookName() {
        return searchBookName;
    }

    public void setSearchBookName(String searchBookName) {
        this.searchBookName = searchBookName;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public String execute() throws Exception {
        
        List<Book> list = bookDAO.listBooks(searchBookName, searchISBN);
        
        for (Book book : list)
        {
            Book bk = new Book(book.getBookNo(), book.getBookName(), book.getPublisherName(),
                book.getCategory(), book.getISBN(), book.getEdition(), book.getFirstAuthor(),
                book.getSecondAuthor(), book.getThirdAuthor(), book.getFourthAuthor(),
                book.getSynopsis(), book.getAboutAuthors(), book.getTopicsCovered(),
                book.getContentsCDROM(), book.getYear(), book.getCost());
            books.add(bk);
        }
        /*
        DBConnection db = new DBConnection();
        db.getConnection();
        String SQL = "";
        if (searchISBN == null) {
            SQL = "SELECT * FROM Books WHERE BookName LIKE '%" + searchBookName + "%'";
        } else if(searchBookName == null) {
            SQL = "SELECT * FROM Books WHERE ISBN LIKE '%" + searchISBN + "%'";
        } else if(searchBookName != null && searchISBN != null) {
            SQL = "SELECT * FROM Books WHERE ISBN LIKE '%" + searchISBN + "%' AND BookName LIKE '%" + searchBookName + "%'";
        }
        System.out.println(SQL);
        ResultSet rs = db.stmt.executeQuery(SQL);
        while(rs.next()){
            Book bk = new Book(rs.getInt("BookNo"), rs.getString("BookName"), rs.getString("PublisherName"), rs.getString("Category"), rs.getString("ISBN"), rs.getString("Edition"), rs.getString("FirstAuthor"), rs.getString("SecondAuthor"), rs.getString("ThirdAuthor"), rs.getString("FourthAuthor"), rs.getString("Synopsis"), rs.getString("AboutAuthors"), rs.getString("TopicsCovered"), rs.getString("ContentsCDROM"), rs.getInt("Year"), rs.getInt("Cost"));
            books.add(bk);
        }
        db.removeConnection();
        */

        
        return SUCCESS;
    }
    
}
