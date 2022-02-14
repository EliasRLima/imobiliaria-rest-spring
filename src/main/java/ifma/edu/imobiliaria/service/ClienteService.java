package ifma.edu.imobiliaria.service;

import ifma.edu.imobiliaria.model.Cliente;
import ifma.edu.imobiliaria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import java.util.List;

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

    public Optional<Cliente> buscaPor(Integer id) {
        return clienteRepository.findById(Long.valueOf(id));
    }

    public List<Cliente> buscaPor(String nome) {
        return clienteRepository.findByNomeContaining(nome);
    }

    public Page<Cliente> buscaPor(String nome, Pageable paginacao) {
        return clienteRepository.findByNomeContaining(nome, paginacao);
    }

    @Transactional
    public Cliente salva(Cliente cliente) {
        return clienteRepository.save(cliente);
    }


    @Transactional
    public void removePelo(Integer id) {
        clienteRepository.deleteById(Long.valueOf(id));
    }

    public Page<Cliente> buscaCom(Pageable paginacao) {
        return clienteRepository.findAll(paginacao );
    }
}
