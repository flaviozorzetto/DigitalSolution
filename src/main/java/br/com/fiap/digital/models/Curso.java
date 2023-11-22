package br.com.fiap.digital.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Table(name = "TB_VLEARN_CURSO")
@SequenceGenerator(name = "vlearn_curso", sequenceName = "SQ_TB_VLEARN_CURSO", allocationSize = 1)
public class Curso {
	@Id
	@GeneratedValue(generator = "vlearn_curso", strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String nome;
	@NotNull
	private String descricao;
	@NotNull
	private Double preco;
	@NotNull
	private String autor;
	@NotNull
	private String duracao;
	@ManyToOne(cascade = CascadeType.MERGE)
	private Professor professor;
}
