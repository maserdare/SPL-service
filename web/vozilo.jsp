<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/spl_style.css" rel="stylesheet" type="text/css">
        <title>Dodaj vozilo</title>
    </head>
    <body>
        <form method="POST" action='vozilaController' name="frmVozilo">
            <% String action = request.getParameter("action"); %>
            <% if (action.equalsIgnoreCase("uredi")) {%>
            Broj šasije :<br /> <input type="text" name="broj_sasije" value="${vozilo.broj_sasije}" readonly="readonly"/><br /> 
            <%} else {%>
            Broj šasije :<br /> <input type="text" name="broj_sasije" value="${vozilo.broj_sasije}" /> <br />
            <%}%>
            Tip <br /> <input type="text" name="tip" value="${vozilo.tip}"  /> <br /> 
            Model :<br /> <input type="text" name="model" value="${vozilo.model}" /> <br /> 
            Godina :<br /> <input type="text" name="godina" value="${vozilo.godina}" /> <br /> 
            Cijena :<br /> <input type="text" name="cijena" value="${vozilo.cijena}" /> <br /> 
            Status :<br /> <input type="text" name="status" value="${vozilo.status}" readonly="readonly" /> <br /> 
            <input  type="submit" value="Potvrdi" />
        </form>
    </body>
</html>
