package sberjv3.model.bonus_strategy;

import org.springframework.stereotype.Component;
import sberjv3.model.Client;

@Component
public class SberPrimeBonusStrategy implements BonusStrategy {
    private static final double BONUS_PERCENT = 2.0;

    @Override
    public double calculatePercentForClient(Client client) {
        if (client.isSberPrimeActive()) {
            return BONUS_PERCENT;
        }
        return 0.0;
    }
}
