package ifma.edu.imobiliaria.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @GetMapping("/")
    public String hello() {
        return "Bem Vindo a API de IMOBILIARIA!!!";
    }
}
