package lv.venta.models.users;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Table(name = "user_table")
@Entity
@Data
public class User {

	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "user_id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;
	
	
	@Column(name = "user_password")
	@NotNull
	@Size(min = 3, max = 15)
	private String password;
	
	@Column(name = "user_email")
	@NotNull
	@Size(min = 3, max = 15)
	@Email
	private String email;
	
	

	public User(@NotNull @Size(min = 3, max = 15) String password,
			@NotNull @Size(min = 3, max = 15) @Email String email) {
		super();
		this.password = password;
		this.email = email;
	}
	
	
	
}
