package lv.venta.models.users;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lv.venta.models.Course;
import lv.venta.models.Thesis;

@Table(name = "student_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AttributeOverride(name = "id_person", column = @Column( name = "studentId"))
public class Student extends Person{
	
	
	//TODO izveidot Data JPA anotacijas
	//TODO izveidot validacijas anotacijas
	//TODO izveidot saistibu ar Course klasi ManyToMany
	
	@Column(name = "matriculaNo")
	@NotNull
	//@Size(min=8,max=20)
	@Pattern(regexp = "[0-9]{8,20}")
	private String matriculaNo;
	
	@Column(name = "isDebt")
	private boolean Debt;

	@ManyToMany
	@JoinTable(name = "student_debt_table",
	joinColumns = @JoinColumn(name = "course_id"),
	inverseJoinColumns = @JoinColumn(name = "person_id"))
	private Collection<Course> debtCourses = new ArrayList<>();
	
	@OneToMany(mappedBy = "student")
	private Collection<Thesis> thesis;
	
	public Student(
			@NotNull @Size(min = 3, max = 15) @Pattern(regexp = "[A-Z]{1}[a-z\\ ]+") String name,
			@NotNull @Size(min = 3, max = 15) @Pattern(regexp = "[A-Z]{1}[a-z\\ ]+") String surname,
			@Size(min = 12, max = 12) @NotNull @Pattern(regexp = "[0-9]{6}-[0-9]{5}\\ ]+", message = "Neatbilstoss personas kods") String personalCode,
			User user, @NotNull @Pattern(regexp = "[0-9]{8,20}") String matriculaNo, boolean debt) {
		super(name, surname, personalCode, user);
		this.matriculaNo = matriculaNo;
		Debt = debt;
	}

	
	
}
