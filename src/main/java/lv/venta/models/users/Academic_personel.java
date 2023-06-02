package lv.venta.models.users;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lv.venta.enums.Degree;
import lv.venta.models.Thesis;

@Setter
@Getter
@Entity
@Table(name="personel_table")
@NoArgsConstructor
@AttributeOverride(name = "id_person", column = @Column(name = "id_personel"))
public class Academic_personel extends Person{
	
	
	@Column(name="degree")
	private Degree degree;
	
	@OneToMany(mappedBy = "personel")
	private Collection<Thesis> thesis;
	
	@ManyToMany(mappedBy = "reviewers")
	private Collection<Thesis> ThesisForReview = new ArrayList<>();

}
