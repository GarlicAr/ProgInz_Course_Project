package lv.venta.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lv.venta.models.users.Academic_personel;


@Table(name = "comment_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comments {
	
	
	@Column(name = "id_comment")
	@Id
	@Setter(value = AccessLevel.NONE)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long comment_id;
	
	@Column(name = "comment")
	private String text;
	
	@Column(name = "date")
	private LocalDateTime date;
	
	@ManyToOne
	@JoinColumn(name = "id_personel")
	private Academic_personel personel;
	
	@ManyToOne
	@JoinColumn(name = "thesis_id")
	private Thesis thesis;

	public Comments(String text, Academic_personel personel, Thesis thesis) {
		super();
		this.text = text;
		this.personel = personel;
		this.thesis = thesis;
		this.date = LocalDateTime.now();
	}
	
	
	
	

	

}
