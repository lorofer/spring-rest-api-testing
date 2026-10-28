package sberjv3.unit.model;

import org.junit.jupiter.api.Test;
import sberjv3.model.Client;
import sberjv3.model.SavingsAccount;
import sberjv3.model.bonus_strategy.BonusStrategy;
import sberjv3.model.bonus_strategy.SberPrimeBonusStrategy;
import sberjv3.model.bonus_strategy.SpendingBonusStrategy;

import java.util.List;

import static com.google.common.truth.Truth.*;

class SavingsAccountTests {
	private static final List<BonusStrategy> bonusStrategy = List.of(
			new SberPrimeBonusStrategy(),
			new SpendingBonusStrategy()
	);

	@Test
	void calculateRatePercentSberPrimeAnd50000Spend() {
		Client client = new Client(true, 50000.0);
		SavingsAccount savingsAccount = new SavingsAccount(bonusStrategy);

		double rate = savingsAccount.calculateRatePercent(client);

		assertThat(rate).isEqualTo(16.0);
	}

	@Test
	void calculateRatePercentSberPrimeAnd30000Spend() {
		Client client = new Client(true, 30000.0);
		SavingsAccount savingsAccount = new SavingsAccount(bonusStrategy);

		double rate = savingsAccount.calculateRatePercent(client);

		assertThat(rate).isEqualTo(14.0);
	}

	@Test
	void calculateRatePercent30000Spend() {
		Client client = new Client(false, 30000.0);
		SavingsAccount savingsAccount = new SavingsAccount(bonusStrategy);

		double rate = savingsAccount.calculateRatePercent(client);

		assertThat(rate).isEqualTo(12.0);
	}

	@Test
	void calculateRatePercentSberPrimeAnd15000Spend() {
		Client client = new Client(true, 15000.0);
		SavingsAccount savingsAccount = new SavingsAccount(bonusStrategy);

		double rate = savingsAccount.calculateRatePercent(client);

		assertThat(rate).isEqualTo(12.0);
	}

	@Test
	void calculateRatePercent15000Spend() {
		Client client = new Client(false, 15000.0);
		SavingsAccount savingsAccount = new SavingsAccount(bonusStrategy);

		double rate = savingsAccount.calculateRatePercent(client);

		assertThat(rate).isEqualTo(10.0);
	}
}
