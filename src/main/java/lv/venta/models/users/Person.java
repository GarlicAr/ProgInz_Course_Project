package lv.venta.models.users;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Table(name = "person_table")
@MappedSuperclass
@Data
public class Person {
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long personId;
	
	@Column(name = "name")
	@NotNull
	@Size(min = 3, max = 15)
	@Pattern(regexp = "[A-Z]{1}[a-z\\ ]+")
	private String name;
	
	@Column(name = "surname")
	@NotNull
	@Size(min = 3, max = 15)
	@Pattern(regexp = "[A-Z]{1}[a-z\\ ]+")
	private String surname;
	
	
	@Column(name = "personalCode")
	@Size(min = 12, max = 12)
	@NotNull
	@Pattern(regexp = "[0-9]{6}-[0-9]{5}\\ ]+", message = "Neatbilstoss personas kods")
	private String personalCode;
	
	

	public Person(@NotNull @Size(min = 3, max = 15) @Pattern(regexp = "[A-Z]{1}[a-z\\ ]+") String name,
			@NotNull @Size(min = 3, max = 15) @Pattern(regexp = "[A-Z]{1}[a-z\\ ]+") String surname) {
		this.name = name;
		this.surname = surname;
	}
	
	
	
	
}
