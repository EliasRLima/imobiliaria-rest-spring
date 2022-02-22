package ifma.edu.imobiliaria.service;

import ifma.edu.imobiliaria.model.Cliente;
import ifma.edu.imobiliaria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> todos() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscaPor(long id) {
        return clienteRepository.findById(id);
    }

    public List<Cliente> buscaPor(String nome) {
        return clienteRepository.findByNomeContaining(nome);
    }

    @Transactional
    public Cliente salva(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void removePelo(long id) {
        clienteRepository.deleteById(id);
    }

}
