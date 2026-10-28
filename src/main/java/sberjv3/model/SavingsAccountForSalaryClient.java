package sberjv3.model;

import sberjv3.model.bonus_strategy.BonusStrategy;

import java.util.List;

public class SavingsAccountForSalaryClient extends SavingsAccount {
    public SavingsAccountForSalaryClient(List<BonusStrategy> bonusStrategies) {
        super(bonusStrategies);
    }

    @Override
    protected double getBaseRate() {
        return 12.0;
    }
}
