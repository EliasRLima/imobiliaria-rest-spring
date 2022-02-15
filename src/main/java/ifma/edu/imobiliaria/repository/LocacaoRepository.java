package ifma.edu.imobiliaria.repository;

import ifma.edu.imobiliaria.model.Locacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocacaoRepository extends JpaRepository<Locacao, Long> {
    List<Locacao> findById_movelContaining(String id_imovel );
    Page<Locacao> findById_imovelContaining(String id_imovel, Pageable paginacao);
}
