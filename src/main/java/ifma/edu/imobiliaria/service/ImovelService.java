package ifma.edu.imobiliaria.service;

import ifma.edu.imobiliaria.model.Imovel;
import ifma.edu.imobiliaria.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ImovelService {

    private final ImovelRepository imovelRepository;

    @Autowired
    public ImovelService(ImovelRepository imovelRepository){
        this.imovelRepository = imovelRepository;
    }

    public List<Imovel> todos(){ return  imovelRepository.findAll();}

    public Optional<Imovel> buscaPor(Integer id) {
        return imovelRepository.findById(Long.valueOf(id));
    }

    public List<Imovel> buscaPor(String nome) {
        return imovelRepository.findByEndContaining(nome);
    }

    public Page<Imovel> buscaPor(String nome, Pageable paginacao) {
        return imovelRepository.findByEndContaining(nome, paginacao);
    }

    @Transactional
    public Imovel salva(Imovel cliente) {
        return imovelRepository.save(cliente);
    }


    @Transactional
    public void removePelo(Integer id) {
        imovelRepository.deleteById(Long.valueOf(id));
    }

    public Page<Imovel> buscaCom(Pageable paginacao) {
        return imovelRepository.findAll(paginacao );
    }
}
