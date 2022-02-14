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
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/imoveis")
public class ImovelController {

    private final ImovelService imovelService;

    public  ImovelController(ImovelService imovelService){
        this.imovelService = imovelService;
    }

    @GetMapping
    public Page<Imovel> lista(@RequestParam(required = false) String nome,
                               @PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 5)
                                       Pageable paginacao) {
        if (nome == null) {
            Page<Imovel> pageImovel = imovelService.buscaCom(paginacao );
            return pageImovel;
        } else {
            Page<Imovel> pageImovel = imovelService.buscaPor(nome, paginacao );
            return pageImovel;
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Imovel> buscaPor(@PathVariable Integer id) {
        Optional<Imovel> optional = imovelService.buscaPor(id);

        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Imovel> cadastro(@RequestBody @Valid Imovel imovel,
                                            UriComponentsBuilder builder) {

        final Imovel imovelSalvo = imovelService.salva(imovel);
        final URI uri = builder
                .path("/imoveis/{id}")
                .buildAndExpand(imovelSalvo.getId()).toUri();

        return ResponseEntity.created(uri).body(imovelSalvo );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Imovel> atualiza(@PathVariable Integer id,
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

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Integer id) {
        Optional<Imovel> optional = imovelService.buscaPor(id );

        if (optional.isPresent()) {
            imovelService.removePelo(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Imovel> atualizacaoParcial(@PathVariable Integer id,
                                                      @RequestBody Map<String, Object> campos) {
        Optional<Imovel> optional = imovelService.buscaPor(id);

        if (optional.isPresent()) {
            Imovel imovelAtual = optional.get();

            merge(campos, imovelAtual );
            return this.atualiza(id, imovelAtual );

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private void merge(Map<String, Object> campos, Imovel imoveleDestino) {
        ObjectMapper objectMapper = new ObjectMapper();
        Imovel imovelOrigem = objectMapper.convertValue(campos, Imovel.class );

        campos.forEach((nomePropriedade, valorPropriedade) -> {
            Field field = ReflectionUtils.findField(Imovel.class, nomePropriedade );
            field.setAccessible(true );

            Object novoValor = ReflectionUtils.getField(field, imovelOrigem );

            ReflectionUtils.setField(field, imovelOrigem, novoValor );
        });
    }
}
