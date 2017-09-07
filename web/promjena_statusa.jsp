<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/spl_style.css" rel="stylesheet" type="text/css">
        <title>Promjena statusa</title>
    </head>
    <body>
        <form method="POST" action='vozilaController' name="frmStatus">
            Broj Šasije :<br /> <input type="text" name="broj_sasije" value="${vozilo.broj_sasije}" readonly="readonly"/><br /> 
            Tip :<br /> <input type="text" name="tip" value="${vozilo.tip}"  readonly="readonly"/> <br /> 
            Model :<br /> <input type="text" name="model" value="${vozilo.model}" readonly="readonly"/> <br /> 
            Godina :<br /> <input type="text" name="godina" value="${vozilo.godina}" readonly="readonly"/> <br /> 
            Cijena :<br /> <input type="text" name="cijena" value="${vozilo.cijena}" readonly="readonly"/> <br /> 
            Status :<br /> 
            <select name="status">
                <c:forEach items="${statusi}" var="status">
                    <option value="${status}">${status}</option>
            </c:forEach>
            </select> <br /> 
            <input  type="submit" value="Potvrdi" />
        </form>
    </body>
</html>
