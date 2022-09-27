package trabalho.graduacao.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VendaNewDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Double venQtd;

	private String venObservacao;

	private Integer venProduto;

	private Integer venCliente;

}
