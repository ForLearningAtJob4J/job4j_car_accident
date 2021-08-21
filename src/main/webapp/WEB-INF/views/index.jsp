<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Accident App</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="container pt-3">
    <div class="info d-flex justify-content-end">
        <span>Login as: ${user.username}</span>=|=<a href="<c:url value='/logout'/>"> Выйти </a>
    </div>
    <div>
        <a href="<c:url value='/create'/>">Добавить инцидент</a>
    </div>
    <table class="table align-content-center table-bordered table-hover">
        <thead class="table-dark">
        <tr>
            <th scope="col">Название</th>
            <th scope="col">Тип</th>
            <th scope="col">Статьи</th>
            <th scope="col">Описание</th>
            <th scope="col">Адрес</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${accidents}" var="accident">
            <tr>
                <td>
                    <c:out value="${accident.name}"/>
                </td>
                <td>
                    <c:out value="${accident.type.name}"/>
                </td>
                <td>
                    <c:forEach var="rule" items="${accident.rules}" varStatus="cnt" >
                        <c:out value="${rule.name}"/>
                        <c:if test="${cnt.count != cnt.end}">
                            <br/>
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:out value="${accident.text}"/>
                </td>
                <td>
                    <c:out value="${accident.address}"/>
                </td>
                <td>
                    <a href="<c:url value='/update?id=${accident.id}'/>"><i class="fa fa-edit mr-3"></i></a>
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