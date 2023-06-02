package lv.venta.models.users;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Table(name = "user_table")
@Entity
@Data
@NoArgsConstructor
public class User {

	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "id_user")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;
	
	
	@Column(name = "password")
	@NotNull
	@Size(min = 3, max = 15)
	private String password;
	
	@Column(name = "email")
	@NotNull
	@Size(min = 3, max = 15)
	@Email
	private String email;
	
	@OneToOne(mappedBy = "user")
	@ToString.Exclude
	private Person person;
	
	

	public User(@NotNull @Size(min = 3, max = 15) String password,
			@NotNull @Size(min = 3, max = 15) @Email String email) {
		
		this.password = password;
		this.email = email;
	}
	
	
	
}
