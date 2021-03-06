package dev.paie.entite;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cotisation")
public class Cotisation {
	
	@Id
	private Integer id;
	private String code;
	private String libelle;
	
	@Column(name="taux_salarial")
	private BigDecimal tauxSalarial;
	
	@Column(name="taux_patronal")
	private BigDecimal tauxPatronal;
	
	@ManyToMany(mappedBy="cotisations")
	private List<ProfilRemuneration> profilsremunerations;
	
	
	private Boolean imposable = false;
	
	
	
	@Override
	public String toString() {
		return "Cotisation [id=" + id + ", code=" + code + ", libelle=" + libelle + "]";
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public BigDecimal getTauxSalarial() {
		return tauxSalarial;
	}
	public void setTauxSalarial(BigDecimal tauxSalarial) {
		this.tauxSalarial = tauxSalarial;
	}
	public BigDecimal getTauxPatronal() {
		return tauxPatronal;
	}
	public void setTauxPatronal(BigDecimal tauxPatronal) {
		this.tauxPatronal = tauxPatronal;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Boolean getImposable() {
		return imposable;
	}
	public void setImposable(Boolean imposable) {
		this.imposable = imposable;
	}
}
