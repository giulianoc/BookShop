<%-- 
    Document   : menu
    Created on : Feb 7, 2015, 9:08:00 AM
    Author     : giuliano
--%>

<%@ taglib prefix="s" uri="/struts-tags" %>

<s:if test="((#session.username == '')">
    <% response.sendRedirect ("index.action"); %>
</s:if>

<table style="width: 100%">
    <tr>
        <td  class="menu" style="text-align: left; width: 70%">
            Hello, <s:property value="#session.username"/>
        </td>
        <td class="menu" style="text-align: center; width: 10%">
            <a href="showSearchBooks.action">Search Books</a> 
        </td>
        <td class="menu" style="text-align: center; width: 10%">
            <a href="showManageBooks.action">Manage Books</a> 
        </td>
        <td class="menu" style="text-align: center; width: 10%">
            <a href="doLogout.action">Logout</a> 
        </td>
    </tr>
</table>

<div id="title" style="text-align: center">
    <div>
        <img src="/BookShop/images/b.gif" alt="B">
        <img src="/BookShop/images/o1.gif" alt="B">
        <img src="/BookShop/images/o2.gif" alt="B">
        <img src="/BookShop/images/k.gif" alt="B">
        <img src="/BookShop/images/s.gif" alt="B">
        <img src="/BookShop/images/h.gif" alt="B">
        <img src="/BookShop/images/o2.gif" alt="B">
        <img src="/BookShop/images/p.gif" alt="B">
    </div>
</div>
