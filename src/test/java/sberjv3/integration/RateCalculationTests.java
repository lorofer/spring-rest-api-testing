package sberjv3.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import sberjv3.model.Client;
import sberjv3.service.client.ClientService;
import sberjv3.service.operations.OperationsService;
import sberjv3.web.dto.RateCalculationRequest;
import tools.jackson.databind.ObjectMapper;

import java.time.LocalDate;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RateCalculationTests {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private ClientService clientService;

    @MockitoBean
    private OperationsService operationsService;

    @Test
    void rateCalculationTest() throws Exception {
        String userId = "1";
        RateCalculationRequest request = new RateCalculationRequest(LocalDate.parse("2026-10-12"), userId);
        Client client = new Client(true, 50000.0);
        when(clientService.getById(userId)).thenReturn(client);

        mvc.perform(
                post("/api/rate/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(16.0));
    }

    @Test
    void rateCalculationIncorrectTest() throws Exception {
        String userId = "1";
        RateCalculationRequest request = new RateCalculationRequest(LocalDate.parse("2026-10-12"), userId);
        Client client = new Client(true, 50000.0);
        when(clientService.getById(userId)).thenReturn(client);

        mvc.perform(
                        post("/api/rate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request))
                )
                .andExpect(status().isNotFound());
    }

    @Test
    void rateCalculationSalaryCorrectTest() throws Exception {
        String userId = "1";
        RateCalculationRequest request = new RateCalculationRequest(LocalDate.parse("2026-10-12"), userId, "Salary");
        Client client = new Client(true, 50000.0);
        when(clientService.getById(userId)).thenReturn(client);

        mvc.perform(
                        post("/api/rate/calculate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(18.0));
    }
}
