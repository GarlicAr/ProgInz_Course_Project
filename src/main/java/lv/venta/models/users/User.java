package lv.venta.models.users;

import jakarta.persistence.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	private String password;
	
	@Column(name = "email")
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
