package sberjv3.unit.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import sberjv3.service.SavingsAccountService;
import sberjv3.web.controller.RateController;
import sberjv3.web.dto.RateCalculationRequest;

import java.time.LocalDate;

import static com.google.common.truth.Truth.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RateControllerTests {
    @Mock
    private SavingsAccountService savingsAccountService;

    @InjectMocks
    private RateController rateController;

    @Test
    void calculateRateForUser1Test() throws Exception {
        RateCalculationRequest request = new RateCalculationRequest(LocalDate.parse("2026-07-10"), "1");
        when(savingsAccountService.calculateRate(any(), any())).thenReturn(16.0);

        ResponseEntity<Double> response = rateController.calculate(request);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(16.0);
    }

    @Test
    void calculateRateForUser2Test() throws Exception {
        RateCalculationRequest request = new RateCalculationRequest(LocalDate.parse("2026-07-10"), "2");
        when(savingsAccountService.calculateRate(any(), any())).thenReturn(12.0);

        ResponseEntity<Double> response = rateController.calculate(request);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(12.0);
    }

    @Test
    void calculateRateForUser3Test() throws Exception {
        RateCalculationRequest request = new RateCalculationRequest(LocalDate.parse("2026-07-10"), "3");
        when(savingsAccountService.calculateRate(any(), any())).thenReturn(10.0);

        ResponseEntity<Double> response = rateController.calculate(request);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(10.0);
    }
}
