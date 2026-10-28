package sberjv3.service.client;

import sberjv3.model.Client;

public interface ClientService {
    Client getById(String clientId);

    boolean isSberPrimeActive(String userId);
}
