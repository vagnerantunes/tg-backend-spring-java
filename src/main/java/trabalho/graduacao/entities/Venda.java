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
public class Venda implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(length = 11, name = "VEN_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer venId;
	
	@NotNull 
	@Column(name = "VEN_QTD") 
	private Double venQtd;
	
	@Column(length = 45, name = "VEN_OBSERVACAO") 
	private String venObservacao;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "VEN_PRO_ID")
	private Produto venProduto;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "VEN_CLI_ID")
	private Cliente venCliente;
	
}