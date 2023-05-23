package com.codingdojo.sofia.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.sofia.modelos.Etiqueta;
import com.codingdojo.sofia.modelos.Pregunta;
import com.codingdojo.sofia.modelos.Respuesta;
import com.codingdojo.sofia.repositorios.RepositorioEtiquetas;
import com.codingdojo.sofia.repositorios.RepositorioPreguntas;
import com.codingdojo.sofia.repositorios.RepositorioRespuestas;

@Service
public class Servicios {
	
	@Autowired
	private RepositorioPreguntas repoPreguntas;
	
	@Autowired
	private RepositorioRespuestas repoRespuestas;
	
	@Autowired
	private RepositorioEtiquetas repoEtiquetas;
	
	public List<Pregunta> todasPreguntas(){
		return repoPreguntas.findAll();
	}
	
	public Pregunta guardarPregunta(Pregunta nuevaPregunta) {
		return repoPreguntas.save(nuevaPregunta);
	}
										//******
	public Etiqueta encuentraEtiqueta(String tema) {
		//OBJ Etiqueta -> id= 1= "JAVA", createdAt= 2023-05-05
		return repoEtiquetas.findByTema(tema);
	}
	
	public Etiqueta guardarEtiqueta(Etiqueta nuevaEtiqueta) {
		return repoEtiquetas.save(nuevaEtiqueta);
	}
	
	public Pregunta encuentraPregunta(Long id) {
		return repoPreguntas.findById(id).orElse(null);
	}
	
	public Respuesta guardarRespuesta(Respuesta nuevaRespuesta) {
		return repoRespuestas.save(nuevaRespuesta);
	}
	
}
