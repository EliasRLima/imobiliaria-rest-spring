package ifma.edu.imobiliaria.service;

import ifma.edu.imobiliaria.model.Imovel;
import ifma.edu.imobiliaria.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Optional<Imovel> buscaPor(long id) {
        return imovelRepository.findById(id);
    }

    public List<Imovel> buscaPor(String nome) {
        return imovelRepository.findByEnderecoContaining(nome);
    }

    @Transactional
    public Imovel salva(Imovel cliente) {
        return imovelRepository.save(cliente);
    }


    @Transactional
    public void removePelo(long id) {
        imovelRepository.deleteById((id));
    }
}
