package ifma.edu.imobiliaria.service;

import ifma.edu.imobiliaria.model.Aluguel;
import ifma.edu.imobiliaria.repository.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class AluguelService {

    private final AluguelRepository aluguelRepository;

    @Autowired
    public AluguelService(AluguelRepository aluguelRepository){
        this.aluguelRepository = aluguelRepository;
    }

    public List<Aluguel> todos() {
        return aluguelRepository.findAll();
    }

    public Optional<Aluguel> buscaPor(Integer id) {
        return aluguelRepository.findById(Long.valueOf(id));
    }

    @Transactional
    public Aluguel salva(Aluguel aluguel) {
        return aluguelRepository.save(aluguel);
    }

    @Transactional
    public void removePelo(Integer id) {
        aluguelRepository.deleteById(Long.valueOf(id));
    }

    public Page<Aluguel> buscaCom(Pageable paginacao) {
        return aluguelRepository.findAll(paginacao );
    }

}
