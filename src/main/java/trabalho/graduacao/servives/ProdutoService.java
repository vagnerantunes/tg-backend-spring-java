package trabalho.graduacao.servives;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trabalho.graduacao.entities.Produto;
import trabalho.graduacao.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	public List<Produto> findAll(){
		return repository.findAll();
	}
	
	public Produto findById(Integer id) {
		Optional<Produto> obj = repository.findById(id);
		return obj.get();
		
	}
	
	public Produto insert(Produto obj) {
		return repository.save(obj);
		
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	@SuppressWarnings("deprecation")
	public Produto update(Integer id, Produto obj) {
		Produto entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	private void updateData(Produto entity, Produto obj) {
		entity.setProDescricao(obj.getProDescricao());
		entity.setProPreco(obj.getProPreco());		
	}	

}
