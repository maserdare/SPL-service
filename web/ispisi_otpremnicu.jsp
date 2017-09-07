<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/spl_style.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="js/jspdf.min.js"></script>
        <script type="text/javascript" src="js/from_html.js"></script>
        <script type="text/javascript" src="js/split_text_to_size.js"></script>
        <script type="text/javascript" src="js/spl_js.js"></script>
        <title>Otpremnica</title>
    </head>
    <body>
        <h1>Otpremnica za vozilo: ${vozilo.tip} ${vozilo.model}</h1><br /><br />
        <p><%= new java.text.SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date()) %></p>
        <table border=1>
            <thead>
                <tr>
                    <th>Broj sasije</th>
                    <th>Tip</th>
                    <th>Model</th>
                    <th>Godina</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${vozilo.broj_sasije}</td>
                    <td>${vozilo.tip}</td>
                    <td>${vozilo.model}</td>
                    <td>${vozilo.godina}</td>
                </tr>
            </tbody>
        </table>
        <br />
        <h1>Cijena radova: <input id="extra" type="text" value=""  /></h1>
        <br />
        <a id="ignore" href="#" onclick="spl_to_pdf();return false;">Preuzmi PDF</a>
        <a id="ignore_2" href="vozilaController?action=pregled_vozila">Povratak na lager listu</a>
    </body>
</html>