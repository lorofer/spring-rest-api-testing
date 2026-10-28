package sberjv3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Client {
    private boolean sberPrimeActive;
    private double lastMonthExpenses;
}
