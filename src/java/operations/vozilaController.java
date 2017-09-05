/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import db.Vozilo;
import db.VoziloDB;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Malazan
 */
public class vozilaController extends HttpServlet {
    private VoziloDB voziloDB;
    
    public vozilaController() {
        super();
        voziloDB = new VoziloDB();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String redirect="";
        String action = request.getParameter("action");
 
        if (action.equalsIgnoreCase("change_status")){
            redirect = "promjena_statusa.jsp";
            String broj_sasije = request.getParameter("broj_sasije");
            Vozilo vozilo = voziloDB.getVoziloByBrojSasije(broj_sasije);
            request.setAttribute("vozilo", vozilo);
            request.setAttribute("statusi", voziloDB.dohvatiStatuse());
        } else if (action.equalsIgnoreCase("uredi")){
            redirect = "vozilo.jsp";
            String broj_sasije = request.getParameter("broj_sasije");
            Vozilo vozilo = voziloDB.getVoziloByBrojSasije(broj_sasije);
            request.setAttribute("vozilo", vozilo);
        } else if (action.equalsIgnoreCase("pregled_vozila")){
            redirect = "lista_vozila.jsp";
            request.setAttribute("vozila", voziloDB.getAllVozila());
        } else {
            redirect = "vozilo.jsp";
        }
 
        RequestDispatcher view = request.getRequestDispatcher(redirect);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Vozilo vozilo = new Vozilo();
        vozilo.setBroj_sasije(Integer.parseInt(request.getParameter("broj_sasije")));
        vozilo.setTip(request.getParameter("tip"));
        vozilo.setModel(request.getParameter("model"));
        vozilo.setGodina(request.getParameter("godina"));
        vozilo.setStatus(request.getParameter("status"));
        if(voziloDB.checkVozilo(vozilo)){
            voziloDB.editVozilo(vozilo);
            voziloDB.changeStatus(vozilo, request.getParameter("status"));
        }else{
            voziloDB.addVozilo(vozilo);
        }
        RequestDispatcher view = request.getRequestDispatcher("lista_vozila.jsp");
        request.setAttribute("vozila", voziloDB.getAllVozila());
        view.forward(request, response);
    }
}
