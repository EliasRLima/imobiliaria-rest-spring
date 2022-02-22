package ifma.edu.imobiliaria.service;

import ifma.edu.imobiliaria.model.Locacao;
import ifma.edu.imobiliaria.repository.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class LocacaoService {

    private final LocacaoRepository locacaoRepository;

    @Autowired
    public LocacaoService(LocacaoRepository locacaoRepository){
        this.locacaoRepository = locacaoRepository;
    }

    public List<Locacao> todos() {
        return locacaoRepository.findAll();
    }

    public Optional<Locacao> buscaPor(long id) {
        return locacaoRepository.findById((id));
    }

    @Transactional
    public Locacao salva(Locacao locacao) {
        return locacaoRepository.save(locacao);
    }

    @Transactional
    public void removePelo(long id) {
        locacaoRepository.deleteById((id));
    }

}
