package entidade;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="aquario")
public class Aquario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	
	@Column(name="dataMedicao")
	private String dataMedicao;
	
	@Column(name="horaMedicao")
	private String horaMedicao;
	
	@Column(name="tempAgua")
	private float tempAgua;
	
	@Column(name="tempTampa")
	private float tempTampa;
	
	@Column(name="tempAmb")
	private float tempAmb;
	
	@Column(name="nivelSump")
	private int nivelSump;
	
	@Column(name="nivelRepo")
	private int nivelRepo;
	
	@Column(name="luzLigada")
	private int luzLigada;
	
	public Aquario(){
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataMedicao() {
		return dataMedicao;
	}

	public void setDataMedicao(String dataMedicao) {
		this.dataMedicao = dataMedicao;
	}

	public String getHoraMedicao() {
		return horaMedicao;
	}

	public void setHoraMedicao(String horaMedicao) {
		this.horaMedicao = horaMedicao;
	}

	public float getTempAgua() {
		return tempAgua;
	}

	public void setTempAgua(float tempAgua) {
		this.tempAgua = tempAgua;
	}

	public float getTempTampa() {
		return tempTampa;
	}

	public void setTempTampa(float tempTampa) {
		this.tempTampa = tempTampa;
	}

	public float getTempAmb() {
		return tempAmb;
	}

	public void setTempAmb(float tempAmb) {
		this.tempAmb = tempAmb;
	}

	public int getNivelSump() {
		return nivelSump;
	}

	public void setNivelSump(int nivelSump) {
		this.nivelSump = nivelSump;
	}

	public int getNivelRepo() {
		return nivelRepo;
	}

	public void setNivelRepo(int nivelRepo) {
		this.nivelRepo = nivelRepo;
	}

	public int getLuzLigada() {
		return luzLigada;
	}

	public void setLuzLigada(int luzLigada) {
		this.luzLigada = luzLigada;
	}

		
}	
