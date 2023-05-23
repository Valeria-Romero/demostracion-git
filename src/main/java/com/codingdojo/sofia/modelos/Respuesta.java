package com.codingdojo.sofia.modelos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="respuestas")
public class Respuesta {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String texto;

	@Column(updatable=false) //Nunca más se actualiza
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt; 
	
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date updatedAt;

	@ManyToOne(fetch = FetchType.LAZY)//mi respuesta llave foranesa
	@JoinColumn(name="pregunta_id")  //JoinColumn llave forarnea
	private Pregunta pregunta;//******
			//Objeto de pregunta CLASE   //Atributo NOMBRE VARIABLE
	public Respuesta() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
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

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}
	
}
