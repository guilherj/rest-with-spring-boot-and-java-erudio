package br.com.erudio.dto.v2;

import java.io.Serializable;
import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@EqualsAndHashCode
public class PersonDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private Long id;

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
	
	@Getter
	@Setter
	private Date birthDay;

}
