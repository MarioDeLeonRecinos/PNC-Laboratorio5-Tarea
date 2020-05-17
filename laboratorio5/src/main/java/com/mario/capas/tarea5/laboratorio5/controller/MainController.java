package com.mario.capas.tarea5.laboratorio5.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mario.capas.tarea5.laboratorio5.dao.EstudianteDAO;
import com.mario.capas.tarea5.laboratorio5.domain.Estudiante;

@Controller
public class MainController {

	@Autowired
	private EstudianteDAO estudianteDAO;

	@RequestMapping("/inicio")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("estudiante",new Estudiante());
		mav.setViewName("index");
		
		return mav;
	}

	@RequestMapping("/guardar")
	public ModelAndView guardar(@Valid @ModelAttribute Estudiante estudiante,BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			mav.setViewName("index");
		} else {
			mav.addObject("estudiante",new Estudiante());
			mav.setViewName("index");
			estudianteDAO.save(estudiante);
		}
		
		return mav;
	}
	
	@RequestMapping("/listado")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		try {
			estudiantes = estudianteDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("listado");

		return mav;
	}

}
