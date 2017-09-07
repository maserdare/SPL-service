package strategy;

import db.Vozilo;
import db.VoziloDB;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mate
 */
public class ServiceStrategy implements StrategyInterface {

    @Override
    public String promjeniStatus(Vozilo vozilo, String status) {
        String redirectURL="lista_vozila.jsp";
        if (status.equalsIgnoreCase("Preuzeto")){
            VoziloDB dbOps = new VoziloDB();
            dbOps.izbrisiVozilo(vozilo.getBroj_sasije());
            redirectURL="ispisi_otpremnicu.jsp";
        }else if (status.equalsIgnoreCase("U servisu")){
            redirectURL="ispisi_radni_nalog.jsp";
        }
        return redirectURL;
    }

    @Override
    public List<String> dohvatiPopisStatusa() {
        List<String> popis = new ArrayList<>();
        popis.add("Lager");
        popis.add("U servisu");
        popis.add("Preuzeto");
        return popis;
    }
    
}
