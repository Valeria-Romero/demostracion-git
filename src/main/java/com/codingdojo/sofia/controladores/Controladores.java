package com.codingdojo.sofia.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.sofia.modelos.Etiqueta;
import com.codingdojo.sofia.modelos.Pregunta;
import com.codingdojo.sofia.servicios.Servicios;
@Controller
public class Controladores {

		@Autowired
		private Servicios servicio;
		
		@GetMapping("/")
		public String index(Model model) {
			
			
			//List<Pregunta> preguntas = servicio.todasPreguntas();
			model.addAttribute("preguntas", servicio.todasPreguntas());//***
			return "index.jsp";
			
		}
		@GetMapping("/nueva")
		public String nueva(@ModelAttribute("pregunta")Pregunta pregunta) {
			return "nueva.jsp";
		}
		@PostMapping("/crear")
		public String crear(@Valid @ModelAttribute("pregunta") Pregunta pregunta,
							BindingResult result,
							@RequestParam("textoEtiquetas")String textoEtiquetas) {
			
			if(result.hasErrors()) {
			return "nueva.jsp";
			} else {
				//textoEtiquets= "Programacion, tecnologia, java"
				//listaEtiquetas=("procamacion", tecnologia, java)
			String[] listaEtiquetas = textoEtiquetas.trim().split(",");
			List<Etiqueta> etiquetas = new ArrayList<>();
			
			for(String tema:listaEtiquetas) {
				Etiqueta et = servicio.encuentraEtiqueta(tema);
				
				if(et== null) {
					//no existe debemos crear 
					Etiqueta nuevaEtiqueta = new Etiqueta();
					nuevaEtiqueta.setTema(tema);
					servicio.guardarEtiqueta(nuevaEtiqueta);
					etiquetas.add(nuevaEtiqueta);
				} else {
					etiquetas.add(et);
				}
			}
			
			pregunta.setEtiquetas(etiquetas);
			servicio.guardarPregunta(pregunta);
			return "redirect:/";
			
			
			}
		}

	}

