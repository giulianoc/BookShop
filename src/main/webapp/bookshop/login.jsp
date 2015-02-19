<%-- 
    Document   : login
    Created on : Feb 1, 2015, 4:55:08 PM
    Author     : giuliano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BookShop - Login</title>
        <!--
        <link href="/BookShop/css/stylesheet.css" type="text/css" rel="stylesheet">
        -->
        <s:head/>
    </head>
    <body>
        <form action="doLogin" method="post" style="text-align: center">            

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

            <div style="width: 400px; margin: 0 auto;">

                <s:property value="message"/>

                <div style="display: block; text-align: right">
                    <label for="username">Username</label>
                    <input id="username" name="username" style="margin: 5px" type="text" placeholder="Enter Username" required="true" >
                </div>
                <div style="display: block; paddding: 10px; text-align: right">
                    <label for="password">Password</label>
                    <input id="password" name="password" style="margin: 5px" type="password" placeholder="Enter Password" required="true" >
                </div>
                <div style="display: block; text-align: right">
                    <label for="submit">LOGIN</label>
                    <input id="submit" type="image" src="/BookShop/images/submit_bg.gif" alt="Submit">
                </div>
            </div>
        </form>
        
    </body>
</html>
