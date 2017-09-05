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
    public void promjeniStatus(Vozilo vozilo, String status) {
        if (status.equalsIgnoreCase("Preuzeto")){
            VoziloDB dbOps = new VoziloDB();
            dbOps.izbrisiVozilo(vozilo.getBroj_sasije());
        }
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
