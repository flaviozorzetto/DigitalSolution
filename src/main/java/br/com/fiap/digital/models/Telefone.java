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
@Table(name = "TB_VLEARN_TELEFONE")
@SequenceGenerator(name = "vlearn_telefone", sequenceName = "SQ_TB_VLEARN_TELEFONE", allocationSize = 1)
public class Telefone {
	@Id
	@GeneratedValue(generator = "vlearn_telefone", strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String ddd;
	@NotNull
	private int ddi;
	@NotNull
	private String nr_telefone;
}
