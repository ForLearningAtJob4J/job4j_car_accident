<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
<head>
    <title>Accident App - Редактирование инцидента</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<div class="container pt-3">
    <form class="form-horizontal" action="<c:url value='/save'/>" method='POST'>
        <div class="form-group row mb-2">
            <label class="col-form-label col-sm-1" for="name">Название</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="name" id="name" value="${accident.name}"/>
            </div>
        </div>

        <div class="form-group row mb-2">
            <label class="col-form-label col-sm-1" for="text">Описание</label>
            <div class="col-sm-10">
                <textarea class="form-control" id="text" name="text" rows="5">${accident.text}</textarea>
            </div>
        </div>

        <div class="form-group row mb-2">
            <label class="col-form-label col-sm-1" for="address">Адрес</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" id="address" name="address" value="${accident.address}"/>
            </div>
        </div>

        <div class="form-group row mb-2">
            <div class="offset-md-1">
                <button type="submit" class="btn btn-primary">Сохранить</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>