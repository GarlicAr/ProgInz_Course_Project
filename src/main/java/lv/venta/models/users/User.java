package lv.venta.models.users;

import jakarta.persistence.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Jābūt vismaz 8 simbolus garai.\r\n"
			+ "Jāsatur vismaz viena maza burta rakstzīme.\r\n"
			+ "Jāsatur vismaz viena liela burta rakstzīme.\r\n"
			+ "Jāsatur vismaz viena cipara rakstzīme.\r\n"
			+ "Jāsatur vismaz viena īpaša rakstzīme (@, $, !, %, *, ?, &).")
	@NotNull
	private String password;
	
	@Column(name = "email")
	@Pattern(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}", message = "Pirmajam burtam jābūt mazajam")
	@NotNull
	private String email;
	
	@OneToOne(mappedBy = "user")
	@ToString.Exclude
	private Person person;
	
	

	public User(@NotNull String password,
			@NotNull @Size(min = 3, max = 15) String email) {
		
		setPassword(password);
		this.email = email;
		
	}
	

	
	public void setPassword(String password) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		this.password = passwordEncoder.encode(password);
		
	}
	
	
	
}
