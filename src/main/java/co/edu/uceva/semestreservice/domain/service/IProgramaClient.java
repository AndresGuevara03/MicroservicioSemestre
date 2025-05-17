package co.edu.uceva.semestreservice.domain.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient(name = "programa-service")
public interface IProgramaClient {
    @GetMapping("api/v1/programa-service/programas")
    ResponseEntity<Map<String, Object>> getProgramas();
}
