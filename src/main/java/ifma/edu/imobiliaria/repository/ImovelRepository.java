package ifma.edu.imobiliaria.repository;

import ifma.edu.imobiliaria.model.Imovel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long> {

    List<Imovel> findByEnderecoContaining(String endereco);
    Page<Imovel> findByEnderecoContaining(String endereco, Pageable pag);
}
