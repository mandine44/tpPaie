package dev.paie.entite;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "periode")
public class Periode {
	
	@Id
	private Integer id;
	
	@Column(name="date_debut")
	private LocalDate dateDebut;
	
	@Column(name="date_fin")
	private LocalDate dateFin;
	
	
	@OneToMany(mappedBy="periode")
	private	Set< BulletinSalaire > bulletins;
	
	public LocalDate getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	public LocalDate getDateFin() {
		return dateFin;
	}
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	

}
