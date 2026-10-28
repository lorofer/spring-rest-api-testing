package sberjv3.service.operations;

import org.springframework.stereotype.Service;

@Service
public class OperationsServiceImpl implements OperationsService {
    @Override
    public double calculateLastMonthExpenses(String userId) {
        return 50000.0;
    }
}
