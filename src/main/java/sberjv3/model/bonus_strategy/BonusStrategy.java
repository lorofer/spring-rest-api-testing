package sberjv3.model.bonus_strategy;

import sberjv3.model.Client;

/**
 * Класс, представляющий стратегию повышения ставки по вкладу.
 */
public interface BonusStrategy {
    /**
     * Определяет, на сколько должна быть повышена ставка по счету для клиента.
     *
     * @param client клиент, по которому принимается решение о повышении ставки.
     * @return на сколько процентов должна быть повышена ставка (если ставка не должна быть повышена, следует вернуть 0).
     */
    double calculatePercentForClient(Client client);
}
