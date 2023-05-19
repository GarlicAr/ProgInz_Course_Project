package lv.venta.models.users;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Table(name = "person_table")
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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
	
	@OneToOne
	@JoinColumn(name = "id_user")
	private User user;

	public Person(@NotNull @Size(min = 3, max = 15) @Pattern(regexp = "[A-Z]{1}[a-z\\ ]+") String name,
			@NotNull @Size(min = 3, max = 15) @Pattern(regexp = "[A-Z]{1}[a-z\\ ]+") String surname,
			@Size(min = 12, max = 12) @NotNull @Pattern(regexp = "[0-9]{6}-[0-9]{5}\\ ]+", message = "Neatbilstoss personas kods") String personalCode,
			User user) {
		super();
		this.name = name;
		this.surname = surname;
		this.personalCode = personalCode;
		this.user = user;
	}
	
	


	
	
	
}
