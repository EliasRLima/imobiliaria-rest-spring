package ifma.edu.imobiliaria.repository;

import ifma.edu.imobiliaria.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
