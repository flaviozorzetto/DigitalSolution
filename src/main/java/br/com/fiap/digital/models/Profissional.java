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
@Table(name = "TB_DIGITAL_PROFISSIONAL")
@SequenceGenerator(name = "digital_profissional", sequenceName = "SQ_TB_DIGITAL_PROFISSIONAL", allocationSize = 1)
public class Profissional {
	@Id
	@GeneratedValue(generator = "digital_profissional", strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	public String Nome;
	@NotNull
	public String Sobrenome;
	@NotNull
	public String Especialidade;
	@NotNull
	public String Crm;
	@NotNull
	public String Cpf;
	@OneToOne(cascade = CascadeType.MERGE)
	private Login login;
	@OneToOne(cascade = CascadeType.MERGE)
	private Endereco endereco;
	@ManyToOne(cascade = CascadeType.MERGE)
	private Contato contato;
}
