
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>

<head>

    <style type="text/css">
                          .tg {
                              border-collapse: collapse;
                              border-spacing: 0;
                              border-color: #ccc;
                              display: inline;
                          }

    .tg td {
        font-family: Arial, sans-serif;
        font-size: 14px;
        padding: 10px 5px;
        border-style: solid;
        border-width: 1px;
        overflow: hidden;
        word-break: normal;
        border-color: #ccc;
        color: #333;
        background-color: #fff;

    }

    .tg th {
        font-family: Arial, sans-serif;
        font-size: 14px;
        font-weight: normal;
        padding: 10px 5px;
        border-style: solid;
        border-width: 1px;
        overflow: hidden;
        word-break: normal;
        border-color: #ccc;
        color: #333;
        background-color: #f0f0f0;
    }

    .tg .tg-4eph {
        background-color: #f9f9f9
    }
</style>
    <title>Excel report</title>
</head>

<body>

<table class="tg">
    <tr>
        <th width="120">Name</th>
        <th width="120">Values</th>

    </tr>
    <c:forEach items="${val}" var="valmap">

            <tr>
                <td>${valmap.key}</td>
                <td>${valmap.value}</td>
            </tr>

    </c:forEach>

</table>
<table class="tg">
    <tr>
        <th width="120">Interaction</th>

    </tr>
    <c:forEach items="${inter}" var="intmap">

        <tr>
            <td>${intmap.value}</td>
        </tr>

    </c:forEach>

</table>

</body>
</html>