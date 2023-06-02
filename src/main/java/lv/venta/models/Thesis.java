package lv.venta.models;

import java.time.LocalDateTime;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lv.venta.enums.Degree;
import lv.venta.enums.Status;

/*
 * 
 * 
 * 
 * 
 * 
 * 
 */


@Setter
@Getter
@Entity
@Table(name="thesis_table")
@NoArgsConstructor
public class Thesis {
	
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "thesis_id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long thesis_id;
	
	
	//TODO pieviento validacijas	
	@Column(name = "TitleLv")
	private String titleLv;
	
	//TODO pieviento validacijas
	@Column(name = "TitleEn")
	private String titleEn;
	
	//TODO pieviento validacijas	
	@Column(name = "aim")
	private String aim;
		
	//TODO pieviento validacijas
	@Column(name = "tasks")
	private String tasks;
	
	//TODO pie jauna objekta izveides jauzliek LocalDateTime.now()
	@Column(name = "SubmitDate" )
	private LocalDateTime submitDate;
	
	@Column(name = "StatussFromSupervisors")
	private boolean statusFromSupervisor;
	
	//TODO uzlikt Submitted as default
	@Column(name = "Status")
	private Status status;
	
	@Column(name = "Accepted_Time")
	private LocalDateTime acceptedDate;
	
	
	
	
	
	
	

}
