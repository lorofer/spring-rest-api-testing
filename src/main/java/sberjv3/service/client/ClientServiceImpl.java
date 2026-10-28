package sberjv3.service.client;

import org.springframework.stereotype.Service;
import sberjv3.model.Client;

@Service
public class ClientServiceImpl implements ClientService {
    @Override
    public Client getById(String clientId) {
        return new Client(false, 50000.0);
    }

    @Override
    public boolean isSberPrimeActive(String userId) {
        return false;
    }
}
