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
public class RecebimentoNewDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String recDescricao;

	private Double recValor;

	private Integer recVenda;

	private Integer recCliente;

}
