package ifma.edu.imobiliaria.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ifma.edu.imobiliaria.model.Cliente;
import ifma.edu.imobiliaria.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @RequestMapping( value = "/clientes", method = RequestMethod.GET)
    public List<Cliente> lista() {
        List<Cliente> pageClientes = clienteService.todos();
       return pageClientes;

    }

    @RequestMapping( value = "/clientes/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> buscaPor(@PathVariable(value = "id") long id) {
        Optional<Cliente> optional = clienteService.buscaPor(id);

        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/clientes", method =  RequestMethod.POST)
    public Cliente Post(@RequestBody @Valid Cliente cliente) {
        return clienteService.salva(cliente);
    }

    @RequestMapping(value = "/clientes/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Cliente> Put(@PathVariable(value = "id") long id,
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

    @RequestMapping(value = "/clientes/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> remover(@PathVariable(value = "id") long id) {
        Optional<Cliente> optional = clienteService.buscaPor(id );

        if (optional.isPresent()) {
            clienteService.removePelo(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

}
