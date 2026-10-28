package sberjv3.web.dto;

import java.time.LocalDate;

public record RateCalculationRequest(LocalDate accountOpenDate, String clientId, String type) {
    public RateCalculationRequest(LocalDate accountOpenDate, String clientId) {
        this(accountOpenDate, clientId, "Savings");
    }
}
