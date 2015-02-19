<%-- 
    Document   : manageBooks
    Created on : Feb 8, 2015, 10:02:02 AM
    Author     : giuliano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/BookShop/css/stylesheet.css" type="text/css" rel="stylesheet">
        <title>BookShop - Manage Books</title>
        <s:head />
    </head>
    <body>
        <jsp:include page="header.jsp" />
        
        <table style="width: 100%">
            <tr>
                <td style="text-align: left; font:24px Georgia; color:#786e4e; height:37px;">
                    <label>Manage Books</label>
                </td>
                <td class="treb13blacknormal" valign="top" style="text-align: right">
                    <a href="showAddBooks.action"><img src="/BookShop/images/AddIcon.png" alt="Add Book"></a>
                </td>
            </tr>
        </table>
        
        <hr>
        <form action="doManageSearchBooks" method="post">            
            <table style="width: 100%">
                <tr>
                    <td style="width: 33%; text-align: left">
                        <label for="searchISBN" class="Arial13GrayB">ISBN:&nbsp;</label>
                        <input id="searchISBN" name="searchISBN" type="text"
                            placeholder="Enter the ISBN"
                            maxLength="15" size="30">
                    </td>
                    <td style="width: 33%; text-align: left">
                        <label for="searchBookName" class="Arial13GrayB">Book Name:&nbsp;</label>
                        <input id="searchBookName" name="searchBookName" type="text"
                            placeholder="Enter the Book Name"
                            maxLength="25" size="55">
                    </td>
                    <td style="width: 33%; text-align: right">
                        <label for="submit">Find</label>
                        <input id="submit" type="image" src="/BookShop/images/submit_bg.gif" alt="Submit">
                    </td>
                </tr>
            </table>
        </form>

        <s:if test="books.size() > 0">
            <table style="width: 100%">
                <tr>
                    <td style="width: 10%; text-align: center">&nbsp;</td>
                    <td style="width: 20%; text-align: left"><label class="Arial13BrownB">Book</label></td>
                    <td style="width: 20%; text-align: left"><label class="Arial13BrownB">ISBN</label></td>
                    <td style="width: 40%; text-align: left"><label class="Arial13BrownB">Synopsis</label></td>
                    <td style="width: 10%; text-align: left"><label class="Arial13BrownB">Author</label></td>
                </tr>
                
                <s:iterator value="books" status="stats">
                    <tr>
                        <td valign="top">
                            <a href="/BookShop/doDeleteBooks?bookNo=<s:property value='bookNo' />">
                                <img src="/BookShop/images/TrashIcon.png" alt="Delete" style="cursor: pointer" />
                            </a>
                        </td>
                        <td valign="top">
                            <a href="/BookShop/showEditBooks?bookNo=<s:property value='bookNo' />">
                                <label style="text-align: left; cursor: pointer"><s:property value="bookName" /></label>
                            </a>
                        </td>
                        <td valign="top">
                            <a href="/BookShop/showEditBooks?bookNo=<s:property value='bookNo' />">
                                <label style="text-align: left; cursor: pointer"><s:property value="isbn" /></label>
                            </a>
                        </td>
                        <td valign="top">
                            <a href="/BookShop/showEditBooks?bookNo=<s:property value='bookNo' />">
                                <label style="text-align: left; cursor: pointer"><s:property value="synopsis" /></label>
                            </a>
                        </td>
                        <td valign="top">
                            <a href="/BookShop/showEditBooks?bookNo=<s:property value='bookNo' />">
                                <label style="text-align: left; cursor: pointer"><s:property value="firstAuthor" /></label>
                            </a>
                        </td>
                    </tr>
                </s:iterator>
            </table>
        </s:if>
    </body>
</html>
