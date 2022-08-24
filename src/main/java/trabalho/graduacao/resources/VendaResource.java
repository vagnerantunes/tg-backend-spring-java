package trabalho.graduacao.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import trabalho.graduacao.dto.VendaDTO;
import trabalho.graduacao.dto.VendaNewDTO;
import trabalho.graduacao.entities.Venda;
import trabalho.graduacao.servives.VendaService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/vendas")
public class VendaResource {
	
	@Autowired
	private VendaService service;
	
	@GetMapping
	public ResponseEntity<List<Venda>> findAll(){
		List<Venda> list = service.findAll();
		return ResponseEntity.ok().body(list);		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Venda> findById(@PathVariable Integer id){
		Venda obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> save (@RequestBody @Valid VendaNewDTO vendaNewDTO){
		Venda venda = service.insert(vendaNewDTO);
		//boas praticas, ao inserir um recurso retornar sua URI (endereco) onde foi inserido
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(venda.getVenId()).toUri(); 
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update (@PathVariable Integer id, @RequestBody @Valid VendaDTO vendaDTO){
		service.update(id, vendaDTO);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.ok().build();
	}

}
