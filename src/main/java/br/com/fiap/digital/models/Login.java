package br.com.fiap.digital.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
@Table(name = "TB_DIGITAL_LOGIN", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "email" }, name = "unique_email") })
@SequenceGenerator(name = "digital_login", sequenceName = "SQ_TB_DIGITAL_LOGIN", allocationSize = 1)
public class Login {
	@Id
	@GeneratedValue(generator = "digital_login", strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String email;
	@NotNull
	private String senha;
}
