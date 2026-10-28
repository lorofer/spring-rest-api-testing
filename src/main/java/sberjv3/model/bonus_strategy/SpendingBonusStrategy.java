package sberjv3.model.bonus_strategy;

import org.springframework.stereotype.Component;
import sberjv3.model.Client;

import java.util.List;

@Component
public class SpendingBonusStrategy implements BonusStrategy {
    private static final List<SpendingRateBonus> RATE_BONUSES = List.of(
            new SpendingRateBonus(50000.0, 4.0),
            new SpendingRateBonus(30000.0, 2.0)
    );

    private SpendingRateBonus calculateCurrentBonus(double lastMonthExpenses) {
        for (SpendingRateBonus spendingRateBonus : RATE_BONUSES) {
            if (lastMonthExpenses >= spendingRateBonus.minSpending()) {
                return spendingRateBonus;
            }
        }

        return new SpendingRateBonus(0.0, 0.0);
    }

    @Override
    public double calculatePercentForClient(Client client) {
        SpendingRateBonus bonus = calculateCurrentBonus(client.getLastMonthExpenses());
        return bonus.percent();
    }
}
