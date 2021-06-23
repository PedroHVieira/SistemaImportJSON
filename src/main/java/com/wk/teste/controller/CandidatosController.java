package com.wk.teste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wk.teste.model.Candidatos;
import com.wk.teste.model.MyUserDetails;
import com.wk.teste.repository.CandidatosRepository;


@Controller
@RequestMapping("/candidatos")
public class CandidatosController {

	@Autowired
	private CandidatosRepository candidatoRepo;
	
	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ModelAndView abrir(@AuthenticationPrincipal MyUserDetails user) {
		ModelAndView view = new ModelAndView("candidatos/candidatos");
		
		return view.addObject("user", user);
	}
	
	@GetMapping("/buscar")
	@PreAuthorize("hasRole('ADMIN')")
	public ModelAndView buscar() {
		ModelAndView view = new ModelAndView("candidatos/tabela_candidatos");
		
		List<Candidatos> lista = candidatoRepo.findAll();		
		
		return view.addObject("lista", lista);
	}
}
