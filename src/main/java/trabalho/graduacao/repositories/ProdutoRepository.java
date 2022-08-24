package trabalho.graduacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import trabalho.graduacao.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
