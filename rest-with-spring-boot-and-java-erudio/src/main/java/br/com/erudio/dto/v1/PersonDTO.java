package br.com.erudio.dto.v1;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@EqualsAndHashCode
@JsonPropertyOrder({"id", "address", "first_name", "last_name", "gender"}) //Serve para alterar a ordem de exibição dos campos na serialização do JSON
public class PersonDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	@JsonProperty("first_name") //Serve para alterar o nome do atributo que é serializado no JSON
	private String first_name;

	@Getter
	@Setter
	@JsonProperty("last_name") //Serve para alterar o nome do atributo que é serializado no JSON
	private String last_name;

	@Getter
	@Setter
	private String address;

	@Getter
	@Setter
	@JsonIgnore // Serve para ocultar o atributo na serialização do JSON.
	private String gender;

}
