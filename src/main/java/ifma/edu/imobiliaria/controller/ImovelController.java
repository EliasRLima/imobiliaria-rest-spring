package ifma.edu.imobiliaria.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ifma.edu.imobiliaria.model.Imovel;
import ifma.edu.imobiliaria.service.ImovelService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.lang.reflect.Field;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class ImovelController {

    private final ImovelService imovelService;

    public  ImovelController(ImovelService imovelService){
        this.imovelService = imovelService;
    }

    @RequestMapping( value = "/imoveis", method = RequestMethod.GET)
    public List<Imovel> lista() {
        List<Imovel> pageImovel = imovelService.todos();
        return pageImovel;

    }

    @RequestMapping( value = "/imoveis/{id}", method = RequestMethod.GET)
    public ResponseEntity<Imovel> buscaPor(@PathVariable(value = "id") long id) {
        Optional<Imovel> optional = imovelService.buscaPor(id);

        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/imoveis", method =  RequestMethod.POST)
    public Imovel Post(@RequestBody @Valid Imovel imovel) {
        return imovelService.salva(imovel);
    }

    @RequestMapping(value = "/imoveis/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Imovel> Put(@PathVariable(value = "id") long id,
                                       @RequestBody @Valid Imovel imovel) {
        Optional<Imovel> optional = imovelService.buscaPor(id);

        if (optional.isPresent()) {
            imovel.setId(id);
            Imovel imovelAtualizado = imovelService.salva(imovel);
            return ResponseEntity.ok(imovelAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/imoveis/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> remover(@PathVariable(value = "id") long id) {
        Optional<Imovel> optional = imovelService.buscaPor(id );

        if (optional.isPresent()) {
            imovelService.removePelo(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
