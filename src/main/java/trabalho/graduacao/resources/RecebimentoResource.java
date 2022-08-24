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

import trabalho.graduacao.dto.RecebimentoDTO;
import trabalho.graduacao.dto.RecebimentoNewDTO;
import trabalho.graduacao.entities.Recebimento;
import trabalho.graduacao.servives.RecebimentoService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/recebimentos")
public class RecebimentoResource {
	
	@Autowired
	private RecebimentoService service;
	
	@GetMapping
	public ResponseEntity<List<Recebimento>> findAll(){
		List<Recebimento> list = service.findAll();
		return ResponseEntity.ok().body(list);		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Recebimento> findById(@PathVariable Integer id){
		Recebimento obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@PostMapping
	public ResponseEntity<Void> save (@RequestBody @Valid RecebimentoNewDTO recebimentoNewDTO){
		Recebimento recebimento = service.insert(recebimentoNewDTO);
		//boas praticas, ao inserir um recurso retornar sua URI (endereco) onde foi inserido
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(recebimento.getRecId()).toUri(); 
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update (@PathVariable Integer id, @RequestBody @Valid RecebimentoDTO recebimentoDTO){
		service.update(id, recebimentoDTO);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.ok().build();
		
	}

}
