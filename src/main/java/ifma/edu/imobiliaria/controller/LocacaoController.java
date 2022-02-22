package ifma.edu.imobiliaria.controller;

import ifma.edu.imobiliaria.model.Locacao;
import ifma.edu.imobiliaria.service.LocacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class LocacaoController {
    private final LocacaoService locacaoService;

    @Autowired
    public LocacaoController(LocacaoService locacaoService) {
        this.locacaoService = locacaoService;
    }

    @RequestMapping( value = "/locacoes", method = RequestMethod.GET)
    public List<Locacao> lista() {
        List<Locacao> pageClientes = locacaoService.todos();
        return pageClientes;

    }

    @RequestMapping( value = "/locacoes/{id}", method = RequestMethod.GET)
    public ResponseEntity<Locacao> buscaPor(@PathVariable(value = "id") long id) {
        Optional<Locacao> optional = locacaoService.buscaPor(id);

        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/locacoes", method =  RequestMethod.POST)
    public Locacao Post(@RequestBody @Valid Locacao locacao) {
        return locacaoService.salva(locacao);
    }

    @RequestMapping(value = "/locacoes/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Locacao> Put(@PathVariable(value = "id") long id,
                                       @RequestBody @Valid Locacao locacao) {
        Optional<Locacao> optional = locacaoService.buscaPor(id);

        if (optional.isPresent()) {
            locacao.setId(id);
            Locacao locacaoAtualizado = locacaoService.salva(locacao);
            return ResponseEntity.ok(locacaoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/locacoes/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> remover(@PathVariable(value = "id") long id) {
        Optional<Locacao> optional = locacaoService.buscaPor(id );

        if (optional.isPresent()) {
            locacaoService.removePelo(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
