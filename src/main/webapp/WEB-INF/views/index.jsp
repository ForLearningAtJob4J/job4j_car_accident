<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Accident App</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<div class="container pt-3">
    <div>
        <a href="<c:url value='/create'/>">Добавить инцидент</a>
    </div>
    <table class="table align-content-center table-bordered">
        <thead class="table-dark">
        <tr>
            <th scope="col">Заголовок</th>
            <th scope="col">Описание</th>
            <th scope="col">Адрес</th>
        </tr>
        </thead>
        <tbody class="table-hover">
        <c:forEach items="${list}" var="accident">
            <tr>
                <td>
                    <c:out value="${accident.value.name}"/>
                </td>
                <td>
                    <c:out value="${accident.value.text}"/>
                </td>
                <td>
                    <c:out value="${accident.value.address}"/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
</body>
</html>