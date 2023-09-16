package pinetree.padroes.projeto.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pinetree.padroes.projeto.spring.models.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, String> {
}
