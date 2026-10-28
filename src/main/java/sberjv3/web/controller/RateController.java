package sberjv3.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sberjv3.model.SavingsAccount;
import sberjv3.service.SavingsAccountService;
import sberjv3.web.dto.RateCalculationRequest;

@RestController
@RequestMapping("/api/rate")
public class RateController {
    @Autowired
    SavingsAccountService savingsAccountService;

    @PostMapping("/calculate")
    public ResponseEntity<Double> calculate(@RequestBody RateCalculationRequest request) {
        double rate = savingsAccountService.calculateRate(request.clientId(), request.type());
        return ResponseEntity.ok(rate);
    }
}
