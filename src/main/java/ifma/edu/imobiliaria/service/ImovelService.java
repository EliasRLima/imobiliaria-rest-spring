package ifma.edu.imobiliaria.service;

import ifma.edu.imobiliaria.model.Imovel;
import ifma.edu.imobiliaria.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImovelService {

    private final ImovelRepository imovelRepository;

    @Autowired
    public ImovelService(ImovelRepository imovelRepository){
        this.imovelRepository = imovelRepository;
    }

    public List<Imovel> todos(){ return  imovelRepository.findAll()}
}
