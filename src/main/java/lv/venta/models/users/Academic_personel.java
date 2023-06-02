package lv.venta.models.users;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lv.venta.enums.Grade;

@Setter
@Getter
@Entity
@Table(name="personel_table")
public class Academic_personel extends Person{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_personel;
	
	@Column(name="grade")
	private Grade grade;

}
