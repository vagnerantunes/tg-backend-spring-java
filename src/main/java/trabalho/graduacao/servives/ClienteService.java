package trabalho.graduacao.servives;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trabalho.graduacao.entities.Cliente;
import trabalho.graduacao.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> findAll(){
		return repository.findAll();
	}
	
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.get();
		
	}
	
	public Cliente insert(Cliente obj) {
		return repository.save(obj);
		
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	@SuppressWarnings("deprecation")
	public Cliente update(Integer id, Cliente obj) {
		Cliente entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	private void updateData(Cliente entity, Cliente obj) {
		entity.setCliNome(obj.getCliNome());
		entity.setCliCpfCnpj(obj.getCliCpfCnpj());		
	}	


}
