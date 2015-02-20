<%-- 
    Document   : searchBooks
    Created on : Feb 7, 2015, 9:05:59 AM
    Author     : giuliano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/BookShop/css/stylesheet.css" type="text/css" rel="stylesheet">

        <script src="/BookShop/js/jquery-1.11.2.min.js"></script>
        <!-- <link href="/BookShop/js/jQuery-Autocomplete-master/content/styles.css" type="text/css" rel="stylesheet"> -->
        <script src="/BookShop/js/jQuery-Autocomplete-master/dist/jquery.autocomplete.js"></script>

        <title>BookShop - Search Books</title>
    </head>
    <body>
        <script type="text/javascript">
            $(function(){
                var countries = [
                    { value: 'Andorra', data: 'AD' },
                    // ...
                    { value: 'Zimbabwe', data: 'ZZ' }
                 ];

                $('#search').autocomplete({
                    // lookup: countries,
                    serviceUrl: '/BookShop/ajaxAutoComplete.action',

                    paramName: 'searchCriteria',
                    dataType: 'json',
                    minChars: 3,
                    transformResult: function(response) {
                       var autoCompleteInfo = {
                            suggestions: $.map(response.books, function(dataItem) {
                               return { value: dataItem.bookName, data: dataItem.bookName };
                            })
                        };
                        
                        return autoCompleteInfo;
                    }

                    /*
                    onSelect: function (suggestion) {
                        alert('You selected: ' + suggestion.value + ', ' + suggestion.data);
                    }
                    */
                });
            });
        </script>
        
        <jsp:include page="header.jsp" />

        <form action="doSearchBooks" method="post" style="text-align: center">
            <div>
                <label for="search">Search:</label>
                <input id="search" style="width: 50%" name="searchCriteria" type="text" placeholder="Enter text to search" required="true"/>
            </div>
            <input style="margin: 20px" type="submit" value="BookShop Search">
        </form>
        
        <s:iterator value="books" status="stats">
            <fieldset>
                <legend style="text-align: left"><s:property value="#stats.count"/>.<s:property value="bookName" /></legend>
                <table width="100%">
                    <tr>
                        <td valign="top" style="text-align: right; width: 10%">
                            <label class="mandatory">Synopsis: </label>
                        </td>
                        <td valign="top" style="width: 90%">
                            <label class="Arial13GrayN"><s:property value="synopsis" /></label>
                        </td>
                    </tr>
                    <tr>
                        <td valign="top" style="text-align: right; width: 10%">
                            <label class="mandatory">About Authors:</label>
                        </td>
                        <td valign="top" style="width: 90%">
                            <label class="Arial13GrayN"><s:property value="aboutAuthors" /></label>
                        </td>
                    </tr>
                    <tr>
                        <td valign="top" style="text-align: right; width: 10%">
                            <label class="mandatory">ISBN:</label>
                        </td>
                        <td valign="top" style="width: 90%">
                            <label class="Arial13GrayN"><s:property value="ISBN" /></label>
                        </td>
                    </tr>
                    <tr>
                        <td valign="top" style="text-align: right; width: 10%">
                            <label class="mandatory">Cost:</label>
                        </td>
                        <td valign="top" style="width: 90%">
                            <label class="Arial13GrayN"><s:property value="cost" /></label>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </s:iterator>
    </body>
</html>
