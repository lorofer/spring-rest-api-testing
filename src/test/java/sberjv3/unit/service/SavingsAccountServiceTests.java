package sberjv3.unit.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import sberjv3.model.Client;
import sberjv3.model.bonus_strategy.BonusStrategy;
import sberjv3.model.bonus_strategy.SberPrimeBonusStrategy;
import sberjv3.model.bonus_strategy.SpendingBonusStrategy;
import sberjv3.service.client.ClientService;
import sberjv3.service.SavingsAccountService;

import java.util.List;

import static com.google.common.truth.Truth.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SavingsAccountServiceTests {
    @Mock
    ClientService clientService;

    @Spy
    List<BonusStrategy> bonusStrategy = List.of(
            new SberPrimeBonusStrategy(),
            new SpendingBonusStrategy()
    );

    @InjectMocks
    SavingsAccountService savingsAccountService;

    @Test
    void calculateRateForUser1() {
        String userId = "1";
        Client client = new Client(true, 50000.0);
        String type = "Savings";
        when(clientService.getById(userId)).thenReturn(client);

        double rate = savingsAccountService.calculateRate(userId, type);

        assertThat(rate).isEqualTo(16.0);
    }

    @Test
    void calculateRateForUser2() {
        String userId = "2";
        Client client = new Client(false, 30000.0);
        String type = "Savings";
        when(clientService.getById(userId)).thenReturn(client);

        double rate = savingsAccountService.calculateRate(userId, type);

        assertThat(rate).isEqualTo(12.0);
    }

    @Test
    void calculateRateForUser3() {
        String userId = "3";
        Client client = new Client(false, 15000.0);
        String type = "Savings";
        when(clientService.getById(userId)).thenReturn(client);

        double rate = savingsAccountService.calculateRate(userId, type);

        assertThat(rate).isEqualTo(10.0);
    }
}
