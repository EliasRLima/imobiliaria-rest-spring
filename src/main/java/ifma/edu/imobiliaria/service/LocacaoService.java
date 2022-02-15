package ifma.edu.imobiliaria.service;

import ifma.edu.imobiliaria.model.Locacao;
import ifma.edu.imobiliaria.repository.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Optional<Locacao> buscaPor(Integer id) {
        return locacaoRepository.findById(Long.valueOf(id));
    }

    public List<Locacao> buscaPor(Integer id_imovel) {
        return locacaoRepository.findById_imovelContaining(id_imovel);
    }

    public Page<Locacao> buscaPor(Integer id_imovel, Pageable paginacao) {
        return locacaoRepository.findById_imovelContaining(id_imovel, paginacao);
    }

    @Transactional
    public Locacao salva(Locacao locacao) {
        return locacaoRepository.save(locacao);
    }


    @Transactional
    public void removePelo(Integer id) {
        locacaoRepository.deleteById(Long.valueOf(id));
    }

    public Page<Locacao> buscaCom(Pageable paginacao) {
        return locacaoRepository.findAll(paginacao );
    }
}
