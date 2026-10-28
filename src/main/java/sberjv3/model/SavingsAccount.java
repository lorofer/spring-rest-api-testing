package sberjv3.model;

import lombok.AllArgsConstructor;
import sberjv3.model.bonus_strategy.BonusStrategy;

import java.util.List;

@AllArgsConstructor
public class SavingsAccount {
    private static final double BASE_RATE = 10.0;

    private final List<BonusStrategy> bonusStrategies;

    protected double getBaseRate() {
         return BASE_RATE;
    }

    public double calculateRatePercent(Client client) {
        double rate = getBaseRate();

        for (BonusStrategy bonus : bonusStrategies) {
            rate += bonus.calculatePercentForClient(client);
        }

        return rate;
    }
}
