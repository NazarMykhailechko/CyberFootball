<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
  <style>
    .blue-button{
      background: #25A6E1;
      padding:3px 5px;
      color:#fff;
      font-family:'Helvetica Neue',sans-serif;
      font-size:12px;
      border-radius:2px;
      -moz-border-radius:2px;
      -webkit-border-radius:4px;
      border:1px solid #1A87B9
    }
    table {
      font-family: "Helvetica Neue", Helvetica, sans-serif;
      width: 50%;
    }
    th {
      background: SteelBlue;
      color: white;
    }
    td,th{
      border: 1px solid gray;
      width: 25%;
      text-align: left;
      padding: 5px 10px;
    }
  </style>
</head>
<body>
<h1>${season}</h1>
<h1>Statistics:</h1>
<c:if test="${!empty results}">
  <table class="tg">
    <tr>
      <th width="80">Season</th>
      <th width="120">Nick</th>
      <th width="400">Total</th>
      <th width="400">W</th>
      <th width="60">W%</th>
      <th width="600">D</th>
      <th width="600">D%</th>
      <th width="600">L</th>
      <th width="600">L%</th>
      <th width="600">TB</th>
      <th width="600">TB%</th>
      <th width="600">TM</th>
      <th width="600">TM%</th>

    </tr>
    <c:forEach items="${results}" var="result">
      <tr>
        <td>${result.season}</td>
        <td>${result.nick}</td>
        <td>${result.total}</td>
        <td>${result.w}</td>
        <td>${result.wp}</td>
        <td>${result.d}</td>
        <td>${result.dp}</td>
        <td>${result.l}</td>
        <td>${result.lp}</td>
        <td>${result.tb}</td>
        <td>${result.tbp}</td>
        <td>${result.tm}</td>
        <td>${result.tmp}</td>

      </tr>
    </c:forEach>
  </table>
</c:if>
</body>
</html>