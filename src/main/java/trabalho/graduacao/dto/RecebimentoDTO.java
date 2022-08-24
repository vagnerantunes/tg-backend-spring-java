package trabalho.graduacao.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RecebimentoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer recId;

	private String recDescricao;
	
	private Double recValor;
	
	private Integer recVenda;

	private Integer recCliente;

}
