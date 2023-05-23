package com.codingdojo.sofia.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.sofia.modelos.Etiqueta;

@Repository
public interface RepositorioEtiquetas extends CrudRepository<Etiqueta, Long> {
	
	List<Etiqueta> findAll();
	
	//SELECT * FROM etiquetas WHERE tema=TEMA QUE RECIBIMOS
	Etiqueta findByTema(String t); //Buscando en base a un tema
	//dato que recibimos
	
	
	
}
