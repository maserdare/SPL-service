package strategy;

import db.Vozilo;
import java.util.List;

/**
 *
 * @author Mate
 */
public interface StrategyInterface {
    public String promjeniStatus(Vozilo vozilo, String status);
    public List<String> dohvatiPopisStatusa();
}
