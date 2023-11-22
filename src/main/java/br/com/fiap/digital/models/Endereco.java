package br.com.fiap.digital.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "TB_DIGITAL_ENDERECO")
@SequenceGenerator(name = "digital_endereco", sequenceName = "SQ_TB_DIGITAL_ENDERECO", allocationSize = 1)
public class Endereco {
	@Id
	@GeneratedValue(generator = "digital_endereco", strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	public String Logradouro;
	@NotNull
	public int Numero;
	@NotNull
	public String Bairro;
	@NotNull
	public String Cidade;
	@NotNull
	public String Estado;
	@NotNull
	public String Cep;
}
