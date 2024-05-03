package dev.lucasmachado.attusprocessoseletivo.config;

import dev.lucasmachado.attusprocessoseletivo.services.CaseTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("actions")
public class ActionsConfig {

    @Autowired
    private CaseTestService caseTestService;
    @Bean
    public boolean iniatilizeCaseTests() {
        caseTestService.initializeCaseTests();
        return true;
    }
}
