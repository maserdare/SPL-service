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
    
    public void promjeniStatusVozila(Vozilo vozilo, String status) {
        strategy.promjeniStatus(vozilo, status);
    }
}
