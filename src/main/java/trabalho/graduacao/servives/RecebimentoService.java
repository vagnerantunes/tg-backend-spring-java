package trabalho.graduacao.servives;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trabalho.graduacao.dto.RecebimentoDTO;
import trabalho.graduacao.dto.RecebimentoNewDTO;
import trabalho.graduacao.entities.Cliente;
import trabalho.graduacao.entities.Recebimento;
import trabalho.graduacao.entities.Venda;
import trabalho.graduacao.repositories.RecebimentoRepository;

@Service
public class RecebimentoService {
	
	@Autowired
	private RecebimentoRepository repository;

	//listar todos
	public List<Recebimento> findAll() {
		return repository.findAll();
	}

	//listar por id
	public Recebimento findById(Integer id) {
		Optional<Recebimento> obj = repository.findById(id);
		return obj.get();
	}
	
	public Recebimento insert (RecebimentoNewDTO recebimentoNewDTO) {
		Recebimento recebimento = fromDTO(recebimentoNewDTO);
		repository.save(recebimento);
		return recebimento;
	}
	
	
	public void delete(Integer id) {
		Optional<Recebimento> opt = repository.findById(id);
		
		opt.orElseThrow(() -> new EntityNotFoundException("Funcionario não encontrado!, ID: " + id));
		
		repository.deleteById(id);
	}
	
	
	public void update (Integer id, RecebimentoDTO recebimentoDTO) {
		Recebimento recebimento = fromDTO(recebimentoDTO);
		Optional<Recebimento> opt = repository.findById(id);
		
		opt.orElseThrow(() -> new EntityNotFoundException("Funcionario não encontrado!, ID: " + id));
		
		recebimento.setRecId(id);
		repository.save(recebimento);
	}
	
	//utilitarios
	public Recebimento fromDTO(RecebimentoNewDTO recebimentoNewDTO) {		
		Venda venda = new Venda(recebimentoNewDTO.getRecVenda(), null, null, null, null);
		Cliente cliente = new Cliente(recebimentoNewDTO.getRecCliente(), null, null);
		Recebimento recebimento = new Recebimento(null, recebimentoNewDTO.getRecDescricao(), 
				recebimentoNewDTO.getRecValor(), venda, cliente);
		
		return recebimento;
	}
	
	public Recebimento fromDTO(RecebimentoDTO recebimentoDTO) {
		Venda venda = new Venda(recebimentoDTO.getRecVenda(), null, null, null, null);
		Cliente cliente = new Cliente(recebimentoDTO.getRecCliente(), null, null);
		Recebimento recebimento = new Recebimento(null, recebimentoDTO.getRecDescricao(), 
				recebimentoDTO.getRecValor(), venda, cliente);
		
		return recebimento;
	}

}
