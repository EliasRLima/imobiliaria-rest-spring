package ifma.edu.imobiliaria.service;

import ifma.edu.imobiliaria.model.Aluguel;
import ifma.edu.imobiliaria.repository.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {

    private final AluguelRepository aluguelRepository;

    @Autowired
    public AluguelService(AluguelRepository aluguelRepository){
        this.aluguelRepository = aluguelRepository;
    }

    public List<Aluguel> todos() {
        return aluguelRepository.findAll();
    }

    public Optional<Aluguel> buscaPor(long id) {
        return aluguelRepository.findById(id);
    }

    @Transactional
    public Aluguel salva(Aluguel aluguel) {
        return aluguelRepository.save(aluguel);
    }

    @Transactional
    public void removePelo(long id) {
        aluguelRepository.deleteById(id);
    }


}
