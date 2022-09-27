package trabalho.graduacao.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Recebimento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 11, name = "REC_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer recId;
	
	@NotNull 
	@Column(length = 45, name = "REC_DESCRICAO") 
	private String recDescricao;
	
	@NotNull 
	@Column(name = "REC_VALOR") 
	private Double recValor;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "REC_VEN_ID")
	private Venda recVenda;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "REC_CLI_ID")
	private Cliente recCliente;

}
