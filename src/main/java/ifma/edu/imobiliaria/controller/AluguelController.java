package ifma.edu.imobiliaria.controller;

import ifma.edu.imobiliaria.model.Aluguel;
import ifma.edu.imobiliaria.service.AluguelService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class AluguelController {

    private final AluguelService aluguelService;

    @Autowired
    public AluguelController(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    @RequestMapping( value = "/alugueis", method = RequestMethod.GET)
    public List<Aluguel> lista() {
        List<Aluguel> pageAlugueis = aluguelService.todos();
        return pageAlugueis;

    }

    @RequestMapping( value = "/alugueis/{id}", method = RequestMethod.GET)
    public ResponseEntity<Aluguel> buscaPor(@PathVariable(value = "id") long id) {
        Optional<Aluguel> optional = aluguelService.buscaPor(id);

        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/alugueis", method =  RequestMethod.POST)
    public Aluguel Post(@RequestBody @Valid Aluguel aluguel) {
        return aluguelService.salva(aluguel);
    }

    @RequestMapping(value = "/alugueis/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Aluguel> Put(@PathVariable(value = "id") long id,
                                       @RequestBody @Valid Aluguel aluguel) {
        Optional<Aluguel> optional = aluguelService.buscaPor(id);

        if (optional.isPresent()) {
            aluguel.setId(id);
            Aluguel aluguelAtualizado = aluguelService.salva(aluguel);
            return ResponseEntity.ok(aluguelAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/alugueis/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> remover(@PathVariable(value = "id") long id) {
        Optional<Aluguel> optional = aluguelService.buscaPor(id );

        if (optional.isPresent()) {
            aluguelService.removePelo(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
