package sberjv3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sberjv3.model.Client;
import sberjv3.model.SavingsAccountForSalaryClient;
import sberjv3.model.bonus_strategy.BonusStrategy;
import sberjv3.service.client.ClientService;
import sberjv3.service.operations.OperationsService;
import sberjv3.model.SavingsAccount;

import java.util.List;

@Service
// TODO: выделить интерфейс сервиса для соблюдения Dependency Inversion Principle
public class SavingsAccountService {
    @Autowired
    private ClientService clientService;

    @Autowired
    private OperationsService operationsService;

    @Autowired
    private List<BonusStrategy> bonusStrategy;

    private SavingsAccount createSavingsAccount(String type) {
        if (type.equals("Salary")) {
            return new SavingsAccountForSalaryClient(bonusStrategy);
        }
        return new SavingsAccount(bonusStrategy);
    }

    public double calculateRate(String userId, String type) {
        Client client = clientService.getById(userId);

        SavingsAccount savingsAccount = createSavingsAccount(type);
        return savingsAccount.calculateRatePercent(client);
    }
}
