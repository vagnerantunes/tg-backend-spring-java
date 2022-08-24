package trabalho.graduacao.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class VendaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer venId;
	
	private Double venQtd;
	
	private String venObservacao;
	
	private Integer venProduto;

	private Integer venCliente;
}
