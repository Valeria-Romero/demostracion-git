package com.codingdojo.sofia.modelos;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="preguntas")
public class Pregunta {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String contenido;
	
	@Column(updatable=false) //Nunca más se actualiza
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt; 
	
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date updatedAt;

	//maeo contraparte
	@OneToMany(mappedBy="pregunta", fetch = FetchType.LAZY)
	List<Respuesta> respuestas;
	//espejeo dos tablas que se relacionan
	//estoy relacionando con respuestas
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name="etiquetas_preguntas",
			joinColumns = @JoinColumn(name="pregunta_id"),
			inverseJoinColumns = @JoinColumn(name="etiqueta_id")
			)
	private List<Etiqueta> etiquetas;//atributo al que se une
	
	public Pregunta() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@PrePersist //SE EJECUTA CUANDO HAGO LA CREACIÓN DE UN REGISTRO
	protected void onCreated() {
		this.createdAt = new Date();
	}

	@PreUpdate //ANTES DE QUE SE ACTUALICE UN REGISTRO, ME HACE LA FUNCION updatedeAt
	protected void onUpdate() {
		this.updatedAt=new Date();
	}

	public List<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

	public List<Etiqueta> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(List<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}
	
	

}
