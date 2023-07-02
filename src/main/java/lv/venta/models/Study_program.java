package lv.venta.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "studyprogram_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Study_program {
	
	@Column(name = "StudyProgram_id")
	@Id
	@Setter(value = AccessLevel.NONE)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long studyProgram_id;
	
	@Column(name = "Faculty")
	@Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burtam jābūt lielajam")
	private String faculty;
	
	@Column(name = "Level")
	@Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ0-9.]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burtam jābūt lielajam")
	private String level;
	
	@Column(name = "Title")
	@Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burtam jābūt lielajam")
	private String title;

	public Study_program(
			@Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burtam jābūt lielajam") String faculty,
			@Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ0-9.]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burtam jābūt lielajam") String level,
			@Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burtam jābūt lielajam") String title) {
		super();
		this.faculty = faculty;
		this.level = level;
		this.title = title;
	}
	
	
	
	
	
	
}
