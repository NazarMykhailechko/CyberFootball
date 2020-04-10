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

<br />
<a href="/add">Add new client</a>
<br />

<%--<td><form:label path = "season">Tournament</form:label></td>--%>
<%--<td>--%>
<form:form  modelAttribute="season" method="POST" action="/statistics">
  <form:select onchange="this.form.submit()" path="season" items="${tournaments}" />
</form:form>
<%--  <form:select onchange="window.location.href='/statistics'" path = "season">--%>
<%--    <form:option value = "NONE" label = "Select"/>--%>
<%--    <form:options items = "${tournaments}" />--%>
<%--  </form:select>--%>
<%--</td>--%>

<%--<label>--%>
<%--&lt;%&ndash;  <select id="mySelect" onchange="if (this.value) window.location.href='/statistics'">&ndash;%&gt;--%>

<%--<select id="mySelect" onchange="myFunction()">--%>
<%--    <c:if test="${!empty tournaments}">--%>

<%--      <c:forEach items="${tournaments}" var="tournament">--%>
<%--          <option value=${tournament.season}>${tournament.season}</option>--%>
<%--      </c:forEach>--%>
<%--    </c:if>--%>
<%--</select>--%>
<%--</label>--%>
<h3>Results:</h3>
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

<script>
  function myFunction() {
    let x = document.getElementById("mySelect").value;
    window.location.href='/statistics/' + x;
    // document.getElementById("demo").innerHTML = "You selected: " + x;
  }
</script>

</html>