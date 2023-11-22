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
@Table(name = "TB_VLEARN_PROFESSOR")
@SequenceGenerator(name = "vlearn_professor", sequenceName = "SQ_TB_VLEARN_PROFESSOR", allocationSize = 1)
public class Professor {
	@Id
	@GeneratedValue(generator = "vlearn_professor", strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String nome;
	@NotNull
	private String formacao;
	@NotNull
	private String experiencia;
	@NotNull
	private String idiomas;
	@NotNull
	private String status;
	@OneToOne(cascade = CascadeType.MERGE)
	private Login login;
	@ManyToOne(cascade = CascadeType.MERGE)
	private Telefone telefone;
}
