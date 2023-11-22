package br.com.fiap.digital.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_DIGITAL_USUARIO")
@SequenceGenerator(name = "digital_usuario", sequenceName = "SQ_TB_DIGITAL_USUARIO", allocationSize = 1)
public class Usuario {
	@Id
	@GeneratedValue(generator = "digital_usuario", strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String nome;
	@NotNull
	private String sobrenome;
	@NotNull
	private double peso;
	@NotNull
	private double altura;
	@OneToOne(cascade = CascadeType.MERGE)
	private Login login;
	@OneToOne(cascade = CascadeType.MERGE)
	private Endereco endereco;
	@ManyToOne(cascade = CascadeType.MERGE)
	private Contato contato;
}
