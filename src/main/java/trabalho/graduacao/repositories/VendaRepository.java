package trabalho.graduacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import trabalho.graduacao.entities.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer>{

}