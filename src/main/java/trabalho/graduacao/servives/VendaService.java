package trabalho.graduacao.servives;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trabalho.graduacao.dto.VendaDTO;
import trabalho.graduacao.dto.VendaNewDTO;
import trabalho.graduacao.entities.Cliente;
import trabalho.graduacao.entities.Produto;
import trabalho.graduacao.entities.Venda;
import trabalho.graduacao.repositories.VendaRepository;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository repository;

	//listar todos
	public List<Venda> findAll() {
		return repository.findAll();
	}

	//listar por id
	public Venda findById(Integer id) {
		Optional<Venda> obj = repository.findById(id);
		return obj.get();
	}
	
	public Venda insert (VendaNewDTO vendaNewDTO) {
		Venda venda = fromDTO(vendaNewDTO);
		repository.save(venda);
		return venda;
	}
	
	
	public void delete(Integer id) {
		Optional<Venda> opt = repository.findById(id);
		
		opt.orElseThrow(() -> new EntityNotFoundException("Funcionario não encontrado!, ID: " + id));
		
		repository.deleteById(id);
	}
	
	
	public void update (Integer id, VendaDTO vendaDTO) {
		Venda venda = fromDTO(vendaDTO);
		Optional<Venda> opt = repository.findById(id);
		
		opt.orElseThrow(() -> new EntityNotFoundException("Funcionario não encontrado!, ID: " + id));
		
		venda.setVenId(id);
		repository.save(venda);
	}
	
	//utilitarios
	public Venda fromDTO(VendaNewDTO vendaNewDTO) {
		Produto produto = new Produto(vendaNewDTO.getVenProduto(), null, null);
		Cliente cliente = new Cliente(vendaNewDTO.getVenCliente(), null, null);
		Venda venda = new Venda(null, vendaNewDTO.getVenQtd(), 
				vendaNewDTO.getVenObservacao(), produto, cliente);
		return venda;
	}
	
	public Venda fromDTO(VendaDTO vendaDTO) {
		Produto produto = new Produto(vendaDTO.getVenProduto(), null, null);
		Cliente cliente = new Cliente(vendaDTO.getVenCliente(), null, null);
		Venda venda = new Venda(null, vendaDTO.getVenQtd(), 
				vendaDTO.getVenObservacao(), produto, cliente);
		return venda;
	}

}
