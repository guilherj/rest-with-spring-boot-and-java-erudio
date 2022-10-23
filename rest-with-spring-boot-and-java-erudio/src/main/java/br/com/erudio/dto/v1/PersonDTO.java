package br.com.erudio.dto.v1;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@EqualsAndHashCode
@JsonPropertyOrder({"id", "firstName", "lastName", "address", "gender"})
public class PersonDTO extends RepresentationModel<PersonDTO> implements Serializable {

	private static final long serialVersionUID = 1L;

	/* Anotação que diz qual atributo do outro objeto este representará,
	 * Neste caso o atributo key representa o id do objeto Person. Se os atributos não forem com nomes iguais
	 * não é possivel fazer o mapping. Essa anotação resolve esse problema.
	 */
	@Mapping("id") 
	@JsonProperty("id") //Renomeia o nome do atributo no JSON de Response
	@Getter
	@Setter
	private Long key;

	@Getter
	@Setter
	private String firstName;

	@Getter
	@Setter
	private String lastName;

	@Getter
	@Setter
	private String address;

	@Getter
	@Setter
	private String gender;

}
