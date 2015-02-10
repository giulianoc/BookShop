<%-- 
    Document   : updateBooks
    Created on : Feb 8, 2015, 3:20:55 PM
    Author     : giuliano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/BookShop/css/stylesheet.css" type="text/css" rel="stylesheet">
        <title>BookShop - Edit Books</title>
        <s:head />
    </head>
    <body>
        <jsp:include page="header.jsp" />
        
        <table style="width: 100%">
            <tr>
                <td style="text-align: left; font:24px Georgia; color:#786e4e; height:37px;">
                    <label>Edit Books</label>
                </td>
                <td class="treb13blacknormal" valign="top" style="text-align: right">
                    <label>It is mandatory to enter information in all information <br>capture boxes which have a <span class="mandatory">*</span> adjacent</label>
                </td>
            </tr>
        </table>
        
        <hr>
        
        <form id="updateBooksForm" action="doUpdateBooks" method="post">
            <s:hidden name="bookNo" id="bookNo" />
            
            <fieldset>
                <legend class="Arial13BrownB">Book Details</legend>
                <table style="width: 100%">
                    <tr>
                        <td style="width: 10%">
                            <label for="bookName">Book Name</label>
                        </td>
                        <td>
                            <input id="bookName" name="bookName" type="text"
                                placeholder="Enter the Book Name" required="true"
                                value="<s:property value='bookName' />"
                                maxLength="25" size="55">
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 10%">
                            <label for="publisherName">Publisher Name</label>
                        </td>
                        <td>
                            <input id="publisherName" name="publisherName" type="text"
                                placeholder="Enter the Publisher Name" required="true"
                                value="<s:property value='publisherName' />"
                                maxLength="25" size="55">
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 10%">
                            <label for="category">Category</label>
                        </td>
                        <td>
                            <input id="category" name="category" type="text"
                                placeholder="Enter the Category Name" required="true"
                                value="<s:property value='category' />"
                                maxLength="25" size="55">
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 10%">
                            <label for="isbn">ISBN</label>
                        </td>
                        <td>
                            <input id="isbn" name="isbn" type="text"
                                placeholder="Enter the ISBN" required="true"
                                value="<s:property value='isbn' />"
                                maxLength="15" size="30">
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 10%">
                            <label for="edition">Edition</label>
                        </td>
                        <td>
                            <input id="edition" name="edition" type="text"
                                placeholder="Enter the Edition of the book" required="true"
                                value="<s:property value='edition' />"
                                maxLength="25" size="55">
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 10%">
                            <label for="year">Year</label>
                        </td>
                        <td>
                            <input id="year" name="year" type="text"
                                placeholder="Enter the Year" required="true"
                                value="<s:property value='year' />"
                                maxLength="4" size="4">
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 10%">
                            <label for="cost">Cost</label>
                        </td>
                        <td>
                            <input id="cost" name="cost" type="text"
                                placeholder="Enter the Cost of the book" required="true"
                                value="<s:property value='cost' />"
                                maxLength="8" size="8">
                        </td>
                    </tr>
                </table>
            </fieldset>

            <fieldset>
                <legend class="Arial13BrownB">Author Details</legend>
                <table style="width: 100%">
                    <tr>
                        <td style="width: 10%">
                            <label for="firstAuthor">First Author</label>
                        </td>
                        <td>
                            <input id="firstAuthor" name="firstAuthor" type="text"
                                placeholder="Enter the Name of the Author" required="true"
                                value="<s:property value='firstAuthor' />"
                                maxLength="25" size="55">
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 10%">
                            <label for="secondAuthor">Second Author</label>
                        </td>
                        <td>
                            <input id="secondAuthor" name="secondAuthor" type="text"
                                placeholder="Enter the Name of the Author"
                                 value="<s:property value='secondAuthor' />"
                               maxLength="25" size="55">
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 10%">
                            <label for="thirdAuthor">Third Author</label>
                        </td>
                        <td>
                            <input id="thirdAuthor" name="thirdAuthor" type="text"
                                placeholder="Enter the Name of the Author"
                                value="<s:property value='thirdAuthor' />"
                                maxLength="25" size="55">
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 10%">
                            <label for="fourthAuthor">Fourth Author</label>
                        </td>
                        <td>
                            <input id="fourthAuthor" name="fourthAuthor" type="text"
                                placeholder="Enter the Name of the Author"
                                value="<s:property value='fourthAuthor' />"
                                maxLength="25" size="55">
                        </td>
                    </tr>
                </table>
            </fieldset>

            <fieldset>
                <legend class="Arial13BrownB">Description</legend>
                <table style="width: 100%">
                    <tr>
                        <td style="width: 10%">
                            <label for="synopsis">Synopsis</label>
                        </td>
                        <td>
                            <textarea id="synopsis" name="synopsis"
                                placeholder="Enter the Synopsis" required="true"
                                cols="80" rows="5"><s:property value="synopsis" /></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 10%">
                            <label for="aboutAuthors">About Authors</label>
                        </td>
                        <td>
                            <textarea id="aboutAuthors" name="aboutAuthors"
                                placeholder="Enter the About Author details" required="true"
                                cols="80" rows="5"><s:property value="aboutAuthors" /></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 10%">
                            <label for="topicsCovered">Topics Covered</label>
                        </td>
                        <td>
                            <textarea id="topicsCovered" name="topicsCovered"
                                placeholder="Enter the Topics covered in the book"
                                cols="80" rows="5"><s:property value="topicsCovered" /></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 10%">
                            <label for="contentsCDROM">Contents Of CDROM</label>
                        </td>
                        <td>
                            <textarea id="contentsCDROM" name="contentsCDROM"
                                placeholder="Enter the content of the CDROM"
                                cols="80" rows="5"><s:property value="contentsCDROM" /></textarea>
                        </td>
                    </tr>
                </table>
            </fieldset>

            <div style="display: block; text-align: right">
                <label for="reset">Clear</label>
                <img src="/BookShop/images/submit_bg.gif" alt="Reset" onclick="document.getElementById('insertBooksForm').reset()">
<!--                <input id="reset" type="image" src="/BookShop/images/submit_bg.gif" alt="Reset" onclick="document.getElementById('insertBooksForm').reset()"> -->
                <label for="submit">Save</label>
                <input id="submit" type="image" src="/BookShop/images/submit_bg.gif" alt="Submit">
            </div>

            <hr>
        </form>
    </body>
</html>
