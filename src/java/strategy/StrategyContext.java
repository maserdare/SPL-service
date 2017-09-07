package strategy;

import db.Vozilo;
import java.util.List;

/**
 *
 * @author Mate
 */
public class StrategyContext {
    private StrategyInterface strategy;
    public void setStrategy(StrategyInterface strategy) {
        this.strategy = strategy;
    }
    
    public List<String> dohvatiListuStatusa() {
        return strategy.dohvatiPopisStatusa();
    }
    
    public String promjeniStatusVozila(Vozilo vozilo, String status) {
        return strategy.promjeniStatus(vozilo, status);
    }
}
