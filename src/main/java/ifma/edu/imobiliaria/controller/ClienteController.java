package ifma.edu.imobiliaria.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ifma.edu.imobiliaria.model.Cliente;
import ifma.edu.imobiliaria.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.lang.reflect.Field;
import java.net.URI;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public Page<Cliente> lista(@RequestParam(required = false) String nome,
                               @PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 5)
                               Pageable paginacao) {
        if (nome == null) {
            Page<Cliente> pageClientes = clienteService.buscaCom(paginacao );
            return pageClientes;
        } else {
            Page<Cliente> pageClientes = clienteService.buscaPor(nome, paginacao );
            return pageClientes;
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscaPor(@PathVariable Integer id) {
        Optional<Cliente> optional = clienteService.buscaPor(id);

        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastro(@RequestBody @Valid Cliente cliente,
                                            UriComponentsBuilder builder) {

        final Cliente clienteSalvo = clienteService.salva(cliente);
        final URI uri = builder
                .path("/clientes/{id}")
                .buildAndExpand(clienteSalvo.getId()).toUri();

        return ResponseEntity.created(uri).body(clienteSalvo );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualiza(@PathVariable Integer id,
                                            @RequestBody @Valid Cliente cliente) {
        Optional<Cliente> optional = clienteService.buscaPor(id);

        if (optional.isPresent()) {
            cliente.setId(id);
            Cliente clienteAtualizado = clienteService.salva(cliente);
            return ResponseEntity.ok(clienteAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Integer id) {
        Optional<Cliente> optional = clienteService.buscaPor(id );

        if (optional.isPresent()) {
            clienteService.removePelo(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Cliente> atualizacaoParcial(@PathVariable Integer id,
                                                      @RequestBody Map<String, Object> campos) {
        Optional<Cliente> optional = clienteService.buscaPor(id );

        if (optional.isPresent()) {
            Cliente clienteAtual = optional.get();

            merge(campos, clienteAtual );
            return this.atualiza(id, clienteAtual );

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private void merge(Map<String, Object> campos, Cliente clienteDestino) {
        ObjectMapper objectMapper = new ObjectMapper();
        Cliente clienteOrigem = objectMapper.convertValue(campos, Cliente.class );

        campos.forEach((nomePropriedade, valorPropriedade) -> {
            Field field = ReflectionUtils.findField(Cliente.class, nomePropriedade );
            field.setAccessible(true );

            Object novoValor = ReflectionUtils.getField(field, clienteOrigem );

            ReflectionUtils.setField(field, clienteDestino, novoValor );
        });
    }
}
