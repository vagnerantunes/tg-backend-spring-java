package trabalho.graduacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import trabalho.graduacao.entities.Recebimento;

@Repository
public interface RecebimentoRepository extends JpaRepository<Recebimento, Integer>{

}
