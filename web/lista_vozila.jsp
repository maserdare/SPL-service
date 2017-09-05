<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/spl_style.css" rel="stylesheet" type="text/css">
<title>Lista vozila</title>
</head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>Broj sasije</th>
                <th>Tip</th>
                <th>Model</th>
                <th>Godina</th>
                <th>Status</th>
                <th colspan=2>Aktivnosti</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${vozila}" var="vozilo">
                <tr>
                    <td>${vozilo.getBroj_sasije()}</td>
                    <td>${vozilo.tip}</td>
                    <td>${vozilo.model}</td>
                    <td>${vozilo.godina}</td>
                    <td>${vozilo.status}</td>
                    <td><a href="vozilaController?action=uredi&broj_sasije=${vozilo.broj_sasije}">Uredi</a></td>
                    <td><a href="vozilaController?action=change_status&broj_sasije=${vozilo.broj_sasije}">Promjeni status</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="vozilaController?action=dodaj_vozilo">Dodaj vozilo na lager</a></p>
</body>
</html>
