package ifma.edu.imobiliaria.repository;

import ifma.edu.imobiliaria.model.Locacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocacaoRepository extends JpaRepository<Locacao, Long> {
    List<Locacao> findByImovelContaining(String id_imovel );
    Page<Locacao> findByImovelContaining(String id_imovel, Pageable paginacao);
}
